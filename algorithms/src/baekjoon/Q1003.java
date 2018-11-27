package baekjoon;

// https://www.acmicpc.net/problem/1003

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1003 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[2][41];
		dp[0][0] = 1; dp[0][1] = 0;
		dp[1][0] = 0; dp[1][1] = 1;
		
		for (int i=2; i<dp[0].length; i++) {
			dp[0][i] = dp[0][i-2] + dp[0][i-1];
			dp[1][i] = dp[1][i-2] + dp[1][i-1];
		}
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[0][N] + " " + dp[1][N]);
		}
		
		br.close();
	}
}