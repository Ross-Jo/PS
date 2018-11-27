package baekjoon;

// https://www.acmicpc.net/problem/2577

import java.util.Scanner;

//100 <= A, B, C <= 1000
public class Q2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int mul = A * B * C;
		Integer mul_c = mul;
		String mul_s = mul_c.toString();

		int[] digit = new int[10];
		for (int i = 0; i < mul_s.length(); i++) {
			digit[mul_s.charAt(i) - 48]++;
		}

		for (int print : digit) {
			System.out.println(print);
		}

		sc.close();
	}
}