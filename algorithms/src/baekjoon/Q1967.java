package baekjoon;

//https://www.acmicpc.net/problem/1967

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//맞기는 맞았는데 실행시간이 너무 오래 걸렸음 

public class Q1967 {
	static int N;
	static class Node {
		ArrayList<Integer> cs;
		ArrayList<Integer> csw;
		int p, pw;
		Node(){
			cs = new ArrayList<Integer>();
			csw = new ArrayList<Integer>();
		}
	}
	static class Pair {
		int node;
		int dis;
		Pair (int node, int dis) {
			this.node = node; this.dis = dis;
		}
	}
	static Node[] tree;
	static int[] children;
	static boolean[] v;
	static boolean[] del;
	static int ans = -1;
	
	static void BFS(int node) {
		v = new boolean[N+1];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(node, 0));
		v[node] = true;
		
		while(!q.isEmpty()) {
			Pair h = q.poll();
			if (ans < h.dis) ans = h.dis;
			
			ArrayList<Integer> go = new ArrayList<Integer>();
			ArrayList<Integer> gow = new ArrayList<Integer>();
			
			go.add(tree[h.node].p);
			gow.add(tree[h.node].pw);
			
			go.addAll(tree[h.node].cs);
			gow.addAll(tree[h.node].csw);
			
			for (int i=0; i<go.size(); i++) {
				int t = go.get(i);
				if (!del[t] && t >= 1 && !v[t]) {
					q.add(new Pair(t, gow.get(i) + h.dis));
					v[t] = true;
				}
			}
		}
		
		del[node] = true;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new Node[N+1];
		children = new int[N+1];
		del = new boolean[N+1];
		for (int i=0; i<=N; i++) tree[i] = new Node();
		
		for (int i=1; i<N; i++) {
			String[] tmp = br.readLine().split(" ");
			int parent = Integer.parseInt(tmp[0]);
			int child = Integer.parseInt(tmp[1]);
			int weight = Integer.parseInt(tmp[2]);
			
			tree[parent].cs.add(child);
			tree[parent].csw.add(weight);
			tree[child].p = parent;
			tree[child].pw = weight;
			children[parent]++;
		}
		
		for (int i=1; i<=N; i++) {
			if (children[i] == 0) {
				BFS(i);
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}
}
