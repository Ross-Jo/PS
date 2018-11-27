package baekjoon;

// https://www.acmicpc.net/problem/2579

import java.util.Scanner;

//계단의 갯수(자연수) <= 300
//계단에 쓰여 있는 점수(자연수) <=10,000
public class Q2579 {

	public static int dp_stairs(int[] scores, int num_of_stairs) {
		int[][] cache = new int[2 + 1][num_of_stairs + 1];

		cache[1][1] = scores[1];
		cache[1][2] = scores[1] + scores[2];

		cache[2][1] = 0;
		cache[2][2] = scores[2];

		for (int i = 3; i <= num_of_stairs; i++) {
			cache[1][i] = cache[2][i - 1] + scores[i];
			cache[2][i] = Math.max(cache[1][i - 2], cache[2][i - 2]) + scores[i];
		}

		return Math.max(cache[1][num_of_stairs], cache[2][num_of_stairs]);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int num_of_stairs = sc.nextInt();
		int[] scores = new int[num_of_stairs + 1];
		for (int i = 1; i <= num_of_stairs; i++) {
			scores[i] = sc.nextInt();
		}

		System.out.println(dp_stairs(scores, num_of_stairs));

		sc.close();
	}
}