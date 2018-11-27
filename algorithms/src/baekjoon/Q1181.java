package baekjoon;

// https://www.acmicpc.net/problem/1181

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] words = new String[N];

		for (int i = 0; i < N; i++) {
			words[i] = sc.next();
		}

		Arrays.sort(words, new Comparator<String>() { // Comparator 인터페이스 사용법 잘 봐두기
			@Override // Annotation 사용
			public int compare(String word1, String word2) {
				if (word1.length() != word2.length())
					return Integer.compare(word1.length(), word2.length());
				return word1.compareTo(word2);
			}
		});

		for (int i = 0; i < words.length; i++) {
			if (i == 0)
				System.out.println(words[i]);
			else if (i >= 1 && !words[i].equals(words[i - 1]))
				System.out.println(words[i]);
		}

		sc.close();
	}
}