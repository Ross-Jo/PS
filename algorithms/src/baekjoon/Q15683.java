package baekjoon;

// https://www.acmicpc.net/problem/15683

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q15683 {
	static int N, M;
	static int[][] map;
	static int[][] c;
	static int ans = 987654321;
	static int[] xs = {0, -1, 0, 1};
	static int[] ys = {-1, 0, 1, 0};
	static int[][][] cctvs = {
		{{0}, {1}, {2}, {3}},
		{{0, 2}, {1, 3}},
		{{1, 2}, {2, 3}, {0, 3}, {0, 1}},
		{{0, 1, 2}, {1, 2, 3}, {0, 2, 3}, {0, 1, 3}},
		{{0, 1, 2, 3}}
	};
	static class Point {
		int x, y, t;
		Point (int x, int y, int t) {
			this.x = x; this.y = y; this.t = t;
		}
	}
	
	static ArrayList<Point> p = new ArrayList<>();
	static int bs(ArrayList<Integer> dirs) {
		for (int i=0; i<map.length; i++) c[i] = Arrays.copyOf(map[i], map[i].length);
		for (int i=0; i<p.size(); i++) {
			int x = p.get(i).x;
			int y = p.get(i).y;
			int t = p.get(i).t;
			
			for (int j=0; j<cctvs[t-1][dirs.get(i)].length; j++) {
				int cx = x;
				int cy = y;
				
				for(;;) {
					int nx = cx + xs[cctvs[t-1][dirs.get(i)][j]];
					int ny = cy + ys[cctvs[t-1][dirs.get(i)][j]];
					if ((nx>=0 && nx<N) && (ny>=0 && ny<M) && c[nx][ny] != 6) {
						if (c[nx][ny] == 0 || c[nx][ny] == -1) {
							c[nx][ny] = -1;
						}
						cx = nx;
						cy = ny;
					} else break;
				}
				
			}
		}
		
		int count = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (c[i][j] == 0) count++;
			}
		}
		
		return count;
	}
	
	static void dir(int index, ArrayList<Integer> dirs) {
		if(index == p.size()) {
			int ret = bs(dirs);
			if (ans > ret) ans = ret;
			return;
		}
		
		for (int i=index; i<p.size();) {
			switch(p.get(i).t) {
				case 1:
					for (int j=0; j<4; j++) {
						dirs.add(j);
						dir(index+1, dirs);
						dirs.remove(dirs.size() - 1); // arraylist의 마지막 요소 제거는 이렇게 하자 
					}
					break;
				case 2: 
					for (int j=0; j<2; j++) {
						dirs.add(j);
						dir(index+1, dirs);
						dirs.remove(dirs.size() - 1);
					}
					break;
				case 3:
					for (int j=0; j<4; j++) {
						dirs.add(j);
						dir(index+1, dirs);
						dirs.remove(dirs.size() - 1);
					}
					break;
				case 4:
					for (int j=0; j<4; j++) {
						dirs.add(j);
						dir(index+1, dirs);
						dirs.remove(dirs.size() - 1);
					}
					break;
				default:
					for (int j=0; j<1; j++) {
						dirs.add(j);
						dir(index+1, dirs);
						dirs.remove(dirs.size() - 1);
					}
			}
			break; // p.size()만큼 각 요소(element)들의 경우를 따지는 것이 아니기 때문에(각 요소별 경우는 case문 안에서 따지게 됨) 여기서 break를 해야됨 
		}
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		c = new int[N][M];

		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					p.add(new Point(i, j, map[i][j]));
				}
			}
		}
		
		dir(0, new ArrayList<Integer>());
		System.out.println(ans);
		
		sc.close();
	}
}
