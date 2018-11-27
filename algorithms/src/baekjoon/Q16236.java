package baekjoon;

// https://www.acmicpc.net/problem/16236

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q16236 {
	static int N, gi, gj, gs, ge, time;
	static int[][] map;
	static boolean[][] c;
	static int[] xs = {0,-1,0,1};
	static int[] ys = {-1,0,1,0};
	static ArrayList<Point> al;
	static ArrayList<Point> p;
	
	static class Point {
		int x, y, d;
		Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static void eatSth() {
		p = new ArrayList<>();
		int dis = 100;
		for (Point e: al) {
			if (e.d <= dis) {
				dis = e.d;
				p.add(e);
			}
			else break;
		}
		
		if (p.size()>=1) {
			
			Collections.sort(p, new Comparator<Point>() {
				@Override
				public int compare(Point p1, Point p2) {
					if (p1.x < p2.x) {
						return -1;
					} else if (p1.x == p2.x) {
						if (p1.y < p2.y) {
							return -1;
						} else if (p1.y == p2.y) {
							return 0;
						} else {
							return 1;
						}
					} else {
						return 1;
					}
				}
			});
			
			Point t = p.get(0);
			ge++;
			gi = t.x;
			gj = t.y;
			time += t.d;
			map[t.x][t.y] = 0;
			if (ge == gs) {
				gs++;
				ge = 0;
			}
			
		} else if (p.size() == 1) {
			Point t = p.get(0);
			ge++;
			gi = t.x;
			gj = t.y;
			time += t.d;
			map[t.x][t.y] = 0;
			if (ge == gs) {
				gs++;
				ge = 0;
			}
		}
		
	}
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		Point s = new Point(x, y, 0);
		c = new boolean[N][N];
		c[s.x][s.y] = true;
		q.add(s);
		al = new ArrayList<>();
		
		while(!q.isEmpty()) {
			Point h = q.poll();
			for (int i=0; i<4; i++) {
				int nx = h.x + xs[i];
				int ny = h.y + ys[i];
				if ((nx>=0&&nx<N)&&(ny>=0&&ny<N)&&!c[nx][ny]&&map[nx][ny]<=gs) {
					q.add(new Point(nx, ny, h.d+1));
					c[nx][ny] = true;
					
					if (map[nx][ny] < gs && map[nx][ny]!=0) {
						al.add(new Point(nx, ny, h.d+1));
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		gs = 2; ge = 0;
		time = 0;
		int fish = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					gi = i;
					gj = j;
					map[i][j] = 0;
				} else if (map[i][j]>=1 && map[i][j]<=6) {
					fish++;
				}
			}
		}
		
		while(fish-->0) {
			bfs(gi, gj);
			eatSth();
		}
		
		System.out.println(time);
		sc.close();
	}
}