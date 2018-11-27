package baekjoon;

// https://www.acmicpc.net/problem/14225

import java.util.Arrays;
import java.util.Scanner;

public class Q14225 {
	static int N;
	static int max = 100000;
	static int ans;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		for (int i=0; i<N; i++) nums[i] = sc.nextInt();
		
		Arrays.sort(nums);
		
		for (int i=1; i<=max * N; i++) {
			int tmp = i;
			for (int j=nums.length-1; j>=0; j--) {
				if (nums[j] <= tmp) {
					tmp -= nums[j];
				}
			}
			if (tmp != 0) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}