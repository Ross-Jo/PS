package baekjoon;

// https://www.acmicpc.net/problem/11062
// 참고: https://www.acmicpc.net/source/4569937

import java.io.*;
import java.util.stream.Stream;

class Q11062_3 {
	static int[] card;
	static int[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			int size = Integer.parseInt(br.readLine());
			
			// 방법1. 
			// card = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			// 방법2. 
			String[] line = br.readLine().split(" ");
			card = new int[size];
			for(int i = 0; i < size; i++) card[i] = Integer.parseInt(line[i]);
			
			// 방법 2번이 훨씬 빠르다. 이 부분만 바꿔 주었는데 480 -> 328ms 로 시간 단축  
			
			visited = new int[size][size];

			bw.write(turnA(0, size - 1) + "\n");
			T--;
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static int turnA(int left, int right) {
		if (left > right) return 0;
		if (visited[left][right] != 0) return visited[left][right];
		
		int takeLeft = card[left] + turnB(left + 1, right);
		int takeRight = card[right] + turnB(left, right - 1);
		
		return visited[left][right] = Math.max(takeLeft, takeRight);
	}

	public static int turnB(int left, int right) {
		if (left > right) return 0;
		
		int takeLeft = turnA(left + 1, right);
		int takeRight = turnA(left, right - 1);
		return Math.min(takeLeft, takeRight);
	}
}