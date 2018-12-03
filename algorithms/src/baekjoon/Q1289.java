package baekjoon;

// https://www.acmicpc.net/problem/1289
// 오답 - 이유 : 높은 시간복잡도 및 갔던 path를 2번 방문 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	static int start;
	static int ans = 0;
	static final int MOD = 1000000007;
	
	static void dfs(int here, int pathWeight) {
		v[here] = true;
		
		if (here != start) {
			ans += pathWeight % MOD;
		}
		
		int s = tree[here].c.size();
		for (int i=0; i<s; i++) {
			int next = tree[here].c.get(i);
			if(!v[next]) {
				dfs(next, (pathWeight * tree[here].w.get(i)) % MOD);
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new Node[N+1];
		
		for (int i=0; i<tree.length; i++) tree[i] = new Node();
		
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
		
		for (int i=1; i<=N; i++) {
			v = new boolean[N+1];
			start = i;
			dfs(i, 1);
		}
		
		System.out.println(ans % MOD);
		
		br.close();
	}
}