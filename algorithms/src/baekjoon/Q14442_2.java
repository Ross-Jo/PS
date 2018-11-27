package baekjoon;

// https://www.acmicpc.net/problem/14442

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14442_2 {
	static int N,M,K;
	static char[][] map;
	static boolean[][][] c;
	static int ans = 987654321;
	static int[] xs = {0,-1,0,1};
	static int[] ys = {-1,0,1,0};
	
	static class Point {
		int x, y, k, c; 
		Point(int x, int y, int k, int c) {
			this.x = x; this.y = y; this.k = k; this.c = c;
		}
	}
	
	static void bfs() {
		Point start = new Point(0,0,K,1);
		Queue<Point> q = new LinkedList<>();
		c[start.x][start.y][0] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			Point h = q.poll();
			
			if (h.x == N-1 && h.y == M-1) {
				if (ans > h.c) ans = h.c;
			}
			
			for (int i=0; i<4; i++) {
				int nx = h.x + xs[i];
				int ny = h.y + ys[i];
				if ((nx>=0&&nx<N)&&(ny>=0&&ny<M)) {
					if (map[nx][ny]=='1' && h.k > 0 && !c[nx][ny][h.k]) {
						c[nx][ny][h.k] = true; // 내가 벽을 부술 수 있는 카드가 몇장인 상태에서 방문 했는지를 기록해야됨 
						q.add(new Point(nx, ny, h.k-1, h.c+1));
					} else if (map[nx][ny]=='0' && !c[nx][ny][h.k]) {
						c[nx][ny][h.k] = true;
						q.add(new Point(nx, ny, h.k, h.c+1));
					}
				}
			}
		}
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); M = sc.nextInt(); K = sc.nextInt();
		map = new char[N][M];
		c = new boolean[N][M][K+1];
		
		for (int i=0; i<N; i++) map[i] = sc.next().toCharArray();
		
		bfs();
		System.out.println(ans == 987654321 ? -1 : ans);
		
		sc.close();
	}
}