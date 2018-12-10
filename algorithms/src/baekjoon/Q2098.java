package baekjoon;

import java.util.Arrays;

// https://www.acmicpc.net/problem/2098
import java.util.Scanner;

// 참고: http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220557403491

public class Q2098 {
	static int N, start = 0;
	static int[][] cost, dp;
	static final int INF = 1000000000; // Integer.MAX_VALUE 등으로 설정하면 24번 라인에서의 overflow 가능성 때문에 위험 
	
	static int TSP(int current, int visited) {
		if(visited == (1<<N)-1) return cost[current][start] !=0 ? cost[current][start] : INF;
		int ret = dp[current][visited];
		if(ret != -1) return ret;
		
		dp[current][visited] = INF;
		for (int i=0; i<N; i++) {
			if((visited & (1<<i)) > 0) continue;
			if(cost[current][i] == 0) continue;
			dp[current][visited] = Math.min(dp[current][visited], TSP(i, (visited | (1<<i))) + cost[current][i]);
		}
		return dp[current][visited];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cost = new int[16][16];
		dp = new int[16][65536];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				cost[i][j] = sc.nextInt();
			}
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(TSP(0,1));
		sc.close();
	}
}
