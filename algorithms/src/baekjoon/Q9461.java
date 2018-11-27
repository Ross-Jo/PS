package baekjoon;

// https://www.acmicpc.net/problem/9461

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1<=N<=100
// 1. 자료형이 담을 수 있는 크기에 항상 주의하기
// 2. 코너케이스에 대하여 항상 신경쓰기
// 3. 인덱스를 제대로 매겨서 규칙을 발견하자
public class Q9461 {

	public static long findSide(int N) {

		long[] dp = new long[101];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;

		for (int i = 6; i <= N; ++i) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		return dp[N];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; ++i) {
				int N = Integer.parseInt(br.readLine());
				System.out.println(findSide(N));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}