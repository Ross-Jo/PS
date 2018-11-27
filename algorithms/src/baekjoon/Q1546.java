package baekjoon;

// https://www.acmicpc.net/problem/1546

import java.util.Scanner;

public class Q1546 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // N은 1000이하
		double[] scores = new double[N];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			scores[i] = tmp;
			if (tmp >= max)
				max = tmp;
		}

		double sum = 0.0;
		for (int i = 0; i < N; i++) {
			scores[i] = ((double) scores[i] / max) * 100;
			sum += scores[i];
		}

		System.out.printf("%.2f", sum / N);

		sc.close();
	}
}