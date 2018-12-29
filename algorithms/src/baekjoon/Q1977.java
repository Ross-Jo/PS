package baekjoon;

// https://www.acmicpc.net/problem/1977

import java.util.Scanner;

public class Q1977 {
	static int M, N;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		int sqrtM = (int) Math.sqrt((double)M);
		int sqrtN = (int) Math.sqrt((double)N);
		
		int min = 0, max = 0;
		if (sqrtM * sqrtM < M) {
			if ((sqrtM+1)*(sqrtM+1) <= N)
				min = sqrtM+1;
			else 
				min = -1;
		} else {
			min = sqrtM;
		}
		
		if (min != -1) {
			max = sqrtN;
			
			int sum = 0;
			for (int i = min; i<=max; i++) sum += i*i;
			System.out.println(sum);
			System.out.println(min*min);
		}
		else {
			System.out.println(-1);
		}
		
		sc.close();
	}
}
