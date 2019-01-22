package baekjoon;

//https://www.acmicpc.net/problem/1676

import java.util.Scanner;

public class Q1676 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int tc = 0; 
		int fc = 0;
		
		if (n==0) {
			System.out.println(0);
			return;
		}
		
		for (int i=1; i<=n; i++) {
			int target = i;
			boolean flag = true;
			while(flag) {
				flag = false;
//				if (target % 2 == 0) {
//					target /= 2;
//					tc++;
//					flag = true;
//				}
				if (target % 5 == 0) {
					target /= 5;
					fc++;
					flag = true;
				}
			}
		}
		
//		System.out.println(tc > fc ? fc : tc);
		System.out.println(fc);
		
		sc.close();
	}
}

// 다른 사람들 풀이 참고
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// 
// public class Main {
// 	 public static void main(String[] args) throws IOException {
// 	 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 	 	int T = Integer.parseInt(br.readLine());
// 	 	int count = 0;
// 	 	count += T / 5;
// 	 	count += T / 25;
// 	 	count += T / 125;
// 	 	System.out.println(count);
// 	 }
// }