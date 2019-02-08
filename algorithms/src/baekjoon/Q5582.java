package baekjoon;

// https://www.acmicpc.net/problem/5582

import java.util.Scanner;

public class Q5582 {
	static char[] a, b;
	static int[][] dp = new int[4001][4001];
	static int ans = 0;
	
	public static void LCS() {
		for (int i=1; i<=a.length; i++) {
			for (int j=1; j<=b.length; j++) {
				if (a[i-1] == b[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					if (ans < dp[i][j]) ans = dp[i][j];
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextLine().toCharArray();
		b = sc.nextLine().toCharArray();
		
		LCS();
		System.out.println(ans);
		
		sc.close();
	}
}
