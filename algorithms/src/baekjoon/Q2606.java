package baekjoon;

// https://www.acmicpc.net/problem/2606

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2606 {
	static class Node {
		int nodeNum;
		boolean visited = false;

		public Node(int nodeNum) {
			this.nodeNum = nodeNum;
		}

		public void visited() {
			this.visited = true;
		}
	}

	public static void BFS(Node root, ArrayList<ArrayList<Node>> g) {
		Queue<Node> q = new LinkedList<Node>();

		root.visited();
		q.add(root);

		while (!q.isEmpty()) {
			Node d = q.poll();
			for (int i = 1; i < g.get(d.nodeNum).size(); i++) {
				if (g.get(d.nodeNum).get(i).visited == false) {
					g.get(d.nodeNum).get(i).visited = true;
					q.add(g.get(g.get(d.nodeNum).get(i).nodeNum).get(0));
				}
			}
			g.get(d.nodeNum).get(0).visited = true;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num_of_com = sc.nextInt();
		int con_pairs = sc.nextInt();

		ArrayList<ArrayList<Node>> g = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i <= num_of_com; i++) {
			g.add(new ArrayList<Node>());
			g.get(i).add(new Node(i));
		}

		for (int i = 0; i < con_pairs; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			g.get(l).add(new Node(r));
			g.get(r).add(new Node(l));
		}

		BFS(g.get(1).get(0), g);

		int count = 0;
		for (int i = 2; i < g.size(); i++) {
			if (g.get(i).get(0).visited == true)
				count++;
		}

		System.out.println(count);

		sc.close();
	}
}