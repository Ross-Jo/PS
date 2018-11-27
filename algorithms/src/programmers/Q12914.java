package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12914

public class Q12914 {
	public static void main(String args[]) {
		Q12914 q = new Q12914();
		System.out.println(q.solution(2000));
	}
	public long solution(int n) {
		if (n<=2) return n;
		
		long[] dp = new long[n+1]; dp[1] = 1; dp[2] = 2;
		
		for (int i=3; i<n+1; i++) {
			dp[i] = dp[i-1] % 1234567 + dp[i-2] % 1234567;
		}
		
		return dp[n] % 1234567;
	}
}

//public int jumpCase(int num) {
//	int answer = 0;
//	if (num <= 2) return num;
//	answer = jumpCase(num - 1) + jumpCase(num - 2);
//	return answer;
//}