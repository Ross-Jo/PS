package baekjoon;

// https://www.acmicpc.net/problem/10253

import java.util.Scanner;

public class Q10253 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while(T-->0) {
			long a = sc.nextInt();
			long b = sc.nextInt();
				
			long x = (int)Math.ceil(b/(double)a);
			
			while(a * x - b > 0) {
				a = a*x-b;
				b = b*x;
				x = (long)Math.ceil(b/(double)a);
			}
			
			System.out.println((long)x);
		}
		sc.close();
	}
}