package baekjoon;

// https://www.acmicpc.net/problem/2252

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2252 {
	static int N, M;
	static ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
	static int[] indegree;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		indegree = new int[N+1];
		StringBuilder ans = new StringBuilder();
		
		for (int i=0; i<=N; i++) g.add(new ArrayList<>());
		
		for (int i=0; i<M; i++) {
			tmp = br.readLine().split(" ");
			int f = Integer.parseInt(tmp[0]);
			int s = Integer.parseInt(tmp[1]);
			g.get(f).add(s);
			indegree[s]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i=1; i<=N; i++) if(indegree[i]==0) q.add(i);
		
		for (int i=1; i<=N; i++) {
			int h = q.poll();
			ans.append(h+" ");
			for (int j: g.get(h)) {
				if(--indegree[j] == 0) {
					q.add(j);
				}
			}
		}
		
		System.out.println(ans.toString());
		br.close();
	}
}
