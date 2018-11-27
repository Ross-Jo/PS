package baekjoon;

// https://www.acmicpc.net/problem/15686

import java.util.ArrayList;
import java.util.Scanner;

public class Q15686 {
	static class Point {
		int x; int y;
		Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	static int N, M, CH;
	static ArrayList<Point> h = new ArrayList<>(); // 집
	static ArrayList<Point> cs = new ArrayList<>(); // 치킨집 
	
	static int cd (int[][] map) { // 치킨거리를 계산하는 부분도 시간 복잡도를 N^2에서 h * cs로 줄임 
		int sum = 0;
		for (Point el: h) {
			int ehd = 987654321;
			
			for (Point cl: cs) {
				if (map[cl.x][cl.y] == 2) {
					int d = Math.abs(el.x - cl.x) + Math.abs(el.y - cl.y);
					if (ehd > d) ehd = d;
				}
			}
			if (ehd != 987654321) sum += ehd;
			else sum = ehd;
		}
		return sum;
	}
	
	static int distroy(int[][] map, int c, int x) { // 검사를 마친 행부터 시작하는 약간의 최적화가 시간초과 문제를 해결함. 
		if (c >= CH - M) return cd(map); // M개만 남길 수 있을 정도로 부숴버리면, 리턴. 
		int ans = 987654321;
		
		for (int i=x; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
					int ret = distroy(map, c + 1, i);
					if (ret < ans) ans = ret;
					map[i][j] = 2;
				}
			}
		}
		return ans;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					h.add(new Point(i,j));
				} else if (map[i][j] == 2) {
					cs.add(new Point(i,j));
					CH++;
				}
			}
		}
		System.out.println(distroy(map, 0, 0));
		sc.close();
	}
}