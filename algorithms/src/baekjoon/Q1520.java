package baekjoon;

// https://www.acmicpc.net/problem/1520

import java.io.IOException;
import java.util.Scanner;

public class Q1520 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][] map, dp;
	static int m;
	static int n;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[m][n];
		dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(m - 1, n - 1));
		sc.close();
	}

	public static int dfs(int y, int x) {
		if (y == 0 && x == 0) return 1;

		if (dp[y][x] == -1) { // 방문하지 않았던 칸에 대해서만 dfs를 돌림 
			dp[y][x] = 0;
			for (int i = 0; i < 4; i++) { // 좌, 상, 우, 하 방향으로 방향을 잡으면서 해당 지점에서 출발점까지 가기 위한 방법의 수를 셈 
				int nx = dx[i] + x;
				int ny = dy[i] + y;

				if (0 <= nx && nx < n && 0 <= ny && ny < m) { // 당연히 맵 안에 인덱스가 들어와야 하는 것이고 
					if (map[y][x] < map[ny][nx]) { // 도착지점부터 출발지점으로 가는거니까, 현재위치보다 높은 방향으로 진행 - 만약 이 조건이 충족이 안되면 dfs를 호출조차 하지 않는다. 
						dp[y][x] += dfs(ny, nx); // 각 방향에서 수집한 정보(즉, 4방의 각 지점에서부터 출발점까지 갈 수 있는 방법의 수를 차례로 더해줌)
					}
				}
			}
		}
		
		return dp[y][x]; // 만약 방문 했었던 칸이라면 해당 칸에서부터 출발점(0, 0)까지 갈 수 있는 방법의 수를 반환함 
	}
}

// 출처: http://mygumi.tistory.com/231