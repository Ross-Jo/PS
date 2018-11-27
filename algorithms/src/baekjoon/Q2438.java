package baekjoon;

// https://www.acmicpc.net/problem/2438

import java.util.Scanner;

public class Q2438 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int input = 0;

		input = sc.nextInt(); // N(1<=N<=100)

		for (int i = 0; i < input; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}
}
