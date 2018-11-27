package baekjoon;

// https://www.acmicpc.net/problem/7569

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7569 {
	static int M, N, H;
	static int[][][] box;
	static int cnt = 0;
	int[] zs = {-1, 1, 0, 0, 0, 0};
	int[] ys = {0, 0, 0, -1, 0, 1};
	int[] xs = {0, 0, -1, 0, 1, 0};
	
	static class Point {
		int z, y, x, day;
		Point(int z, int y, int x, int day) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.day = day;
		}
	}
	
	public static void main(String args[]) throws IOException {
		Q7569 q = new Q7569();
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		box = new int[H][N][M];
		
		ArrayList<Point> sp = new ArrayList<Point>();
		
		for(int i=0; i<H; i++) {
			for (int j=0; j<N; j++) {
				for (int k=0; k<M; k++) {
					box[i][j][k] = sc.nextInt();
					if (box[i][j][k] == 1) {
						sp.add(new Point(i, j, k, 0));
					}
					else if (box[i][j][k] == 0) {
						cnt++;
					}
				}
			}
		}
		
		int ans = q.bfs(sp);
		
		System.out.println(cnt > 0 ? -1 : ans);
		
		sc.close();
	}
	
	int bfs(ArrayList<Point> sp) {
		Queue<Point> q = new LinkedList<Point>();
		for (Point p: sp) q.add(p);
		int day = 0;
		
		while(!q.isEmpty()) {
			Point h = q.poll();
			for (int i=0; i<6; i++) {
				int nz = h.z + zs[i];
				int ny = h.y + ys[i];
				int nx = h.x + xs[i];
				
				boolean c1 = nz >=0 && nz < H;
				boolean c2 = ny >=0 && ny < N;
				boolean c3 = nx >=0 && nx < M;
				
				if (c1 && c2 && c3 && (box[nz][ny][nx] == 0)) {
					q.add(new Point(nz, ny, nx, h.day + 1));
					box[nz][ny][nx] = 1;
					cnt--;
				}
			}
			day = day < h.day ? h.day : day;
		}
		
		return day;
	}
}