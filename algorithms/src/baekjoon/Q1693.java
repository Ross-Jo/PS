package baekjoon;

//https://www.acmicpc.net/problem/1693
//참고 : http://blog.encrypted.gg/144

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1693 {
	
	static final int MAX = 100001;
	static final int COLOR = 18;
	static final int INF = 987654321;
	
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>(MAX);
	static boolean[] visited = new boolean[MAX];
	static int[][] cache = new int[MAX][COLOR];
	
	static int coloring(int pos, int color) {
		int ret = cache[pos][color];
		if (ret != -1) return ret;
		visited[pos] = true;
		cache[pos][color] = color;
		
		for (int e: tree.get(pos)) {
			if (visited[e]) continue;
			int choose = INF;
			for (int j=1; j<=17; j++) {
				if (j!=color) choose = Math.min(choose, coloring(e, j));
			}
			cache[pos][color] += choose;
		}
		
		visited[pos] = false;
		return cache[pos][color];
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0; i<=n; i++) tree.add(new ArrayList<>());
		
		for (int i=0; i<n-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		for (int i=0; i<cache.length; i++) Arrays.fill(cache[i], -1);
		int ans = INF;
		for (int i=1; i<=17; i++) ans = Math.min(ans, coloring(1,i));
		System.out.println(ans);
		
		sc.close();
	}
}