package baekjoon;

// https://www.acmicpc.net/problem/2941

import java.util.Scanner;

public class Q2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.next();

		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			if (i - 2 >= 0 && word.charAt(i - 2) == 'd' && word.charAt(i - 1) == 'z' && word.charAt(i) == '=') {
				count--;
				continue;
			} else if (word.charAt(i) == '=' || word.charAt(i) == '-')
				continue;
			else if (i - 1 >= 0 && word.charAt(i - 1) == 'l' && word.charAt(i) == 'j')
				continue;
			else if (i - 1 >= 0 && word.charAt(i - 1) == 'n' && word.charAt(i) == 'j')
				continue;
			else
				count++;
		}

		System.out.println(count);

		sc.close();
	}
}