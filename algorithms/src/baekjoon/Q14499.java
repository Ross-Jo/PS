package baekjoon;

// https://www.acmicpc.net/problem/14499

import java.util.Scanner;

public class Q14499 {
	static int[] is = {0,0,-1,1};
	static int[] js = {1,-1,0,0};
	static int[] dice = {0,0,0,0,0,0};
	static int[][] r = {
		{0, 2, 3, 5, 4, 1},
		{0, 5, 1, 2, 4, 3},
		{5, 1, 0, 3, 2, 4},
		{2, 1, 4, 3, 5, 0}
	};
	
	static void change(int dir) {
		int[] nd = new int[dice.length];
		for (int i=0; i<dice.length; i++) nd[r[dir-1][i]] = dice[i];
		dice = nd;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); int M = sc.nextInt();
		int xi = sc.nextInt(); int yj = sc.nextInt();
		int K = sc.nextInt();
		int[][] map = new int[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		while(K-- > 0) {
			int dir = sc.nextInt(); // 동:1, 서:2, 북:3, 남:4
			int ni = xi + is[dir-1];
			int nj = yj + js[dir-1];
			boolean cond = (ni>=0 && ni < N) && (nj>=0 && nj<M);
			if (cond) {
				xi = ni;
				yj = nj;
				change(dir);
				
				if(map[xi][yj] == 0) {
					map[xi][yj] = dice[5];
				} else {
					dice[5] = map[xi][yj];
					map[xi][yj] = 0;
				}
				System.out.println(dice[2]);
			}
		}
		sc.close();
	}
}
