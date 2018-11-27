package baekjoon;

// https://www.acmicpc.net/problem/1890

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1890 {
	
	static int N;
	static int[][] board;
	static long[][] cache;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		cache = new long[N][N];
		for (long[] row: cache) Arrays.fill(row, -1); // 2차원 배열 초기화는 이렇게 해줘야 한다. 
		
		for (int i=0; i<N; i++) board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(find(0, 0));
		
		br.close();
	}
	
	static long find(int x, int y) { // 정확히 같은 부분문제 구조를 사용하기 때문에 아래와 같은 구조가 성립한다.
		if(x >= N || y >= N) return 0;
		if(x == N-1 && y == N-1) return 1;
		if(board[x][y] == 0) return 0; // 칸의 값이 0일때 무한정 호출하는 것을 방지한다. 
		
		if(cache[x][y] != -1) return cache[x][y];
		int jumpSize = board[x][y];
		return cache[x][y] = find(x+jumpSize, y) + find(x, y+jumpSize);
	}
}
