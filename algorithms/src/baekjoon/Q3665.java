package baekjoon;

// https://www.acmicpc.net/problem/3665

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q3665 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			boolean[][] g = new boolean[n+1][n+1];
			int[] indegree = new int[n+1];
			int[] prevRes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			StringBuilder sb = new StringBuilder();
			
			for (int i=0; i<prevRes.length-1; i++) {
				for (int j=i+1; j<prevRes.length; j++) {
					g[prevRes[i]][prevRes[j]] = true;
					indegree[prevRes[j]]++;
				}
			}
			
			int m = Integer.parseInt(br.readLine());
			
			ArrayList<int[]> al = new ArrayList<>();
			for (int i=0; i<m; i++) {
				String[] info = br.readLine().split(" ");
				al.add(new int[]{Integer.parseInt(info[0]), Integer.parseInt(info[1])});
			}
			
			for(int[] el: al) {
				int h = el[0];
				int l = el[1];
				
				if (g[h][l]) {
					g[h][l] = false;
					g[l][h] = true;
					indegree[l]--;
					indegree[h]++;
				} else if (g[l][h]) {
					g[l][h] = false;
					g[h][l] = true;
					indegree[h]--;
					indegree[l]++;
				}
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i=1; i<=n; i++) if(indegree[i]==0) q.add(i);
			
			boolean flag = false;
			for (int i=1; i<=n; i++) {
				if(q.size() >= 2) {
					System.out.println("?");
					flag = true;
					break;
				} else if(q.size() == 0) {
					System.out.println("IMPOSSIBLE");
					flag = true;
					break;
				}
				
				int h = q.poll();
				sb.append(h).append(' ');
				for (int j=1; j<=n; j++) {
					if(g[h][j]) {
						if(--indegree[j]==0) {
							q.add(j);
						}
					}
				}
			}
			if(flag) continue;
			System.out.println(sb.toString());
		}
		
		br.close();
	}
}