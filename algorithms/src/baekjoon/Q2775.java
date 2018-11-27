package baekjoon;

// https://www.acmicpc.net/problem/2775

import java.util.Scanner;

//1<=k<=14, 1<=n<=14
//문제에서 준 저장공간이 충분하기 때문에 2차원 배열을 사용한다.
public class Q2775 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();

			int[][] apt = new int[k + 1][n + 1];

			for (int j = 1; j <= n; j++) {
				apt[0][j] = j;
			}
			for (int j = 1; j <= k; j++) {
				for (int l = 1; l <= n; l++)
					apt[j][l] = apt[j][l - 1] + apt[j - 1][l];
			}
			System.out.println(apt[k][n]);
		}
		sc.close();
	}
}