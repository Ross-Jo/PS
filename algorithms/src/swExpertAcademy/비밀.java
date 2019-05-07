package swExpertAcademy;

import java.util.Scanner;

public class 비밀 {
	static int T, N, K, M, map[][], ans;
	static boolean visited[];
	
	public static void dfs(int start, int depth) {
		if (ans < depth) ans = depth;

		for (int i = 1; i <= N; i++) {
			if (map[start][i] == 1 && visited[i] == false) {
				visited[i] = true;
				dfs(i, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static int sum(int[] res) {
		int s = 0;
		for (int e : res) s += e;
		return s;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = Integer.parseInt(sc.next());
		for (int t=1; t<=T; t++) {
			N = Integer.parseInt(sc.next());
			K = Integer.parseInt(sc.next());
			map = new int[N+1][N+1];
			visited = new boolean[N+1];
			
			for (int i = 0; i < K; i++) {
				M = Integer.parseInt(sc.next());
				int s = Integer.parseInt(sc.next());
				for (int j = 1; j < M; j++) {
					int e = Integer.parseInt(sc.next());
					map[s][e] = 1;
					s = e;
				}
			}
			
			System.out.print("#" + t + " "); boolean first = true;
			for (int[] res : map) {
				if (first) first = false;
				else System.out.print(sum(res) + " ");
			}
			
			ans = -1;
			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}

			System.out.println(ans);
		}
		sc.close();
	}
}
