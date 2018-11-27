package baekjoon;

// https://www.acmicpc.net/problem/2437

import java.util.Arrays;
import java.util.Scanner;

public class Q2437 {
	static int N;
	static int[] w;
	static int ans;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		w = new int[N];
		for (int i=0; i<N; i++) w[i] = sc.nextInt();
		Arrays.sort(w);

		solve();
		
		System.out.println(ans);
		
		sc.close();
	}
	
	static void solve() {
		for (int i=1; i<=1000000000; i++) {
			int target = i;
			for (int j=w.length-1; j>=0; j--) {
				if (w[j] <= target) {
					target -= w[j];
				}
			}
			if (target > 0) {
				ans = i;
				break;
			}
		}
	}
}
// 참고 : http://jaimemin.tistory.com/756
// 5개의 추를 갖고 있는데 무게의 총합이 20이고, 이 추들을 잘 조합해서 1~20의 모든 무게를 나타낼 수 있다고 합시다.
// 1) 6번째 추의 무게가 20일 때 1~40의 모든 무게를 나타낼 수 있을까요?
// 2) 6번째 추의 무게가 21일 때 1~41의 모든 무게를 나타낼 수 있을까요?
// 3) 6번째 추의 무게가 22일 때 1~42의 모든 무게를 나타낼 수 있을까요?

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//	private static final String SPACE = " ";
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
//
//		int[] weight = new int[N];
//		for (int i = 0; i < N; i++) {
//			weight[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(weight);
//
//		if (weight[0] != 1) {
//			System.out.println("1");
//		} else {
//			int total = 1;
//			for (int i = 1; i < N; i++) {
//				if (total + 1 >= weight[i])
//					total += weight[i];
//			}
//			System.out.println(total + 1);
//		}
//	}
//}
