package baekjoon;

// https://www.acmicpc.net/problem/1152

import java.util.Scanner;

public class Q1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		line = line.trim();

		int count = 0;
		boolean unique = true;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ' ' && unique == true) {
				count++;
				unique = false;
			} else if (line.charAt(i) != ' ') {
				unique = true;
			}
		}

		if (line.length() == 0)
			System.out.println(0);
		else
			System.out.println(count + 1);

		sc.close();
	}

}