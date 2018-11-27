package baekjoon;

//https://www.acmicpc.net/problem/10986

import java.util.*;

public class Q10986 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			a[i] %= m;
		}
		
		long[] cnt = new long[m];
		cnt[0] = 1;

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
			sum %= m;
			cnt[sum] += 1;
		}
		
		long ans = 0;
		for (int i = 0; i < m; i++) {
			ans += cnt[i] * (cnt[i] - 1) / 2L;
		}
		
		System.out.println(ans);
		sc.close();
	}
}