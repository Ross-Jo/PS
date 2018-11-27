package baekjoon;

// https://www.acmicpc.net/problem/2750

import java.util.Arrays;
import java.util.Scanner;

// 1<=N<=1000
public class Q2750 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}

		Arrays.sort(numbers);

		for (int i = 0; i < N; i++) {
			System.out.println(numbers[i]);
		}

		sc.close();
	}
}