package baekjoon;

// https://www.acmicpc.net/problem/1005

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 참고 : http://mygumi.tistory.com/178
// 참고(위상정렬): https://m.terms.naver.com/entry.nhn?docId=3579618&cid=59086&categoryId=59093
// 참고 : 스트링 관련 클래스들에 대하여 : https://novemberde.github.io/2017/04/15/String_0.html
public class Q1005 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] time = new int[n+1];
			boolean[][] adj = new boolean[n+1][n+1];
			int[] indegree = new int[n+1];
			
			time = Arrays.stream(("0 " + br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i=0; i<k; i++) {
				String[] tmp = br.readLine().split(" ");
				int x = Integer.parseInt(tmp[0]);
				int y = Integer.parseInt(tmp[1]);
				
				adj[x][y] = true;
				indegree[y]++;
			}
			
			int w = Integer.parseInt(br.readLine());
			int[] result = topologicalSort(adj, indegree, time);
			
			sb.append(result[w] + "\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static int[] topologicalSort(boolean[][] adj, int[] indegree, int[] time) {
		Queue<Integer> q = new LinkedList<Integer>(); 
		int len = indegree.length;
		int[] result = new int[len];
		
		for (int i=1; i<len; i++) {
			if(indegree[i] == 0) { // 진입차수가 0인 친구들을 일단 큐에 넣어주는 과정
				result[i] = time[i];
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int v = q.poll(); // 위상정렬 결과 인쇄시, 인쇄지점 
			for (int i=1; i<len; i++) {
				if(adj[v][i]) {
					result[i] = Math.max(result[i], result[v] + time[i]); // 필요 건물들을 짓는데 걸리는 최장시간을 뽑아낸다. 
					
					if(--indegree[i] == 0) {
						q.add(i);
					}
				}
			}
		}
		return result;
	}
}