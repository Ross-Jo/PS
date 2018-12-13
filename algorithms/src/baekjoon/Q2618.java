package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2618
// 참고: http://jason9319.tistory.com/224

public class Q2618 {
	static int[][] dp = new int[1001][1001];
	static int n, w;
	static int[] back = new int[1001];
	
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Pair[] d = new Pair[1001];
	static int getdist(Pair a, Pair b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
	
	static int func(int x, int y) {
		if (x == w || y == w) return 0; // x혹은 y가 마지막 사건인 경우 리턴
		
		int ret = dp[x][y];
		if (ret != -1) return ret;
		
		int fir, sec;
		int next = Math.max(x, y) + 1;
		
		// 경찰차 1번이 다음 사건을 처리하는 경우
		if (x==0) fir = func(next, y) + getdist(d[next], new Pair(1, 1)); // 시작지점은 따로 처리
		else fir = func(next, y) + getdist(d[next], d[x]);
		
		// 경찰차 2번이 다음 사건을 처리하는 경우
		if (y==0) sec = func(x, next) + getdist(d[next], new Pair(n, n)); // 시작지점은 따로 처리
		else sec = func(x, next) + getdist(d[next], d[y]);
		
		return dp[x][y] = Math.min(fir, sec);
	}
	
	static void solve(int x, int y) {
		if (x == w || y == w) return;
		
		int fir, sec;
		int next = Math.max(x, y) + 1;
		
		if (x==0) fir = func(next, y) + getdist(d[next], new Pair(1, 1));
		else fir = func(next, y) + getdist(d[next], d[x]);
		
		if (y==0) sec = func(x, next) + getdist(d[next], new Pair(n, n));
		else sec = func(x, next) + getdist(d[next], d[y]);
		
		if (fir < sec) {
			back[next] = 1;
			solve(next, y);
		} else {
			back[next] = 2;
			solve(x, next);
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = sc.nextInt();
		for (int i=1; i<=w; i++) d[i] = new Pair(sc.nextInt(), sc.nextInt());
		for (int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
		
		System.out.println(func(0,0));
		solve(0, 0);
		for (int i=1; i<=w ; i++) System.out.println(back[i]);
		
		sc.close();
	}
}
