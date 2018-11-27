package baekjoon;

// https://www.acmicpc.net/problem/2292

import java.util.Scanner;

//1<=N<=1000,000,000
public class Q2292 {

	public static int[] section(int num) {

		int[] min_max = new int[2];
		int max = 1;
		int min = 1;
		for (int i = 0; i <= num; i++) {
			if (i >= 1)
				min = max + 1;
			max += 6 * i;
		}

		min_max[0] = min;
		min_max[1] = max;

		return min_max;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int count = 0;
		while (true) {
			int[] min_max = section(count++);
			if (N <= min_max[1])
				break;
		}

		System.out.println(count);

		sc.close();
	}
}