package baekjoon;

// https://www.acmicpc.net/problem/2455

import java.util.Scanner;

public class Q2455 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[4][2];

		for (int i = 0; i < 4; i++) {
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			sum -= matrix[i][0];
			sum += matrix[i][1];
			if (max <= sum)
				max = sum;
		}

		System.out.println(max);

		sc.close();
	}
}