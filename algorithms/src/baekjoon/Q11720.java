package baekjoon;

// https://www.acmicpc.net/problem/11720

import java.util.Scanner;

//N (1 ≤ N ≤ 100)
//문제의 조건이 모호

public class Q11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = null;
		int num_of_input = Integer.parseInt(sc.nextLine());
		line = sc.nextLine();

		int sum = 0;

		for (int i = 0; i < num_of_input; i++) {
			sum += (int) line.charAt(i) - 48;
		}

		System.out.println(sum);
		sc.close();
	}
}