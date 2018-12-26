package baekjoon;

// https://www.acmicpc.net/problem/1920

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Q1920 {
	static int N, M;
	static int[] A, T;
	
	static int bs1(int t, int s, int e) {
		if (s > e) return 0;
		int mid = (s+e) / 2;
		if (A[mid] == t) return 1;
		if (A[mid] > t) return bs1(t, s, mid-1);
		else if(A[mid] < t) return bs1(t, mid+1, e);
		return 0;
	}
	
	static int bs2(int x) {
		int low = 0;
		int high = A.length - 1;
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			if (A[mid] < x) {
				low = mid + 1;
			} else if (A[mid] > x) {
				high = mid - 1;
			} else {
				return 1;
			}
		}
		return 0;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(A);
		
		M = Integer.parseInt(br.readLine());
		T = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		StringBuilder sb = new StringBuilder();
		
		for (int e: T) sb.append(bs2(e) + "\n");
		
		System.out.println(sb);
		br.close();
	}
}
