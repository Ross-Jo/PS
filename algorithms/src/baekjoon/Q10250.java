package baekjoon;

// https://www.acmicpc.net/problem/10250

import java.util.Scanner;

//1<=H,W<=99
//1<=N<=H*W
public class Q10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {

			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();

			int floor = N % H == 0 ? H : N % H;
			int room_n = N % H == 0 ? N / H : N / H + 1;

			System.out.println(floor * 100 + room_n);
		}
		sc.close();
	}
}