package baekjoon;

// https://www.acmicpc.net/problem/14442

import java.util.Scanner;

//시간 초과 
public class Q14442 {
	static int N,M,K;
	static char[][] map;
	static boolean[][] c;
	static int ans = 987654321;
	static int[] xs = {0,-1,0,1};
	static int[] ys = {-1,0,1,0};

	static void dfs(int x, int y, int k, int count) {
		if (x == N-1 && y == M-1) {
			if (ans > count) ans = count;
			return;
		}
		c[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nx = x + xs[i];
			int ny = y + ys[i];
			
			if ((nx>=0&&nx<N)&&(ny>=0&&ny<M)&&!c[nx][ny]) {
				if (map[x][y] == '1' && k > 0) {
					dfs(nx, ny, k - 1, count + 1);
				} else if(map[x][y] == '0') {
					dfs(nx, ny, k, count + 1);
				}
			}
		}
		
		c[x][y] = false;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); M = sc.nextInt(); K = sc.nextInt();
		map = new char[N][M];
		c = new boolean[N][M];
		
		for (int i=0; i<N; i++) map[i] = sc.next().toCharArray();
		
		dfs(0,0,K,1);
		System.out.println(ans == 987654321 ? -1 : ans);
		
		sc.close();
	}
}