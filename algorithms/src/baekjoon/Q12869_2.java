package baekjoon;

// https://www.acmicpc.net/problem/12869

import java.util.Scanner;

public class Q12869_2 {
	// scv 체력이 i, j, k 일때, 모두 파괴하기 위해 공격해야 하는 횟수의 최솟값 
	public static int[][][] d = new int[61][61][61];

	public static int go(int i, int j, int k) {
		// 음수 처리 
		if (i < 0) return go(0, j, k);
		if (j < 0) return go(i, 0, k);
		if (k < 0) return go(i, j, 0);
		
		// 만약 다 파괴되었다면 더이상 공격을 하지 않아도 됨 
		if (i == 0 && j == 0 && k == 0) return 0;
		
		// 메모이제이션 
		if (d[i][j][k] != -1) return d[i][j][k];
		int ans = 10000000;
		
		if (ans > go(i - 1, j - 3, k - 9)) { // 한대를 쳤다고 가정하고 공격해야 하는 횟수의 최솟값을 구했을때 그 값이 현재 값보다 작다면 작은값은 ans에 기록 
			ans = go(i - 1, j - 3, k - 9);
		}
		if (ans > go(i - 1, j - 9, k - 3)) {
			ans = go(i - 1, j - 9, k - 3);
		}
		if (ans > go(i - 3, j - 1, k - 9)) {
			ans = go(i - 3, j - 1, k - 9);
		}
		if (ans > go(i - 3, j - 9, k - 1)) {
			ans = go(i - 3, j - 9, k - 1);
		}
		if (ans > go(i - 9, j - 1, k - 3)) {
			ans = go(i - 9, j - 1, k - 3);
		}
		if (ans > go(i - 9, j - 3, k - 1)) {
			ans = go(i - 9, j - 3, k - 1);
		}
		
		ans += 1; // 한대를 쳤다고 가정했을 때 때려야 하는 최솟값 + 미리 빼 놓은 공격횟수 1  
		d[i][j][k] = ans;
		return d[i][j][k];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] scv = new int[3];
		for (int i = 0; i < n; i++) {
			scv[i] = sc.nextInt();
		}
		for (int i = 0; i <= 60; i++) {
			for (int j = 0; j <= 60; j++) {
				for (int k = 0; k <= 60; k++) {
					d[i][j][k] = -1;
				}
			}
		}
		System.out.println(go(scv[0], scv[1], scv[2]));
		sc.close();
	}
}