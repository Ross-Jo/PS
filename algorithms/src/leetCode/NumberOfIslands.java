package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	static int[] xs = {0,-1,0,1};
	static int[] ys = {-1,0,1,0};
	static boolean[][] check;
	static class Point {
		int i, j;
		Point(int i, int j){this.i=i; this.j=j;}
	}
	
	static void BFS(int i, int j, char[][] grid) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i, j));
		check[i][j] = true;
		
		while(!q.isEmpty()) {
			Point here = q.poll();
			int x=here.i, y=here.j;
			for (int d=0;d<4;d++) {
				int nx=x+xs[d], ny=y+ys[d];
				if(0<=nx && nx<check.length && 0<=ny && ny<check[0].length && !check[nx][ny] && grid[nx][ny]=='1') {
					check[nx][ny]=true;
					q.add(new Point(nx, ny));
				}
			}
		}
	}
	
	static int numIsLands(char[][] grid) {
		if (grid==null || grid.length==0) return 0;
		check = new boolean[grid.length][grid[0].length];
		
		int num = 0;
		for (int i=0; i<grid.length; i++) for (int j=0; j<grid[0].length; j++) {
			if(!check[i][j] && grid[i][j]=='1') {
				num++;
				BFS(i, j, grid);
			}
		}
		return num;
	}
	
	
	public static void main(String[] args) {
		char[][] input1 = {
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}
		};
		
		System.out.println(numIsLands(input1));
	}
}
