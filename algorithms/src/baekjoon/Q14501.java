package baekjoon;

// https://www.acmicpc.net/problem/14501

import java.util.Scanner;

//참고: http://mygumi.tistory.com/151

public class Q14501 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] dp = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			T[i] = sc.nextInt();
			int p = sc.nextInt();
			if((i + T[i] - 1) <= N) P[i] = p; // 상담기한을 더한 날짜가 퇴사일을 넘어버리면 어차피 의미가 없음 
			dp[i] = P[i];
		}
		
		int max = dp[1]; // 빠질 수 있는 케이스를 철저히 확인하자 
		
		for (int i=2; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (i >= j+T[j]) {
					dp[i] = Math.max(P[i] + dp[j], dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
		sc.close();
	}
}
