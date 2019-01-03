package baekjoon;

// https://www.acmicpc.net/problem/11401
// 오답 - 다시풀 것

import java.util.Arrays;
import java.util.Scanner;

public class Q11401 {
	static final int MOD = 1000000007;
	static int N, K;
	static int[][] bino;
	
	static int calc(int n, int k) {
		if (k==0 || n==k) return 1;
		
		int b = bino[n][k];
		if (b != -1) return bino[n][k];
		
		return bino[n][k] = (calc(n-1, k-1) + calc(n-1, k)) % MOD;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		bino = new int[N+1][K+1];
		for (int i=0; i<bino.length; i++) Arrays.fill(bino[i], -1);
		
		System.out.println(calc(N, K));
		
		sc.close();
	}
}
