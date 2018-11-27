package baekjoon;

// https://www.acmicpc.net/problem/2747

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N은 45보다 작거나 같은 자연수
public class Q2747 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());

			int[] dp = new int[N + 1];
			dp[0] = 0;
			dp[1] = 1;

			for (int i = 2; i <= N; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}

			System.out.println(dp[N]);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}