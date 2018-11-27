package baekjoon;

// https://www.acmicpc.net/problem/1912

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1912 {

// 무식하게 푼 방법
//	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int n = Integer.parseInt(br.readLine());
//		int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
//		
//		int max = Integer.MIN_VALUE;
//		int[] p;
//		
//		for(int i=0; i<n; i++) {
//			p = new int[n];
//			for (int j=i; j<n; j++) {
//				if(j==i) p[j] = numbers[j];
//				else p[j] = p[j-1] + numbers[j];
//				
//				max = Math.max(max, p[j]);
//			}
//		}
//		
//		System.out.println(max);
//		
//		br.close();
//	}

// 무식하게 풀되 최적화를 적용한 방법 
//	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int n = Integer.parseInt(br.readLine());
//		int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
//		
//		int max = Integer.MIN_VALUE;
//		int[] p = new int[n];
//		
//		for(int i=0; i<n; i++) {
//			if(i==0) p[i] = numbers[i];
//			else p[i] = p[i-1] + numbers[i];
//		}
//		
//		for (int i=0; i<n; i++) {
//			for (int j=i; j<n; j++) {
//				try {
//					max = Math.max(max, p[j]-p[i-1]);
//				} catch(IndexOutOfBoundsException e) {
//					max = Math.max(max, p[j]);
//				}
//			}
//		}
//		
//		System.out.println(max);
//		
//		br.close();
//	}

// 동적프로그래밍 방법 
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
		
		
		int[] dp = new int[n];
		int max = dp[0] = numbers[0];
		
		for (int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1] + numbers[i], numbers[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
		br.close();
	}
}
