package baekjoon;

// https://www.acmicpc.net/problem/1978

import java.util.Scanner;

public class Q1978 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] prime = new int[1001];

		prime[1] = 1;

		for (int i = 2; i <= Math.sqrt(1000); i++) {
			for (int j = 2; i * j <= 1000; j++) {
				prime[i * j] = 1;
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (prime[sc.nextInt()] == 0)
				count++;
		}

		System.out.println(count);

		sc.close();
	}
}