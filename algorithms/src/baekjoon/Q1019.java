package baekjoon;

//https://www.acmicpc.net/problem/1019

import java.util.*;

public class Q1019 {
	static long[] ans = new long[10];
	static void calc(long n, long ten) {
		while (n > 0) {
			ans[(int)(n%10)] += ten;
			n = n/10;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long start = 1;
		long end = sc.nextLong();
		long ten = 1;
		
		while(start <= end) {
			while(start%10!=0 && start<=end) {
				calc(start,ten);
				start += 1;
			}
			
			if (start > end) break;
			
			while(end%10!=9 && start<=end) {
				calc(end, ten);
				end -= 1;
			}
			
			long cnt = (end/10 - start/10 + 1);
			for (int i=0; i<=9; i++) {
				ans[i] += cnt*ten;
			}
			start = start/10;
			end = end/10;
			ten = ten*10L;
		}
		
		for (int i=0; i<=9; i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
		sc.close();
	}
}
