package baekjoon;

//https://www.acmicpc.net/problem/2748

import java.util.Scanner;

public class Q2748 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] fib = new long[90+1];
		fib[1] = 1;
		
		for (int i=2; i<=n; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		System.out.println(fib[n]);
		
		
		sc.close();
	}
}
