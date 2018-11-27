package baekjoon;

// https://www.acmicpc.net/problem/11051

import java.util.Scanner;

public class Q11051 {
	static int[][] c = new int[1001][1001];
	static int bino(int n, int k) {
		if(k==0 || n==k) return 1;
		if(c[n][k] != 0) return c[n][k];
		return c[n][k] = (bino(n-1, k-1) + bino(n-1, k)) % 10007;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println(bino(sc.nextInt(), sc.nextInt()));
		sc.close();
	}
}
