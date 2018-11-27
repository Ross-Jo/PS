package baekjoon;

// https://www.acmicpc.net/problem/3053

import java.util.Scanner;

public class Q3053 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		
		double u = Math.PI * r * r;
		double t = r * r * 2;
		
		System.out.format("%.6f\n", u);
		System.out.format("%.6f\n", t);
		
		sc.close();
	}
}