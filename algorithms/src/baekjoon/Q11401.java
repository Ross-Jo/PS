package baekjoon;

// https://www.acmicpc.net/problem/11401
// 참고 : http://jason9319.tistory.com/169

import java.util.Scanner;

public class Q11401 {
	static final int MOD = 1000000007;
	static int N, K;
	static long[] fac = new long[4000001];
	static long[] inv = new long[4000001]; // inv[x]의 정의는 x의 inverse가 아닌 x!의 inverse
	static long power(long x, long y) {
		long ret = 1;
		while(y>0) {
			if(y%2 == 1) {
				ret *= x;
				ret %= MOD;
			}
			x *= x;
			x %= MOD;
			y /= 2;
		}
		return ret;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		fac[0] = fac[1] = 1;
		for (int i=1; i<=4000000; i++) fac[i] = (fac[i-1] * i) % MOD;
		inv[4000000] = power(fac[4000000], MOD-2); // 페르마 소정리 
		for (int i=4000000-1; i>=0; i--) inv[i] = (inv[i+1]*(i+1)) % MOD;
		
		if (K == 0 || N == K) {
			System.out.println(1);
		} else {
			long r = (fac[N] * inv[N-K]) % MOD;
			r = (r*inv[K]) % MOD;
			
			System.out.println(r);
		}
		
		sc.close();
	}
}
