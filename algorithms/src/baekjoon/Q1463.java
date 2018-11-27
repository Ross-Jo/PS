package baekjoon;

// https://www.acmicpc.net/problem/1463

import java.util.Scanner;

//1<=N<=10,000,000
public class Q1463 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] dp = new int[N + 1];

		dp[1] = 0;
		if (N >= 2)
			dp[2] = 1;
		if (N >= 3)
			dp[3] = 1;

		for (int i = 4; i <= N; i++) {
			if (i % 3 == 0 && i % 2 == 0)
				dp[i] = Math.min(Math.min(dp[i / 3], dp[i / 2]), dp[i - 1]) + 1;
			else if (i % 3 != 0 && i % 2 == 0)
				dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
			else if (i % 3 == 0 && i % 2 != 0)
				dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
			else
				dp[i] = dp[i - 1] + 1;
		}

		System.out.println(dp[N]);

		sc.close();
	}
}