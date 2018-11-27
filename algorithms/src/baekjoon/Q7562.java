package baekjoon;

// https://www.acmicpc.net/problem/7562

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7562 {
	static int[][] map;
	static int l;
	static int[] xs = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] ys = {1, 2, 2, 1, -1, -2, -2, -1};
	
	static class Point {
		int x;
		int y;
		int c;
		Point(int x, int y, int c) {
			this.x = x; this.y = y; this.c = c;
		}
	}
	
	static int bfs(Point node) {
		Queue<Point> q = new LinkedList<>();
		q.add(node);
		map[node.x][node.y] = 1; // 방문 표시를 유의해서 하자

		while(!q.isEmpty()) {
			Point here = q.poll();
			
			int nc = here.c + 1;
			for (int i=0; i<xs.length; i++) {
				int nx = here.x + xs[i]; int ny = here.y + ys[i]; 
				if((nx >= 0 && nx < l) && (ny >= 0 && ny < l)) {
					if(map[nx][ny] == 0) {
						q.add(new Point(nx, ny, nc));
						map[nx][ny] = 1;
					} else if(map[nx][ny] == -1) return nc;
				}
			}
		}
		return 0;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while(T-->0) {
			l = sc.nextInt();
			Point cur = new Point(sc.nextInt(), sc.nextInt(), 0);
			map = new int[l][l];
			map[sc.nextInt()][sc.nextInt()] = -1; // 목적
			System.out.println(bfs(cur));
		}
		sc.close();
	}
}