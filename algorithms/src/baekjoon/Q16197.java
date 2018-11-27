package baekjoon;

// https://www.acmicpc.net/problem/16197

import java.util.Scanner;

public class Q16197 {
	static int N,M;
	static char[][] map;
	static int ans = 11;
	
	static int[] xs = {0,-1,0,1};
	static int[] ys = {-1,0,1,0};
	
	static void move(int c, int x1, int y1, int x2, int y2) {
		if (c == 0) return;
		for (int i=0; i<4; i++) {
			int nx1 = x1 + xs[i];
			int ny1 = y1 + ys[i];
			int nx2 = x2 + xs[i];
			int ny2 = y2 + ys[i];
			
			boolean cond1 = nx1 >=0 && nx1 < N && ny1 >=0 && ny1 < M;
			boolean cond2 = nx2 >=0 && nx2 < N && ny2 >=0 && ny2 < M;
			boolean cond3 = (nx1 == nx2) && (ny1 == ny2);
			boolean cond4 = (x1 == nx2) && (y1 == ny2);
			boolean cond5 = (nx1 == x2) && (ny1 == y2);
			
			if (!cond1 && !cond2) continue;
			
			if ((cond1 && !cond2) || (!cond1 && cond2)) {
				if (ans > 11-c) ans = 11-c;
				return;
			}
			
			if (cond1 && cond2) {
				if (map[nx1][ny1] == '#' && map[nx2][ny2] == '#') {
					continue;
				} else if (map[nx1][ny1] == '#') {
					if (!cond4) move(c-1, x1, y1, nx2, ny2);
				} else if (map[nx2][ny2] == '#') {
					if (!cond5) move(c-1, nx1, ny1, x2, y2);
				} else {
					if (!cond3) move(c-1, nx1, ny1, nx2, ny2);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); M = sc.nextInt();
		map = new char[N][M];
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		
		boolean flag = true;
		for (int i=0; i<N; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j=0; j<M; j++) {
				map[i][j] = tmp[j];
				if (map[i][j] == 'o') {
					if (flag) {
						x1 = i; y1 = j;
						flag = false;
					} else {
						x2 = i; y2 = j;
					}
				}
			}
		}
		
		move(10, x1, y1, x2, y2);
		System.out.println(ans==11? -1: ans);
		
		sc.close();
	}
}
