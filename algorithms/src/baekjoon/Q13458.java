package baekjoon;

// https://www.acmicpc.net/problem/13458

import java.util.Scanner;

public class Q13458 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] p = new int[N];
		for(int i=0; i<N; i++) p[i] = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		long sum = 0;
		for (int i=0; i<N; i++) {
			if ((p[i]-B) > 0) {
				sum += (1 + Math.ceil((p[i]-B)/(double)C));
			} else {
				sum += 1;
			}
		}
		System.out.println(sum);
		
		sc.close();
	}
}