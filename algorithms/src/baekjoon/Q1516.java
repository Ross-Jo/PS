package baekjoon;

//https://www.acmicpc.net/problem/1516

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1516 {
	static int N;
	static boolean[][] g;
	static int[] indegree;
	static int[] time;
	static int[] ans;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		g = new boolean[N+1][N+1];
		indegree = new int[N+1];
		time = new int[N+1];
		ans = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			time[i] = sc.nextInt();
			for (;;) {
				int curr = sc.nextInt();
				if (curr == -1) break;
				g[curr][i] = true;
				indegree[i]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=1; i<=N; i++) {
			if(indegree[i]==0) {
				q.add(i);
				ans[i] = time[i];
			}
		}
		
		for (int i=1; i<=N; i++) {
			int h = q.poll();
			
			for (int j=1; j<=N; j++) {
				if(g[h][j]) {
					ans[j] = Math.max(ans[j], ans[h]);
					if(--indegree[j]==0) {
						q.add(j);
						ans[j] += time[j];
					}
				}
			}
		}
		
		for (int i=1; i<=N; i++) System.out.println(ans[i]);
		
		sc.close();
	}
}
