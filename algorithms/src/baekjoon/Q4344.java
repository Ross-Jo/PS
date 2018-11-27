package baekjoon;

// https://www.acmicpc.net/problem/4344

import java.util.Scanner;

//1<=N<=1000

public class Q4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {

			int N = sc.nextInt();

			int sum = 0;
			int[] scores = new int[N];
			int count = 0;

			for (int j = 0; j < N; j++) {
				scores[j] = sc.nextInt();
				sum += scores[j];
			}

			double average = (double) sum / N;

			for (int j = 0; j < N; j++) {
				if (scores[j] > average)
					count++;
			}

			System.out.printf("%.3f%%\n", (double) count / N * 100);
		}
		sc.close();
	}
}