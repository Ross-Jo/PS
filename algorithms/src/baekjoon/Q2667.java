package baekjoon;

// https://www.acmicpc.net/problem/2667

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q2667 {
	static int N;
	static int[][] map;
	static boolean[][] checker;
	static int[] xs = {0, -1, 0, 1};
	static int[] ys = {-1, 0, 1, 0};
	
	class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x; 
			this.y = y;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Q2667 q = new Q2667();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		checker = new boolean[N][N];
		for (int i=0; i<N; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		
		int[] ans = q.solve();
		Arrays.sort(ans);
		
		System.out.println(ans.length);
		for (int el: ans) {
			System.out.println(el);
		}
		
		br.close();
	}
	
	int[] solve() {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 1 && checker[i][j] == false) {
					al.add(bfs(new Point(i, j)));
				}
			}
		}
		
		return al.stream().mapToInt(i -> i).toArray(); // Integer배열 -> Int배열 
	}
	
	int bfs(Point start) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(start);
		checker[start.x][start.y] = true; // 넣으면 바로 방문표시, 이렇게 안하면 넣은 포인트를 또 큐에 넣는 불상사가 생길 수 있음 
		int counter = 1;
		
		while(!q.isEmpty()) {
			Point here = q.poll();
			for (int i=0; i<4; i++) {
				if (here.x + xs[i] >= 0 && here.x + xs[i] < N && 
					here.y + ys[i] >= 0 && here.y + ys[i] < N && 
					map[here.x + xs[i]][here.y + ys[i]] == 1 &&
					checker[here.x + xs[i]][here.y + ys[i]] == false) {
					q.add(new Point(here.x + xs[i], here.y + ys[i]));
					checker[here.x + xs[i]][here.y + ys[i]] = true;
					counter++;
				}
			}
		}
		return counter;
	}
}