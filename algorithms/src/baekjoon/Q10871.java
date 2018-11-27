package baekjoon;

// https://www.acmicpc.net/problem/10871

import java.util.Scanner;

//1<= N, X <=10,000
//1<= 주어지는 정수 <= 10000

public class Q10871 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int X = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int tmp;
			if ((tmp = sc.nextInt()) < X)
				System.out.print(tmp + " ");
		}
		sc.close();
	}
}