package baekjoon;

// https://www.acmicpc.net/problem/14502

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14502 {
	
	static int N, M;
	static int[][] map;
	static int[][] checker;
	static int ans = -1;
	static ArrayList<Point> al = new ArrayList<>();
	
	static int[] xs = {0, -1, 0, 1};
	static int[] ys = {-1, 0, 1, 0};
	
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	
	static int virus() {
		Queue<Point> q = new LinkedList<>();
		for (int i=0; i<N; i++) checker[i] = Arrays.copyOf(map[i], map[i].length); 
		for (Point e: al) q.add(e);
		
		while(!q.isEmpty()) {
			Point here =q.poll();
			checker[here.x][here.y] = 2;
			
			for (int i=0; i<4; i++) {
				int nx = here.x + xs[i];
				int ny = here.y + ys[i];
				if ((nx >=0 && nx < N) && (ny >=0 && ny < M) && map[nx][ny] != 1 && checker[nx][ny] != 2) {
					checker[nx][ny] = 2; // 이 줄에 유의하자. 여기 없으면 큐에 들어가는 요소의 중복생김 
					q.add(new Point(nx, ny)); 
				}
			}
		}
		
		int c = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(checker[i][j] == 0) {
					c++;
				}
			}
		}
		return c;
	}
	
	static void wall(int count) {
		if (count == 0) {
			int ret = virus();
			if(ans < ret) ans = ret;
			return;
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(count-1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		checker = new int[N][M];
		
		for (int i=0; i<N; i++) {
			for (int j=0;j<M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					al.add(new Point(i, j));
				}
			}
		}
		wall(3);
		System.out.println(ans);
		sc.close();
	}
}