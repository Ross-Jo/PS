package baekjoon;

//https://www.acmicpc.net/problem/1766

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1766_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] indegree = new int[N + 1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i <= N; i++) list.add(new ArrayList<Integer>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.get(A).add(B);
			indegree[B]++;
		}

		Queue<Integer> pq = new PriorityQueue<>(N+1); // 위상 정렬에서 우선순위 큐의 사용방법 
		for (int i = 1; i <= N; i++) if (indegree[i] == 0) pq.offer(i);

		StringBuilder ans = new StringBuilder();
		while (!pq.isEmpty()) {
			int x = pq.poll();
			for (int y : list.get(x)) {
				if (--indegree[y] == 0) {
					pq.offer(y);
				}
			}
			ans.append(x).append(' ');
		}
		ans.setCharAt(ans.length() - 1, '\n');
		System.out.print(ans);

		br.close();
	}
}