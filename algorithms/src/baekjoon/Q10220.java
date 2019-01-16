package baekjoon;

// https://www.acmicpc.net/problem/10220

// 참고 : http://jda2002.tistory.com/entry/BOJ-%EB%B0%B1%EC%A4%80-11220%EB%B2%88-Self-Representing-Seq
// 참고 : https://blog.encrypted.gg/139

import java.util.Scanner;

public class Q10220 {
	static int T, N;
	static final int MOD = 1000000007;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		while(T-- > 0) {
			N = sc.nextInt();
			if (6 % N == 0) System.out.println(0);
			else if (N == 4) System.out.println(2);
			else System.out.println(1);
		}
		
		sc.close();
	}
}
