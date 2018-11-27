package baekjoon;

// https://www.acmicpc.net/problem/1932

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼각형의 크기 n(1<=n<=500)
// 숫자는 모두 정수이며 범위는 0이상 99이하
public class Q1932 {

	public static int findMax(int[][] tri, int size_of_tri) {

		int[][] dp = new int[size_of_tri + 1][size_of_tri + 1];
		int max = tri[1][1];

		for (int i = 1; i <= size_of_tri; ++i) {
			for (int j = 1; j <= i; ++j) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + tri[i][j];
				if (max < dp[i][j])
					max = dp[i][j];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
//			String s = br.readLine(); // 입력받을 값이 String인 경우
//			int a = br.read(); // 입력받을 값이 int인 경우
//			int b = Integer.parseInt(br.readLine()); // int값 + enter까지 입력받을 때

			int size_of_tri = Integer.parseInt(br.readLine());
			int[][] tri = new int[size_of_tri + 1][size_of_tri + 1];

			StringTokenizer st = null;

			for (int i = 1; i <= size_of_tri; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= i; ++j) {
					tri[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println(findMax(tri, size_of_tri));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}