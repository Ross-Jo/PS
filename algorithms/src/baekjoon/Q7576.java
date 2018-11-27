package baekjoon;

// https://www.acmicpc.net/problem/7576

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
	public static int maxDay = -1;
	public static int[] xs = {0, -1, 0, 1};
	public static int[] ys = {-1, 0, 1, 0};
	
	static class Node {
		int x;
		int y;
		int day;
		Node(int x, int y, int day) {
			this.x = x; this.y = y; this.day = day;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		
		for (int i=0; i<N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		BFS(N, M, board);
		System.out.println(maxDay);
		
		br.close();
	}
	
	public static void BFS(int n, int m, int[][] board) {
		Queue<Node> q = new LinkedList<Node>();
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (board[i][j] == 1) {
					q.add(new Node(i, j, 0));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node here = q.poll();
			maxDay = Math.max(maxDay, here.day);
			for (int i=0; i<4; i++) {
				if (here.x + xs[i] < board.length && here.y + ys[i] < board[0].length && 
					0 <= here.x + xs[i] && 0 <= here.y + ys[i]
					&& board[here.x + xs[i]][here.y + ys[i]] == 0) {
					board[here.x + xs[i]][here.y + ys[i]] = 1;
					q.add(new Node(here.x + xs[i], here.y + ys[i], here.day + 1));
				}
			}
			
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if(board[i][j] == 0) {
					maxDay = -1;
				}
			}
		}
	}
}
