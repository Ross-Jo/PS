package baekjoon;

// https://www.acmicpc.net/problem/9020

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9020 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[10000 + 1];
		prime[0] = prime[1] = true;  

		for (int i = 2; i*i < 10000 + 1; i++) {
			if (!prime[i]) {
				for (int j = 2; i * j < 10000 + 1; j++) { 
					if (!prime[i * j]) prime[i * j] = true;
				}
			}
		}
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int mid = n/2;
			
			for (int i=mid; i>=2; i--) {
				if (!prime[i] && !prime[n-i]) {
					sb.append(i + " " + (n - i) + "\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
		
	}
}

