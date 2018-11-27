package baekjoon;

// https://www.acmicpc.net/problem/3190

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class Q3190 {
	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	
	static int[] xs = {0,-1,0,1,0};
	static int[] ys = {0,0,1,0,-1};
	
	static int changeDir(int dir, char C) {
		switch(dir) {
			case 1:
				if(C == 'L') return 4;
				else return 2;
			case 2:
				if(C == 'L') return 1;
				else return 3;	
			case 3:
				if(C == 'L') return 2;
				else return 4;	
			default:
				if(C == 'L') return 3;
				else return 1;	
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); int K = sc.nextInt();
		int[][] map = new int[N][N];
		
		for(int i=0; i<K; i++) map[sc.nextInt()-1][sc.nextInt()-1] = 2;
		
		Deque<Point> snake = new LinkedList<>();
		snake.addFirst(new Point(0,0));
		int dir = 2;
		int hx = 0; int hy = 0;
		int timer = 0;
		
		int L = sc.nextInt();
		char[] dirInfo = new char[10000 + 1];
		while(L-- > 0) {
			int X = sc.nextInt();
			char C = sc.next().charAt(0);
			dirInfo[X] = C;
		}
		
		
		for(int i=1; i<=10000; i++) {
			timer++;
			int nx = hx + xs[dir];
			int ny = hy + ys[dir];
			
			if(!(nx>=0 && nx<N)||!(ny>=0 && ny<N)) {
				System.out.println(timer);
				
				sc.close();
				return;
			}
			
			if (map[nx][ny] == 1) {
				System.out.println(timer);
				
				sc.close();
				return;
			}
			else if (map[nx][ny] == 0) {
				map[nx][ny] = 1;
				hx = nx;
				hy = ny;
				snake.addFirst(new Point(hx, hy));
				
				Point tail = snake.pollLast();
				map[tail.x][tail.y] = 0;
			}
			else if (map[nx][ny] == 2) {
				map[nx][ny] = 1;
				hx = nx;
				hy = ny;
				snake.addFirst(new Point(hx, hy));
			}
			
			if (dirInfo[i] != '\u0000') dir = changeDir(dir, dirInfo[i]);
		}
		
		sc.close();
	}
}