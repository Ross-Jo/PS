package baekjoon;

//https://www.acmicpc.net/problem/11725

import java.util.ArrayList;
import java.util.Scanner;

public class Q11725 {
	static class Node {
		int num;
		ArrayList<Node> adjacent;
		Node(int num) {
			this.num = num;
			adjacent = new ArrayList<Node>();
		}
		
	}
	static int N;
	static Node[] nodes;
	static boolean[] v;
	static int[] parents;
	
	static void traverse(Node t) {
		v[t.num] = true;
		for (Node e: t.adjacent) {
			if (!v[e.num]) {
				parents[e.num] = t.num;
				traverse(e);
			}
		}
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nodes = new Node[N+1];
		parents = new int[N+1];
		v = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			nodes[i] = new Node(i);
		}
		
		for (int i=0; i<N-1; i++) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			
			nodes[f].adjacent.add(nodes[s]);
			nodes[s].adjacent.add(nodes[f]);
		}
		
		traverse(nodes[1]);
		
		for (int i=2; i<=N; i++) {
			System.out.println(parents[i]);
		}
		
		sc.close();
	}
}