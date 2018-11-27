package baekjoon;

// https://www.acmicpc.net/problem/1325
// 시간 초과

import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Comparator;

class Graph {

	class Node {
		int data;
		LinkedList<Node> adjacent;

		Node(int data) {
			this.data = data;
			adjacent = new LinkedList<Node>();
		}
	}

	Node[] nodes;
	boolean[] visits;
	int[] hits;
	int maxHits = 0;

	Graph(int size) {
		nodes = new Node[size + 1];
		hits = new int[size + 1];
		for (int i = 0; i <= size; i++) nodes[i] = new Node(i);
	}

	void addEdge(int i1, int i2) { // 유향 그래프
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if (!n2.adjacent.contains(n1)) { // n2 -> n1
			n2.adjacent.add(n1);
		}
	}

	void dfs(Node r) {
		if (r == null) return;
		visits[r.data] = true;
		for (Node n : r.adjacent) {
			if (visits[n.data] == false) {
				dfs(n);
			}
		}
	}

	void dfs(int index) {
		Node startPoint = nodes[index];
		visits = new boolean[nodes.length];
		dfs(startPoint);
		
		int counter = 0;
		for (boolean isVisited: visits) if(isVisited) counter++;
		hits[index] = counter;
		
		this.maxHits = Math.max(maxHits, counter);
	}
}

class Ascending implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
}

public class Q1325 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Graph g = new Graph(N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			g.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i <= N; i++) g.dfs(i);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for (int i=1; i<g.hits.length; i++) {
			if (g.hits[i] == g.maxHits) ans.add(i);
		}
		ans.sort(new Ascending());

		// 참고(String.valueOf): https://stackoverflow.com/questions/11875815/bufferedwriter-is-acting-strange
		for (int i = 0; i < ans.size(); i++) {
			bw.write(ans.get(i) + " ");
		}

		bw.flush();

		br.close();
		bw.close();
	}
}
