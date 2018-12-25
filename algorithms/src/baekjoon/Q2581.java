package baekjoon;

// https://www.acmicpc.net/problem/2581

import java.util.ArrayList;
import java.util.Scanner;

public class Q2581 {
	static int N, M; // 1 <= M <= N <= 10000
	static boolean[] c;
	static ArrayList<Integer> p = new ArrayList<>();
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		c = new boolean[10001]; // 소수가 아닌 숫자를 true표시함
		
		for (int i=2; i*i<=N; i++) {
			if (i > 2 && i % 2 == 0) continue;
			for (int j=M; j<=N; j++) {
				if (c[j]) continue;
				if (j / i == 1 && j % i == 0) continue;
				else if (j % i == 0) c[j] = true;
			}
		}
		
		for (int i=M; i<=N; i++) if(!c[i]) {
			if (i==1) continue;
			p.add(i);
		}
		
		if (p.size() > 0) {
			System.out.println(p.stream().mapToInt(i->i).sum());
			System.out.println(p.get(0));
		} else {
			System.out.println(-1);
		}

		
		sc.close();
	}
}
