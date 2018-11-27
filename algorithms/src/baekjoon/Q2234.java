package baekjoon;

//https://www.acmicpc.net/problem/2234

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Q2234 {
	public static int m, n, count = 1;
	public static int[][] map;
	public static int[][] c;
	public static ArrayList<Integer> rs = new ArrayList<>();
	
	public static int[] xs = {0,-1,0,1};
	public static int[] ys = {-1,0,1,0};
	
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	
	public static void bfs(int x, int y) {
		Point s = new Point(x,y);
		Queue<Point> q = new LinkedList<>();
		int ic = 0;
		
		c[s.x][s.y] = count;
		ic++;
		q.add(s);
		
		while(!q.isEmpty()) {
			Point h = q.poll();
			for (int i=0; i<4; i++) {
				int nx = h.x + xs[i];
				int ny = h.y + ys[i];
				if ((nx>=0&&nx<m)&&(ny>=0&&ny<n)&&c[nx][ny]==0&&
					(((1<<i)&map[h.x][h.y])==0)) {
					c[nx][ny] = count;
					ic++;
					q.add(new Point(nx, ny));
				}
			}
		}
		rs.add(ic);
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] t = br.readLine().split(" ");
		n = Integer.parseInt(t[0]);
		m = Integer.parseInt(t[1]);
		map = new int[m][n];
		c = new int[m][n];
		
		for (int i=0; i<m; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (c[i][j]==0) {
					bfs(i,j);
					count++;
				}
			}
		}
		
		int ans = -1;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n-1; j++) {
				if (c[i][j] != c[i][j+1]) {
					int size = rs.get(c[i][j]-1) + rs.get(c[i][j+1]-1);
					if (ans < size) ans = size;
				}
			}
		}
		
		for (int j=0; j<n; j++) {
			for (int i=0; i<m-1; i++) {
				if (c[i][j] != c[i+1][j]) {
					int size = rs.get(c[i][j]-1) + rs.get(c[i+1][j]-1);
					if (ans < size) ans = size;
				}
			}
		}
		
		System.out.println(rs.size());
		System.out.println(Collections.max(rs));
		System.out.println(ans);
		
		br.close();
	}
}