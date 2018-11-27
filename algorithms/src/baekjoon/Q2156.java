package baekjoon;

// https://www.acmicpc.net/problem/2156

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {
	public static int chooseAmongThree(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

	public static int findMaxSum(int N, int[] glass) {
		int[] dp = new int[N + 1];

		dp[1] = glass[1];
		if (N > 1)
			dp[2] = glass[1] + glass[2];
		if (N > 2)
			dp[3] = chooseAmongThree(glass[1] + glass[2], glass[2] + glass[3], glass[3] + glass[1]);

		for (int i = 4; i <= N; ++i) {
			int not_choose = chooseAmongThree(dp[i - 2], dp[i - 3] + glass[i - 1],
					dp[i - 4] + glass[i - 2] + glass[i - 1]);
			int choose = Math.max(dp[i - 2], dp[i - 3] + glass[i - 1]) + glass[i];
			dp[i] = Math.max(not_choose, choose);
		}
		return dp[N];
	}

	// 1<=N<=10,000
	// 포도주의 양은 1,000 이하의 정수
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			int N = Integer.parseInt(br.readLine());
			int[] glass = new int[N + 1];
			for (int i = 1; i <= N; ++i) {
				glass[i] = Integer.parseInt(br.readLine());
			}
			System.out.println(findMaxSum(N, glass));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}