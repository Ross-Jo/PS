package baekjoon;

// https://www.acmicpc.net/problem/11047

import java.util.Scanner;

public class Q11047 {
	static int n, k; // 1<=n<=10, 1<=k<=100000000
	static int[] coins;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
			
		n = sc.nextInt();
		k = sc.nextInt();
		
		coins = new int[n];
		for (int i=0; i<n; i++) {
			coins[i] = sc.nextInt();
		}
		
		int sum = 0;
		
		for (int i=n-1; i>=0; i--) {
			if (coins[i] <= k) {
				int a = k / coins[i];
				sum += a;
				k = k - coins[i]*a;
			}
		}
		
		System.out.println(sum);
		sc.close();
	}
}
