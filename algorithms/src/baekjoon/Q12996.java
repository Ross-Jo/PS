package baekjoon;

// https://www.acmicpc.net/problem/12996

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class question_109 {
//	static int s;
//	static int A, B, C;
//	static int[][][][] d = new int[51][51][51][51];
//	
//	static int solve(int i, int a, int b, int c) {
//		if (a > A || b > B || c > C) return 0;
//		
//		if (i == s && a == A && b == B && c == C) return 1;
//		
//		if (d[i][a][b][c] != -1) return d[i][a][b][c];
//		d[i][a][b][c]
//		
//		if (a < A) d[i+1][a+1][b][c] = solve(i+1, a+1, b, c);
//		if (b < B) d[i+1][a][b+1][c] = solve(i+1, a, b+1, c);
//		if (c < C) d[i+1][a][b][c+1] = solve(i+1, a, b, c+1);
//		if (a < A && b < B) d[i+1][a+1][b+1][c] = solve(i+1, a+1, b+1, c);
//		if (a < A && c < C) d[i+1][a+1][b][c+1] = solve(i+1, a+1, b, c+1);
//		if (b < B && c < C) d[i+1][a][b+1][c+1] = solve(i+1, a, b+1, c+1);
//		if (a < A && b < B && c < C) d[i+1][a+1][b+1][c+1] = solve(i+1, a+1, b+1, c+1);
//		
//		
//		return d[i][a][b][c];
//	}
//	
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		
//		s = sc.nextInt();
//		A = sc.nextInt(); B = sc.nextInt(); C = sc.nextInt();
//		
//		for (int i=0; i<51; i++) {
//			for (int j=0; j<51; j++) {
//				for (int k=0; k<51; k++) {
//					Arrays.fill(d[i][j][k], -1);
//				}
//			}
//		}
//		
//		
//		
//		sc.close();
//	}
//}

import java.util.*;

public class Q12996 {
	static final long mod = 1000000007;
	static long[][][][] d = new long[51][51][51][51];

	static long go(int n, int a, int b, int c) {
		if (n == 0) {
			if (a == 0 && b == 0 && c == 0) return 1;
			else return 0;
		}
		
		if (a < 0 || b < 0 || c < 0) return 0;
		
		long ans = d[n][a][b][c];
		if (ans != -1) return ans;
		
		ans = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					if (i + j + k == 0) continue;
					ans += go(n - 1, a - i, b - j, c - k);
				}
			}
		}
		ans %= mod;
		
		d[n][a][b][c] = ans;
		return ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= a; j++) {
				for (int k = 0; k <= b; k++) {
					for (int l = 0; l <= c; l++) {
						d[i][j][k][l] = -1;
					}
				}
			}
		}
		System.out.println(go(n, a, b, c));
		sc.close();
	}
}