package baekjoon;

//https://www.acmicpc.net/problem/1600

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1600 {
	static int K, W, H;
	static int[][] map;
	static int[][][] c;
	static int ans;
	static int[] xs = {0,-1,0,1};
	static int[] ys = {-1,0,1,0};
	
	static int[] hxs = {-1,-2,-2,-1,1,2,2,1};
	static int[] hys = {-2,-1,1,2,2,1,-1,-2};
	
	static class Point {
		int x, y, k;
		Point(int x, int y, int k) {
			this.x = x; this.y = y; this.k = k;
		}
	}
	
	static void bfs() {
		Point s = new Point(0,0,0);
		Queue<Point> q = new LinkedList<>();
		c[0][0][0] = 0;
		q.add(s);
		
		while(!q.isEmpty()) {
			Point h = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = h.x + xs[i];
				int ny = h.y + ys[i];
				if((nx>=0&&nx<H)&&(ny>=0&&ny<W)&&map[nx][ny]!=1&&c[nx][ny][h.k]==-1) {
					c[nx][ny][h.k]=c[h.x][h.y][h.k]+1;
					q.add(new Point(nx, ny, h.k));
				}
			}
			
			for (int i=0; i<8; i++) {
				int nx = h.x + hxs[i];
				int ny = h.y + hys[i];
				if((nx>=0&&nx<H)&&(ny>=0&&ny<W)&&map[nx][ny]!=1&&h.k+1<=K&&c[nx][ny][h.k+1]==-1) {
					c[nx][ny][h.k+1]=c[h.x][h.y][h.k]+1;
					q.add(new Point(nx, ny, h.k+1));
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt(); W = sc.nextInt(); H = sc.nextInt();
		map = new int[H][W];
		c = new int[H][W][K+1];
		
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				map[i][j] = sc.nextInt();
				Arrays.fill(c[i][j], -1);
			}
		}
		
		bfs();
		
		int ans = 987654321;
		for (int i=0; i<=K; i++) {
			if(c[H-1][W-1][i] != -1 && ans > c[H-1][W-1][i]) ans = c[H-1][W-1][i];
		}
		
		System.out.println(ans == 987654321 ? -1 : ans);
		
		sc.close();
	}
}