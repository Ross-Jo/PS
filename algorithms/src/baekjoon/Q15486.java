package baekjoon;

// https://www.acmicpc.net/problem/15486

import java.util.Scanner;

public class Q15486 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); // 거꾸로 생각하기 
		
		int N = sc.nextInt();
		int[] T = new int[N+2];
		int[] P = new int[N+2];
		int[] dp = new int[N+2];
		
		for (int i=1; i<=N; i++) {
			T[i] = sc.nextInt();
			int p = sc.nextInt();
			if((i + T[i] - 1) <= N) P[i] = p;
			dp[i] = P[i];
		}
		
		int max = -1;
		for (int i=N; i>=1; i--) {
			if(i+T[i]-1<=N) {
				dp[i] = Math.max(dp[i+T[i]]+P[i], dp[i+1]);
			} else {
				dp[i] = dp[i+1];
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		
		sc.close();
	}
}
// 아래는 '오늘' 상담을 했을 때와, 하지 않았을 때의 미래 수익을 갱신하는 방법으로 진행 

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//        int[] dp = new int[N + 1];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            int T = Integer.parseInt(st.nextToken());
//            int P = Integer.parseInt(st.nextToken());
//
//            dp[i + 1] = Math.max(dp[i], dp[i + 1]); // 오늘 상담을 하지 않는다 치면, 내일은 최소 오늘 번 만큼은 먹고 들어간다는 보장이 있음 
//            if (i + T <= N) dp[i + T] = Math.max(dp[i + T], dp[i] + P); // 만약 오늘 상담을 한다고 치면, 상담이 끝나는 날짜에 들어오는 돈이 있을테고 그 돈 만큼을 적립해줌. 그런데 적립금 합친게 오늘 상담 안하고 버는 돈보다 못할 것 같으면, 오늘 상담 안함. 
//        }
//        System.out.println(dp[N]);
//    }
//}
