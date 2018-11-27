package baekjoon;

// https://www.acmicpc.net/problem/11659

import java.util.Scanner;

public class Q11659 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] p = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			p[i] = p[i-1] + sc.nextInt();
		}
		
		while(M-- > 0) {
			int a = p[sc.nextInt()-1];
			int b = p[sc.nextInt()];
			System.out.println(b-a);
		}
		
		sc.close();
	}
}