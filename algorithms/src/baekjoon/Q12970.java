package baekjoon;

// https://www.acmicpc.net/problem/12970

import java.util.*;

public class Q12970 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		for (int a = 0; a <= n; a++) {
			int b = n - a;
			if (a * b < k) continue;
			
			int[] cnt = new int[b + 1];
			
			for (int i = 0; i < a; i++) {
				int x = Math.min(b, k);
				cnt[x] += 1;
				k -= x;
			}
			
			for (int i = b; i >= 0; i--) {
				for (int j = 0; j < cnt[i]; j++) System.out.print("A");
				if (i > 0) System.out.print("B");
			}
			
			System.out.println();
			System.exit(0);
		}
		
		System.out.println(-1);
		sc.close();
	}
}