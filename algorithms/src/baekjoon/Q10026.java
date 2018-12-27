package baekjoon;

//https://www.acmicpc.net/problem/10026

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q10026 { 
	static int N; 
	static char[][] map;
	static int[][] c;
	static int[] xs = {0, -1, 0, 1};
	static int[] ys = {-1, 0, 1, 0};
	
	static class Point {
		int x; int y;
		Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	
	static void bfs(Point s, boolean rgb) {
		Queue<Point> q = new LinkedList<>();
		q.add(s);
		c[s.x][s.y] = 1;
		
		if (!rgb) {
			while(!q.isEmpty()) {
				Point here = q.poll();
				for (int i=0; i<4; i++) {
					int nx = here.x + xs[i];
					int ny = here.y + ys[i];
					if ((nx>=0&&nx<N)&&(ny>=0&&ny<N)&&(c[nx][ny]==0) &&
						(map[here.x][here.y] == map[nx][ny])) {
						c[nx][ny]=1;
						q.add(new Point(nx, ny));
					}
				}
			}
		} else {
			while(!q.isEmpty()) {
				Point here = q.poll();
				for (int i=0; i<4; i++) {
					int nx = here.x + xs[i];
					int ny = here.y + ys[i];
					if ((nx>=0&&nx<N)&&(ny>=0&&ny<N)&&(c[nx][ny]==0)) {
						if ((map[here.x][here.y] == 'R' || map[here.x][here.y] == 'G') &&
							(map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
							c[nx][ny]=1;
							q.add(new Point(nx, ny));
						} else {
							if (map[here.x][here.y] == map[nx][ny]) {
								c[nx][ny]=1;
								q.add(new Point(nx, ny));
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int ans1, ans2;
		ans1 = ans2 = 0;
		
		map = new char[N][N];
		for (int i=0; i<N; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		c = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (c[i][j] == 0) {
					ans1++;
					bfs(new Point(i,j), false);
				}
			}
		}
		
		c = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (c[i][j] == 0) {
					ans2++;
					bfs(new Point(i,j), true);
				}
			}
		}
		
		System.out.println(ans1 + " " + ans2);
		
		sc.close();
	}
}
