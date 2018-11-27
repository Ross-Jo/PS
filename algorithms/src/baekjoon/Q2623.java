package baekjoon;

// https://www.acmicpc.net/problem/2623

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//참고: https://m.blog.naver.com/kks227/220800013823
//위상정렬 

public class Q2623 {
	public static int N,M;
	public static boolean[][] g = new boolean[1001][1001];
	public static int[] indegree = new int[1001];
	public static boolean[] v = new boolean[1001];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i=0; i<M; i++) {
			int rn = sc.nextInt();
			int[] rs = new int[rn];
			for (int j=0; j<rn; j++) {
				rs[j] = sc.nextInt();
			}
			for (int j=0; j<rn-1; j++) {
				if(g[rs[j]][rs[j+1]] == false) { // 중복 간선 입력에 대한 처리를 해야함 
					g[rs[j]][rs[j+1]] = true;
					indegree[rs[j+1]]++;
				}
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> r = new ArrayList<>();
		
		for (int i=1; i<=N; i++) {
			if (indegree[i]==0) {
				q.add(i);
				v[i] = true;
			}
		}
		
		for (int p=1; p<=N; p++) {
			if (q.isEmpty()) {
				System.out.println(0);
				
				sc.close();
				return;
			}
			int h = q.poll();
			r.add(h);
			
			for (int i=1; i<=N; i++) {
				if(g[h][i]) {
					if (--indegree[i]==0 && !v[i]) { // 이렇게 하면 v테이블을 이용한 노드 방문 체크가 필요 없음 
						q.add(i);
						v[i] = true;
					}
				}
			}
		}
		
		for (int el: r) System.out.println(el);
		sc.close();
	}
}
