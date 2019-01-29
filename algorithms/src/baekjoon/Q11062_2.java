package baekjoon;

// https://www.acmicpc.net/problem/11062
// 참고 : https://wan088.github.io/algorithm/2018/07/15/algo-cardgame/
// 참고 : https://blog.encrypted.gg/504

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Q11062_2 {
	static int[][] dp;
	static int[] cards;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			cards = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			dp = new int[n][n];// 먼저 하는 사람 입장에서 남은 카드에 따른 최대 점수 합계 저장 
			bw.write(Integer.toString(BestCard(0, n - 1)));
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}

	static int BestCard(int left, int right) { // 카드가 left에서 right까지 남았을 때 얻을 수 있는 최고 점수
		if (dp[left][right] != 0) return dp[left][right];
		int sum = 0;
		
		if (left == right) {
			return cards[left];
		} else {
			for (int i = left; i <= right; i++) sum += cards[i];
			int tmpSum = Math.max(sum - BestCard(left + 1, right), sum - BestCard(left, right - 1));
			return dp[left][right] = tmpSum;
		}
	}
}