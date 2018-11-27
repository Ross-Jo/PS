package baekjoon;

// https://www.acmicpc.net/problem/5622

import java.util.Scanner;

//인풋은 알파벳 대문자. 단어는 2~15글자로 구성
public class Q5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.next();

		int sum = 0;
		for (int i = 0; i < word.length(); i++) {
			char tmp = word.charAt(i);
			if (tmp == 'A' || tmp == 'B' || tmp == 'C')
				sum += 3;
			else if (tmp == 'D' || tmp == 'E' || tmp == 'F')
				sum += 4;
			else if (tmp == 'G' || tmp == 'H' || tmp == 'I')
				sum += 5;
			else if (tmp == 'J' || tmp == 'K' || tmp == 'L')
				sum += 6;
			else if (tmp == 'M' || tmp == 'N' || tmp == 'O')
				sum += 7;
			else if (tmp == 'P' || tmp == 'Q' || tmp == 'R' || tmp == 'S')
				sum += 8;
			else if (tmp == 'T' || tmp == 'U' || tmp == 'V')
				sum += 9;
			else if (tmp == 'W' || tmp == 'X' || tmp == 'Y' || tmp == 'Z')
				sum += 10;
		}

		System.out.println(sum);

		sc.close();
	}
}