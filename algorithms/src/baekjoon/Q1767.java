package baekjoon;

// https://www.acmicpc.net/problem/1767

import java.util.Arrays;
import java.util.Scanner;

public class Q1767 {
	static long[][][] d = new long[101][101][101];

	static long go(int n, int m, int k) {
		if (k == 0) return 1;
		if (n <= 0 || m <= 0 || k < 0) return 0;
		
		if (d[n][m][k] != -1) return d[n][m][k];
		
		d[n][m][k] = 
				go(n - 1, m, k) + 
				go(n - 1, m - 1, k - 1) * m + 
				go(n - 1, m - 2, k - 2) * m * (m - 1) / 2 + 
				go(n - 2, m - 1, k - 2) * m * (n - 1);
		
		d[n][m][k] %= 1000001;
		return d[n][m][k];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				Arrays.fill(d[i][j], -1);
			}
		}
		System.out.println(go(n, m, k));
		sc.close();
	}
}
