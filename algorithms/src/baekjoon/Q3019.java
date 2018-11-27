package baekjoon;

//https://www.acmicpc.net/problem/3019

import java.util.Scanner;

public class Q3019 {
	static int c, p;
	static int[][] f;
	static int[] h;
	static int ans = 0;
	static int[][][][] bs = {
		{
			{{0,0}, {-1,0}, {-2,0}, {-3,0}},
			{{0,-3}, {0,-2}, {0,-1}, {0,0}}
		},
		{
			{{0,0},{0,-1},{-1,-1},{-1,0}}
		},
		{
			{{0, -1},{0,0},{-1,0},{-1,1}},
			{{0, 0},{-1,0},{-1,-1},{-2,-1}}
		},
		{
			{{-1, -2},{-1,-1},{0,-1},{0,0}},
			{{0, 0},{-1,0},{-1,1},{-2,1}}
		}, 
		{
			{{0,-2},{0,-1},{-1,-1},{0,0}},
			{{0,0},{-1,0},{-2,0},{-1,1}},
			{{0,0},{-1,-1},{-1,0},{-1,1}},
			{{-1,-1},{-1,0},{-2,0},{0,0}},
		},
		{
			{{0,-2},{0,-1},{0,0},{-1,0}},
			{{-2,-1},{-1,-1},{0,-1},{0,0}},
			{{0,0},{-1,0},{-1,1},{-1,2}},
			{{-2,-1},{-2,0},{-1,0},{0,0}},
		},
		{
			{{-1,-2},{0,-2},{0,-1},{0,0}},
			{{-2,1},{-2,0},{-1,0},{0,0}},
			{{-1,-2},{-1,-1},{-1,0},{0,0}},
			{{0,-1},{0,0},{-1,0},{-2,0}}
		}
	};
	
	static boolean check() {
		for (int j=0; j<c; j++) {
			int mem = 0;
			for (int i=0; i<110; i++) {
				if(f[i][j] != 0) mem = f[i][j];
				else if (f[i][j] == 0 && mem != 0) return false;
			}
		}
		return true;
	}
	
	static void drop() {
		for (int j=0; j<c; j++) {
			int sx = 109 - h[j];
			int sy = j;
			for (int i=0; i<bs[p-1].length; i++) {
				boolean flag = true;
				for (int k=0; k<bs[p-1][i].length; k++) {
					int nx = sx + bs[p-1][i][k][0];
					int ny = sy + bs[p-1][i][k][1];
					
					if (!(nx>=0 && nx < 110) || !(ny>=0 && ny<c) || !(f[nx][ny] == 0)) {
						flag = false;
					}
				}
				if (flag) {
					for (int k=0; k<bs[p-1][i].length; k++) {
						int nx = sx + bs[p-1][i][k][0];
						int ny = sy + bs[p-1][i][k][1];
						f[nx][ny] = 2;
					}
					if(check()) ans++;
					for (int k=0; k<bs[p-1][i].length; k++) {
						int nx = sx + bs[p-1][i][k][0];
						int ny = sy + bs[p-1][i][k][1];
						f[nx][ny] = 0;
					}
				}
			}
		}
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		p = sc.nextInt();
		f = new int[110][c];
		h = new int[c];
		
		for (int j=0; j<c; j++) {
			h[j] = sc.nextInt();
			for (int i=110-1, k=h[j]; k>0; i--, k--) {
				f[i][j] = 1;
			}
		}
		drop();
		System.out.println(ans);
		sc.close();
	}
}