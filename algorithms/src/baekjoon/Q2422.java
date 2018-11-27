package baekjoon;

// https://www.acmicpc.net/problem/2422

import java.util.Scanner;

public class Q2422 {
	static int N, M;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] nm = new boolean[N+1][N+1];
		
		for (int i=1; i<=M; i++) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			nm[f][s] = true;
			nm[s][f] = true;
		}
		
		int count = 0;
		for (int i=1; i<=N; i++) {
			for (int j=i+1; j<=N; j++) {
				for (int k=j+1; k<=N; k++) {
					if (!nm[i][j] && !nm[i][k] && !nm[j][k]) count++;
				}
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}
}