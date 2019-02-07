package baekjoon;

// https://www.acmicpc.net/problem/1958
// [다시풀기]

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1958 {
	static int max = 0;
	static char[] a, b, c;
	static int[][][] dp = new int[101][101][101];
	
	public static void LCS() {
		for (int i=1; i<=a.length; i++) {
			for (int j=1; j<=b.length; j++) {
				for (int k=1; k<=c.length; k++) {
					if (a[i-1] == b[j-1] && b[j-1] == c[k-1]) {
						dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
					} else {
						dp[i][j][k] = Math.max(Math.max(dp[i-1][j][k], dp[i][j-1][k]), dp[i][j][k-1]);
					}
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		c = br.readLine().toCharArray();
		
		LCS();
		bw.write(Integer.toString(dp[a.length][b.length][c.length]));
		
		bw.close();
		br.close();
	}
}
