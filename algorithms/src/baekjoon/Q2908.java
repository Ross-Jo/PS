package baekjoon;

// https://www.acmicpc.net/problem/2908

import java.util.Scanner;

//입력으로 주어지는 두 수는 같지 않은 3자리 수. 0은 포함되어 있지 않음
public class Q2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();

		StringBuffer sb_A = new StringBuffer();
		StringBuffer sb_B = new StringBuffer();
		for (int i = 2; i >= 0; i--) {
			sb_A.append(A.charAt(i));
			sb_B.append(B.charAt(i));
		}

		A = sb_A.toString();
		B = sb_B.toString();

		int Ai = Integer.parseInt(A);
		int Bi = Integer.parseInt(B);

		System.out.println(Math.max(Ai, Bi));

		sc.close();
	}
}
