package baekjoon;

//https://www.acmicpc.net/problem/2581

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2581_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		boolean[] prime = new boolean[n + 1];
		prime[0] = prime[1] = true;

		for (int i = 2; i*i < n + 1; i++) {
			if (!prime[i]) {
				for (int j = 2; i * j < n + 1; j++) {
					if (!prime[i * j]) prime[i * j] = true;
				}
			}
		}
		
		int min = -1;
		int sum = 0;
		for (int i = n; i >= m; i--) {
			if (!prime[i]) {
				min = i;
				sum += i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if (sum == 0) {
			sb.append("-1");
		} else {
			sb.append(sum + "\n" + min);
		}
		System.out.println(sb);
	}
}
