package baekjoon;

// https://www.acmicpc.net/problem/1316

import java.util.Scanner;

//N(자연수)<=100
//단어 : 알파벳 소문자, 중복되지 않음, 길이는 최대 100
public class Q1316 {

	public static int check(String word) {
		int[] checker = new int[26];
		char sign = '0';

		for (int i = 0; i < word.length(); i++) {
			if (checker[word.charAt(i) - 97] == 0) {
				checker[word.charAt(i) - 97] = 1;
				sign = word.charAt(i);
			}
			if (checker[word.charAt(i) - 97] != 0 && sign == word.charAt(i))
				continue;
			else
				return 0;
		}
		return 1;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int count = 0;
		for (int i = 0; i < N; i++) {
			String word = sc.next();
			count += check(word);
		}

		System.out.println(count);

		sc.close();
	}
}