package baekjoon;

// https://www.acmicpc.net/problem/16198

import java.util.Scanner;

public class Q16198 {
	static int N;
	static int[] w;
	static int pick(boolean[] c, int xs, int sum) {
		if(xs == N-2) return sum;
		
		int ans = -1;
		for (int i=1; i<N-1; i++) {
			if (c[i] == false) {
				c[i] = true;
				
				int l = i-1;
				int r = i+1;
				while(c[l]) l--;
				while(c[r]) r++;
				
				sum += (w[l] * w[r]);
				int ret = pick(c, xs+1, sum);
				
				if (ans < ret) ans = ret;
				
				c[i] = false;
				sum -= (w[l] * w[r]);
			}
		}
		
		return ans;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		w = new int[N];
		
		for (int i=0; i<N; i++) w[i] = sc.nextInt();
		System.out.println(pick(new boolean[N], 0, 0));
		sc.close();
	}
}