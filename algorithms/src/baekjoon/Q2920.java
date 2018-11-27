package baekjoon;

// https://www.acmicpc.net/problem/2920

import java.util.Scanner;

public class Q2920 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] numbers = new int[8];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}

		int ac = 0, dc = 0;
		for (int i = 1; i < numbers.length; i++) {
			int tmp = numbers[i] - numbers[i - 1];
			if (tmp == 1)
				ac++;
			else if (tmp == -1)
				dc++;
		}

		if (ac == 7)
			System.out.println("ascending");
		else if (dc == 7)
			System.out.println("descending");
		else
			System.out.println("mixed");

		sc.close();

	}
}