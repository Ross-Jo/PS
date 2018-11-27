package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12907

public class Q12907_2 {
	public static void main(String args[]) {
		Q12907_2 q = new Q12907_2();
		System.out.println(q.solution(6, new int[]{1,2,5}));
	}
	// 참고 : http://gurumee92.tistory.com/64?category=739599
	public int solution(int n, int[] money) {
		int answer = 0;

		long[] dp = new long[n + 1];

		for (int i = 0; i <= n; i++) {
			dp[i] = (i % money[0] == 0) ? 1 : 0;
		}

		for (int i = 1; i < money.length; i++) {
			for (int j = money[i]; j <= n; j++) {
				dp[j] += dp[j - money[i]];
			}
		}
		answer = (int) (dp[n] % 1000000007);
		return answer;
	}
}

//public int solution(int n, int[] money) {
//	int[] dp = new int[n + 1];
//	dp[0] = 1;
//
//	for (int i = 0; i < money.length; i++) {
//		for (int j = money[i]; j <= n; j++) {
//			dp[j] = dp[j] + dp[j - money[i]];
//			dp[j] = dp[j] % 1000000007;
//		}
//	}
//	return dp[n];
//}

//public int solution(int n, int[] money) {
//	int[] arr = new int[n];
//	for (int i : money) {
//		arr[i - 1] += 1;
//		for (int j = 0; j < n; j++) {
//			if (j >= i) {
//				arr[j] += arr[j - i];
//			}
//		}
//	}
//	return arr[n - 1];
//}