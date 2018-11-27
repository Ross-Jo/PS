package baekjoon;

// https://www.acmicpc.net/problem/1149

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1149 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		int[][] dp = new int[3][N+1];
		
		for (int i=0; i<N; i++) {
			cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=0; j<3; j++) {
				int tmp = Integer.MAX_VALUE;
				for (int k=0; k<3; k++) {
					if (((1<<k) & (((1<<3)-1) - (1<<j))) > 0) {
						tmp = Math.min(tmp, dp[k][i-1]);
					}
				}
				dp[j][i] = tmp + cost[i-1][j];
			}
		}
		
		System.out.println(Math.min(Math.min(dp[0][N], dp[1][N]), dp[2][N]));
		
		br.close();
	}
}