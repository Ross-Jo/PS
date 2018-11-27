package baekjoon;

// https://www.acmicpc.net/problem/11721

import java.util.Scanner;

//단어의 길이는 100을 넘지 않음

public class Q11721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		int startIndex = 0;
		int endIndex = 0;

		for (int i = 0; i < (line.length() / 10) + 1; i++) {

			if (i == (line.length() / 10))
				endIndex = line.length();
			else
				endIndex = startIndex + 10;

			System.out.println(line.substring(startIndex, endIndex));

			startIndex = endIndex;
		}
		sc.close();
	}
}