package baekjoon;

// https://www.acmicpc.net/problem/1065

import java.util.Scanner;

//N은 1000보다 작거나 같음
//1<= 한수 <= N

public class Q1065 {

	public static boolean check(int x) {
		int tmp = (x / 10) % 10 - x % 10;
		while (x >= 10) {
			int digit = x % 10;
			x = x / 10;
			int next_digit = x % 10;
			if (tmp != next_digit - digit) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (check(i) == true)
				count++;
		}

		System.out.println(count);

		sc.close();
	}
}