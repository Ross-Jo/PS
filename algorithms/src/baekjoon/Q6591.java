package baekjoon;

// https://www.acmicpc.net/problem/6591

import java.util.Scanner;

public class Q6591 {
	
	static long calc(int n, int m) {
		long ret = 1;
		if (m > n-m) m = n-m;
		for (int i=1; i<=m; i++) ret = ret * (n-m+i) / i;
		return ret;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n==0 && m==0) break;
			
			System.out.println(calc(n, m));
		}
		
		sc.close();
	}
}
