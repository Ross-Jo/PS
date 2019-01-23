package baekjoon;

//https://www.acmicpc.net/problem/2407

import java.util.Arrays;
import java.math.BigInteger;
import java.util.Scanner;

public class Q2407 {
	static int N, M;
	static BigInteger[][] comb;
	
	static BigInteger calc(int n, int m) {
		if (n==m || m==0) return BigInteger.ONE;
		if (m>n || n==0) return BigInteger.ZERO;
		
		BigInteger ret = comb[n][m];
		if (ret.intValue()!=-1) return ret;
		
		return comb[n][m] = calc(n-1, m-1).add(calc(n-1, m));
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 5<=N<=100
		M = sc.nextInt(); // 5<=M<=100
		comb = new BigInteger[N+1][M+1]; // M<=N
		
		for (int i=0; i<comb.length; i++) Arrays.fill(comb[i], new BigInteger("-1"));
		
		System.out.println(calc(N, M));
		sc.close();
	}
}

