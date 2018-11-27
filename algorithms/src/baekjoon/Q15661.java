package baekjoon;

// https://www.acmicpc.net/problem/15661

import java.util.Scanner;

public class Q15661 {
	static int N;
	static int[][] s;
	static boolean[] d;
	static int md = 987654321;
	
	static void calc() {
		int s1 = 0;
		int s2 = 0;
		for (int i=1; i<=N; i++) {
			for (int j=i+1; j<=N; j++) {
				if(d[i] && d[j]) {
					s1 += s[i][j];
					s1 += s[j][i];
				}
			}
		}
		for (int i=1; i<=N; i++) {
			for (int j=i+1; j<=N; j++) {
				if(!d[i] && !d[j]) {
					s2 += s[i][j];
					s2 += s[j][i];
				}
			}
		}
		if (md > Math.abs(s1-s2)) md = Math.abs(s1-s2); 
	}
	
	static void divide(int c, int st) {
		if (c == 0) {
			calc();
			return;
		}
		if (st == N && c > 0) return;
		
		for (int i=st; i<=N; i++) {
			if (!d[i]) {
				d[i] = true;
				divide(c-1, i);
				d[i] = false;
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 4 ≤ N ≤ 20
		s = new int[N+1][N+1];
		d = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				s[i][j] = sc.nextInt();
			}
		}
		
		for (int i=1; i<=N-1; i++) { // 선택을 하는 명수 
			d[1] = true;
			divide(i-1, 2);
		}
		System.out.println(md);
		
		sc.close();
	}
}
