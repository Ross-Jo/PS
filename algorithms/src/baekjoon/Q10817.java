package baekjoon;

// https://www.acmicpc.net/problem/10817

import java.util.Scanner;

//1<= A,B,C<=100

public class Q10817 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		System.out.println(Math.max(A, B) == A ? (Math.max(A, C) == A ? Math.max(B, C) : A)
				: (Math.max(B, C) == B ? Math.max(A, C) : B));
		sc.close();
	}
}
