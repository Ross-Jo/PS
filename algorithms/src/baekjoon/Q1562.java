package baekjoon;

//https://www.acmicpc.net/problem/1562
//참고 : https://redsalmon.tistory.com/51
//[다시 풀기]

import java.util.Scanner;

public class Q1562 {
	static final int MOD = 1000000000;
	static int n, ans;
	static int[][][] dp = new int[101][10][1 << 10];

	static int dfs(int idx, int num, int bit) { // 숫자의 길이, 계단수의 시작 숫자, 해당 숫자가 0~9까지의 숫자를 다 활용하는지 체크
		if (dp[idx][num][bit] != 0) return dp[idx][num][bit];
		if (idx == n) return bit == (1 << 10) - 1 ? 1 : 0;

		int res = 0;
		if (num + 1 < 10) res += dfs(idx + 1, num + 1, bit | 1 << (num + 1));
		if (num - 1 >= 0) res += dfs(idx + 1, num - 1, bit | 1 << (num - 1));
		res %= MOD;
		
		return dp[idx][num][bit] = res;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			ans += dfs(1, i, 1 << i);
			ans %= MOD;
		}
		System.out.println(ans);
		sc.close();
	}
}
