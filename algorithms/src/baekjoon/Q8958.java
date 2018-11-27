package baekjoon;

// https://www.acmicpc.net/problem/8958

import java.util.Scanner;

public class Q8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < T; i++) {

			String line = sc.nextLine();
			int consecutive_c = 1;
			int sum = 0;

			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == 'O') {
					sum += consecutive_c;
					consecutive_c++;
				} else {
					sum += 0;
					consecutive_c = 1;
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}
}