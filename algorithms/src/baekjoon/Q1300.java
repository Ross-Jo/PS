package baekjoon;

// https://www.acmicpc.net/problem/1300
// 참고 : http://stack07142.tistory.com/298

import java.util.Scanner;

public class Q1300 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int l = 1;
		int r = (int) Math.min((long) n*n, (long)1000000000);
		int m;
		int ans = 0;
		
		while(l <= r) {
			m = (l+r)/2;
			int cnt = getCnt(m, n);
			if (cnt >= k) {
				ans = m;
				r = m-1;
			} else {
				l = m+1;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
	
	static int getCnt(int x, int n) {
		int cnt = 0;
		for (int i=1; i<=n; i++) {
			cnt += Math.min(x/i, n);
		}
		return cnt;
	}
}
