package baekjoon;

// https://www.acmicpc.net/problem/2749

import java.util.Scanner;

// 참고 : https://www.acmicpc.net/blog/view/28
// 피사노 주기 이용 

public class Q2749 {
	static int MOD = 1000000;
	static int p = (MOD/10)*15;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int[] fib = new int[p];
		fib[1] = 1;
		
		for (int i=2; i<p; i++) {
			fib[i] = (fib[i-1] + fib[i-2])%MOD;
		}
		
		System.out.println(fib[(int)(n%p)]);
		
		sc.close();
	}
}
