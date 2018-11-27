package baekjoon;

// https://www.acmicpc.net/problem/10809

import java.util.Scanner;

public class Q10809 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();

		int[][] alphabet = new int[2][26];

		for (int i = 0; i < alphabet[0].length; i++) {
			alphabet[0][i] = -1;
		}

		for (int i = 0; i < word.length(); i++) {
			if (alphabet[1][word.charAt(i) - 97] == 0) {
				alphabet[0][word.charAt(i) - 97] = i;
				alphabet[1][word.charAt(i) - 97]++;
			}
		}

		for (int i = 0; i < alphabet[0].length; i++) {
			System.out.print(alphabet[0][i] + " ");
		}

		sc.close();
	}
}