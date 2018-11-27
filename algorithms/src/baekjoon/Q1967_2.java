package baekjoon;

//https://www.acmicpc.net/problem/1967

import java.util.ArrayList;
import java.util.Scanner;

//참고 : http://mygumi.tistory.com/226

public class Q1967_2 {
	static int v, u, r;
	static ArrayList<Node>[] adj;
	static int[] dist;
	
	static class Node {
		int v, w;
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static void dfs(int v, int d) {
		dist[v] = d;
		
		if (dist[v] > r) {
			r = dist[v];
			u = v;
		}
		
		for (Node node: adj[v]) {
			int next = node.v;
			int weight = node.w;
			if (dist[next] == 0) {
				dfs(next, d + weight);
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		adj = (ArrayList<Node>[]) new ArrayList[10001]; // ArrayList 배열. 유의해서 볼 것
		dist = new int[10001];
		
		for (int i=1; i<=10000; i++) adj[i] = new ArrayList<>();
		int n = sc.nextInt();
		
		for (int i=0; i<n-1; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			int weight = sc.nextInt();
			
			adj[parent].add(new Node(child, weight));
			adj[child].add(new Node(parent, weight));
		}
		
		dfs(1, 0);
		
		r = 0;
		dist = new int[10001];
		
		dfs(u, 0);
		System.out.println(r);
		
		sc.close();
	}
}