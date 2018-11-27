package baekjoon;

// https://www.acmicpc.net/problem/14500

import java.util.Scanner;

public class Q14500 {
	static int N, M;
	static int[][] map = new int[500][500];
	static boolean[][] c = new boolean[500][500];;
	static int[][] xs = {
		{0, -1, 0},
		{0, -1, 1},
		{0, 1, 0},
		{-1, 0, 1}
	};
	static int[][] ys = {
		{-1, 0, 1},
		{-1, 0, 0},
		{-1, 0, 1},
		{0, 1, 0}
	};
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	// 배울점 : 비효율적으로 짜면 맞는 코드라도 시간초과가 날 수 있음을 다시한번 명심 또 명심하자 
	
	static int dfs(int i, int j, int count) {
		if (count == 0) return 0;
		c[i][j] = true;
		
		int tmp = 0;
		for(int k=0; k<4; k++) {
			int ni = i + dx[k];
			int nj = j + dy[k];
			if (count > 0 && (ni >= 0 && ni < N) && (nj >=0 && nj < M) && c[ni][nj] == false) {
				int ret = dfs(ni, nj, count - 1);
				if (ret > tmp) tmp = ret;
//				c[ni][nj] = false; // 상태를 원상태로 복구 시키기 위한 행위가 매우 중요하다 
			}
		}
		c[i][j] = false; // 상태를 원상태로 복구 시키기 위한 행위가 매우 중요하다 
						 // (여기서 이렇게 해제해야지, line 38 처럼 해제하면 안된다. line 38처럼 해제하면 line 51과 같은 코드가 필요한데 이는 상당한 오버헤드가 있고 시간초과를 유발한다)
						 // 그리고 line 42과 같이 깔끔하게 해제하면 당연히 line 51과 같은 재할당은 필요가 없어짐 
		return map[i][j] + tmp;
	}
	
	static int solve() {
		int max = 0;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
//				c = new boolean[500][500];
				max = Math.max(dfs(i, j, 4), max);
				
				for (int k=0; k<4; k++) {
					int sum = map[i][j];
					for (int l=0; l<3; l++) {
						int ni = i + xs[k][l];
						int nj = j + ys[k][l];
						if ((ni >=0 && ni < N) && (nj >=0 && nj < M)) { // 3칸은 4칸보다 작기 때문에 상관 없음 
							sum += map[ni][nj];
						}
					}
					max = Math.max(max, sum);
				}
			}
		}
		
		return max;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 4<=N, M<=500
		M = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve());
		sc.close();
	}
}