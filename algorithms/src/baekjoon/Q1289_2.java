package baekjoon;

// https://www.acmicpc.net/problem/1289

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

// 참고 : http://codersbrunch.blogspot.com/2016/05/1289.html

public class Q1289_2 {
	static final int MOD = 1000000007;
	static int N;
	static long res;
	
	static ArrayList<Pair>[] adj;
	static class Pair {
		int f, s;
		public Pair(int f, int s) {
			this.f = f; this.s = s;
		}
	}
	
	static long dfs(int h, int p) { // p는 parent node를 의미함
		long s=1, t; // 탐색한 경로 기록용 변수 : s, 이웃(자식)노드를 루트로 가지는 트리에 대해서 경로 탐색 후 현재 노드의 weight를 곱해줘((a+b)*k == ak + bk), 저장해 둘 임시변수
		            // 이때 s의 초기화 값인 1은 가장 말단 경로(재귀호출에서 리턴될 시), 혹은 t*s에서 이용될 시 '기존에 방문했던 경로 가중치' 합계를 의미하게 된다. 
		for (Pair it: adj[h]) {
			if (it.f == p) continue; // 부모->자식 이동은 되지만, 자식->부모로 거슬러 올라가는 것은 방지함.
			t = dfs(it.f, h)*it.s%MOD; // 자식 트리에 대해서 탐색한 모든 경로의 합에 대해 현재 노드로의 weight를 곱해줌. (곱셈의 분배법칙을 떠올릴 것)
			res = (res+t*s)%MOD; // 먼저 알아낸 자식트리 경로와 현재 알아낸 트리 경로를 엮어 모든 경로에 대한 정보를 적체함.(이때, s는 기존에 탐색해서 기록해둔 경로를, t는 이번 탐색으로 알게된 경로를 의미함) 
			s = (s+t)%MOD; // 그간 방문한 경로 정보를 기록함 
		}
		return s;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = (ArrayList<Pair>[]) new ArrayList[N+1];
		for (int i=0; i<=N; i++) adj[i] = new ArrayList<Pair>();
		
		for (int i = 0; i < N - 1; i++) {
			int[] tmp = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			adj[tmp[0]].add(new Pair(tmp[1], tmp[2]));
			adj[tmp[1]].add(new Pair(tmp[0], tmp[2]));
		}
		dfs(1, -1);
		System.out.println(res);
		br.close();
	}
}

