package baekjoon;

//https://www.acmicpc.net/problem/1766

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Q1766 {
	static int N, M;
	static ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
	static int[] indegree;
	static boolean[] visit;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		indegree = new int[N+1];
		visit = new boolean[N+1];
		StringBuilder ans = new StringBuilder();
		
		for (int i=0; i<=N; i++) g.add(new ArrayList<>());
		
		for (int i=0; i<M; i++) {
			tmp = br.readLine().split(" ");
			int f = Integer.parseInt(tmp[0]);
			int s = Integer.parseInt(tmp[1]);
			g.get(f).add(s);
			indegree[s]++;
		}
		
		for (int i=1; i<=N; i++) Collections.sort(g.get(i));
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=1; i<=N; i++) {
			if (q.isEmpty()) {
				for (int j=1; j<=N; j++) {
					if (!visit[j] && indegree[j]==0) {
						q.add(j);
						visit[j] = true;
						break;
					}
				}
			}
			int h = q.poll();
			ans.append(h+" ");
			for (int j: g.get(h)) {
				--indegree[j];
			}
		}
		
		System.out.println(ans.toString());
		br.close();
	}
}