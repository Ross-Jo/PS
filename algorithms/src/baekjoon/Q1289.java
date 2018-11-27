package baekjoon;

// https://www.acmicpc.net/problem/1289

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q1289 {
	static int N;
	static class Node {
		ArrayList<Integer> c;
		ArrayList<Integer> w;
		public Node() {
			c = new ArrayList<>();
			w = new ArrayList<>();
		}
	}
	static Node[] tree;
	static boolean[] v;
	static int[][] dp;
	static int start;
	static int ans = 0;
	static final int MOD = 1000000007;
	
	static void dfs(int here, int pathWeight, int des) {
		v[here] = true;
		
		if (here == start) {
			int ret = dp[des][start];
			if (ret != -1) return;
		}
		
		if (here != start) {
			int calc = pathWeight % MOD;
			dp[start][here] = calc;
			dp[here][start] = calc;
			ans += pathWeight % MOD;
		}
		
		int s = tree[here].c.size();
		for (int i=0; i<s; i++) {
			int next = tree[here].c.get(i);
			if(!v[next]) {
				dfs(next, (pathWeight * tree[here].w.get(i)) % MOD, des);
			}
		}
		
		System.out.println("here: " + here + " " +ans);
//		v[here] = false;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new Node[N+1];
		dp = new int[N+1][N+1];
		
		for (int i=0; i<tree.length; i++) tree[i] = new Node();
		for (int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
		
		for (int i=0; i<N-1; i++) {
			String[] tmp = br.readLine().split(" ");
			int l = Integer.parseInt(tmp[0]);
			int r = Integer.parseInt(tmp[1]);
			int w = Integer.parseInt(tmp[2]);
			tree[l].c.add(r);
			tree[l].w.add(w);
			tree[r].c.add(l);
			tree[r].w.add(w);
		}
		
		for (int i=1; i<N; i++) {
			for (int j=i+1; j<=N; j++) {
				v = new boolean[N+1];
				start = i;
				dfs(i, 1, j);
			}
		}
		
		System.out.println(ans % MOD);
		
		br.close();
	}
}