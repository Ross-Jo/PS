package baekjoon;

// https://www.acmicpc.net/problem/2293

import java.util.Scanner;

public class Q2293 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] coin = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			coin[i] = sc.nextInt();
		}

		int[] dp = new int[k + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= coin[i]) {
					dp[j] += dp[j - coin[i]];
					// 기존에 dp[j]를 만들어 낼 수 있는 조합 +coin[i]를 추가함으로서 새로 얻는 조합
					// (coin[i]를 추가함으로서 (마치 다 된 밥에 숟가락 얹듯이) 얻을 수 있는 조합은 이미 j-coin[i]에서 계산이 되어 있음)
				}
			}
		}
		System.out.println(dp[k]);
		sc.close();
	}
}