package baekjoon;

// https://www.acmicpc.net/problem/1929

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1929 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int m = Integer.parseInt(tmp[0]);
		int n = Integer.parseInt(tmp[1]);

		boolean[] prime = new boolean[n + 1];
		prime[0] = prime[1] = true; // 소수가 아닌 것들을 true로 설정 

		for (int i = 2; i*i < n + 1; i++) {
			if (!prime[i]) {
				for (int j = 2; i * j < n + 1; j++) { // 예를들어 2를 타깃으로 잡았으면 다음과 같이 소수 여부를 따짐. 2, 4, 6, 8 ... 이 때, j가 2부터 시작함에 주목
					                                  // j가 2부터 시작하는 이유. j가 1인 경우, 해당 숫자가 소수인 경우면 남겨두면 되고, 소수가 아닌 경우라면 이 전에 지워졌을 것이기 (즉, 이미 체크되었기) 때문이다. 
					if (!prime[i * j]) prime[i * j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = m; i <= n; i++) if (!prime[i]) sb.append(i + "\n");
		System.out.println(sb);
	}
}