package baekjoon;

// https://www.acmicpc.net/problem/12872

import java.util.Arrays;
import java.util.Scanner;

public class Q12872 {
	static final long mod = 1000000007;
	static int N, M, P;
	static long[][] d = new long[101][101]; // n개의 곡을 가지고 길이 i만큼의 플레이리스트를 만들때 가능한 경우의 수 
	
	static long solve(int i, int n) {
		if(i == 0 && n == 0) return 1; // 다 깎아 먹어서 목표한 조건에 도달하는 경우 해당 사건을 카운트 함 
		if (i < 0 || n < 0) return 0; // 음수 인덱스는 취급하지 않음 
		
		if (d[i][n] != -1) return d[i][n]; // 메모이제이션 
		
		long ans = 0;
		if (n > M) ans = solve(i-1, n) * (n - M); // 이미 있던 n개의 곡을 또 추가하는 경우 
		ans += solve(i-1, n-1) * (N - (n-1)); // 기존 n가지의 곡 이외에 신곡을 추가하는 경우 
		
		ans %= mod;
		d[i][n] = ans;
		return ans;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt(); P = sc.nextInt();
		for (int i=0; i<101; i++) Arrays.fill(d[i], -1);
		System.out.println(solve(P, N));
		sc.close();
	}
}