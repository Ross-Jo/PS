package baekjoon;

// https://www.acmicpc.net/problem/1547

import java.util.Scanner;

public class Q1547 {
	static int[] balls = new int[4];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		for(int i=0; i<balls.length; i++) {
			balls[i] = i;
		}
		while(M-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			change(a, b);
			
		}
		System.out.println(balls[1]);
		sc.close();
	}
	
	static void change(int a, int b) {
		int ai = 0;
		int bi = 0;
		for(int i=1;i<4;i++) {
			if(balls[i]==a) {
				ai = i;
			} else if(balls[i]==b) {
				bi = i;
			}
		}
		
		int tmp = balls[ai];
		balls[ai] = balls[bi];
		balls[bi] = tmp;
	}
}