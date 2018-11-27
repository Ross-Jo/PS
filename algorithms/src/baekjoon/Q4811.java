package baekjoon;

// https://www.acmicpc.net/problem/4811

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import java.util.Arrays;

// [다시 풀기] # 4811

public class Q4811 {
	
//	static int N;
//	static Set<String> s;
//	static void pill(String cs, int a, int h) {
//		if(cs.length() == 2*N) {
//			s.add(cs); return;
//		}
//		if(a>0) pill(cs+"H", a-1, h+1);
//		if(cs.length() != 0 && h>0) pill(cs+"W", a, h-1);
//	}
//	
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		
//		N = -1;
//		while((N = sc.nextInt())!=0) {
//			s = new HashSet<>();
//			pill("", N, 0);
//			System.out.println(s.size());
//		}
//		sc.close();
//	}
	
	static long[][] d = new long[31][31];

	static long calc(int f, int h) {
		if (d[f][h] != -1) return d[f][h];
		if (f == 0) return 1;
		if (h == 0) return d[f][h] = calc(f - 1, h + 1);
		return d[f][h] = calc(f - 1, h + 1) + calc(f, h - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 31; i++) Arrays.fill(d[i], -1);
		while (true) {
			int n = sc.nextInt();
			if (n == 0) break;
			System.out.println(calc(n, 0));
		}
	}
}
