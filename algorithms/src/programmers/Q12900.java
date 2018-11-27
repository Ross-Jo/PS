package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12900

public class Q12900 {
	public static void main(String args[]) {
		Q12900 q = new Q12900();
		int n = 10000; // n <= 60000
		System.out.println(q.solution(n));
	}

	public int solution(int n) {
		long[] dp = new long[n+1];
		
		dp[0] = 0; dp[1] = 1; dp[2] = 2;
		
		for (int i=3; i<n+1; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
		}
		
		return (int) dp[n];
	}
}