package baekjoon;

// https://www.acmicpc.net/problem/2675

import java.util.Scanner;

//1<=T<=1000
//1<=R<=8
//1<=문자열 S의 길이<=20

public class Q2675 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int R = sc.nextInt();
			String S = sc.next();

			StringBuffer st = new StringBuffer();

			for (int j = 0; j < S.length(); j++) {
				for (int k = 0; k < R; k++) {
					st.append(S.charAt(j));
				}
			}

			System.out.println(st);

		}

		sc.close();
	}
}