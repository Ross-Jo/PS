package baekjoon;

//https://www.acmicpc.net/problem/11725

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q11725_2 {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>(100000);
	static int[] parent = new int[100000];

	// 아직 탐색하지 않은 이웃 노드만을 DFS하며 부모를 자신으로 설정
	static void DFS(int cur) {
		for (int next : adj.get(cur))
			if (parent[next] == -1) {
				parent[next] = cur;
				DFS(next);
			}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) adj.add(new ArrayList<Integer>());

		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		Arrays.fill(parent, -1);
		DFS(0);
		for (int i = 1; i < N; i++) System.out.format("%d\n", parent[i] + 1);
		sc.close();
	}
}