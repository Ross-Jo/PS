package baekjoon;

// https://www.acmicpc.net/problem/14888

import java.util.Scanner;

public class Q14888 {
	static int N;
	static int[] nums;
	static int[] ops = new int[4]; // +, -, *, /
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static void rec(String s, int p, int m, int t, int d) {
		if (s.length() == N-1) {
			int res = nums[0];
			for (int i=1; i<nums.length; i++) {
				switch(s.charAt(i-1)) {
					case '+':
						res = res + nums[i];
						break;
					case '-':
						res = res - nums[i];
						break;
					case '*':
						res = res * nums[i];
						break;
					case '/':
						if (res < 0) {
							res = -(-res / nums[i]);
						} else {
							res = res / nums[i];
						}
						break;
				}
			}
			
			if (max < res) max = res;
			if (min > res) min = res;
		}
		
		if (p > 0) rec(s+"+", p-1, m, t, d);
		if (m > 0) rec(s+"-", p, m-1, t, d);
		if (t > 0) rec(s+"*", p, m, t-1, d);
		if (d > 0) rec(s+"/", p, m, t, d-1);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		nums = new int[N];
		for (int i=0; i<N; i++) nums[i] = sc.nextInt();
		for (int i=0; i<4; i++) ops[i] = sc.nextInt();
		rec("", ops[0], ops[1], ops[2], ops[3]);
		
		System.out.println(max);
		System.out.println(min);
		
		sc.close();
	}
}
