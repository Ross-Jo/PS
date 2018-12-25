package baekjoon;

// https://www.acmicpc.net/problem/4948

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q4948 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			
			int m = 2*n;
			
			boolean[] prime = new boolean[m + 1];
			prime[0] = prime[1] = true;  

			for (int i = 2; i*i < m + 1; i++) {
				if (!prime[i]) {
					for (int j = 2; i * j < m + 1; j++) { 
						if (!prime[i * j]) prime[i * j] = true;
					}
				}
			}
			
			int c = 0;
			for (int i=n+1; i<=m; i++) if (!prime[i]) c++;
			sb.append(c + "\n");
		}
		System.out.println(sb);
		
	}
}

