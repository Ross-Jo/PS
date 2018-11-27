package baekjoon;

// https://www.acmicpc.net/problem/1057

import java.util.Scanner;

//토너먼트

public class Q1057 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a = sc.nextInt(); 
		int b = sc.nextInt();
		int ans = 0;
		
		while(a!=b) {
			a = (a+1)/2;
			b = (b+1)/2;
			ans++;
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}
