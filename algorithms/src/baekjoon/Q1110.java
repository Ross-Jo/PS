package baekjoon;

// https://www.acmicpc.net/problem/1110

import java.util.Scanner;

//0<=주어지는 정수<=99
public class Q1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int tmp = N;
		boolean flag = false;
		int count = 0;

		while (!flag) {
			int F = tmp / 10;
			int B = tmp % 10;
			int N_B = (F + B) % 10;
			tmp = B * 10 + N_B;
			count++;
			if (tmp == N) {
				flag = true;
			}
		}

		System.out.println(count);

		sc.close();
	}
}