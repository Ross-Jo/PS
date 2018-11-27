package baekjoon;

// https://www.acmicpc.net/problem/10039

import java.util.Scanner;

public class Q10039 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int tmp;
		for (int i = 0; i < 5; i++) {
			if ((tmp = sc.nextInt()) < 40) {
				sum += 40;
			} else {
				sum += tmp;
			}
		}

		System.out.println(sum / 5);

		sc.close();
	}
}