package baekjoon;

// https://www.acmicpc.net/problem/1080
// 참고 : http://wookje.dance/2017/03/14/boj-1080-%ED%96%89%EB%A0%AC/

import java.util.Scanner;

public class Q1080 {
	static int N, M, ans = 0;
	static char src[][] = new char[50][50], dest[][] = new char[50][50];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt();
		
		for (int i=0; i<N; i++) src[i] = sc.next().toCharArray();
		for (int i=0; i<N; i++) dest[i] = sc.next().toCharArray();
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (src[i][j] == dest[i][j]) continue;
				ans++;
				for (int x = i; x < i + 3; x++) {
					for (int y = j; y < j + 3; y++) {
						if (src[x][y] == '0') src[x][y] = '1';
						else src[x][y] = '0';
					}
				}
			}
		}
		
		boolean flag = true;
		for (int i=0; i<N; i++) for (int j=0; j<M; j++) if (src[i][j] != dest[i][j]) flag = false;
		System.out.println(flag ? ans: -1);
		
		sc.close();
	}
}
