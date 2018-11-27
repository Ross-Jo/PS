package baekjoon;

// https://www.acmicpc.net/problem/10844

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//1<=N<=100, 자연수
//참고 : debuglog.tistory.com/81
public class Q10844 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());

			int[][] dp = new int[100][10];

			Arrays.fill(dp[0], 1);
			dp[0][0] = 0;

			for (int i = 1; i < N; i++) {
				for (int last_num = 0; last_num < 10; last_num++) {
					if (last_num == 0) {
						dp[i][last_num] = dp[i - 1][1];
					} else if (last_num == 9) {
						dp[i][last_num] = dp[i - 1][8];
					} else {
						dp[i][last_num] = (dp[i - 1][last_num - 1] + dp[i - 1][last_num + 1]) % 1000000000;
					}
				}
			}

			int sum = 0;
			for (int x : dp[N - 1]) {
				sum = (sum + x) % 1000000000;
			}
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}