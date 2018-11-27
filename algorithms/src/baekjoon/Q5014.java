package baekjoon;

//https://www.acmicpc.net/problem/5014

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5014 {
	static int F, S, G, U, D;
	static boolean fs[];
	static class State {
		int f, u, d;
		State(int f, int u, int d) {
			this.f = f;
			this.u = u;
			this.d = d;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt(); S = sc.nextInt(); G = sc.nextInt(); U = sc.nextInt(); D = sc.nextInt();
		fs = new boolean[F+1];
		
		State st = new State(S, 0, 0);
		Queue<State> q = new LinkedList<>();
		q.add(st);
		fs[S] = true;
		
		int ans = 987654321;
		while(!q.isEmpty()) {
			State here = q.poll();
			if (here.f == G) {
				if (ans > here.u + here.d) ans = here.u + here.d;
				break;
			}
			int nf1 = here.f + U; 
			int nf2 = here.f - D;
			
			if (nf1 <= F && !fs[nf1]) {
				fs[nf1] = true;
				q.add(new State(nf1, here.u + 1, here.d));
			}
			
			if (nf2 > 0 && !fs[nf2]) {
				fs[nf2] = true;
				q.add(new State(nf2, here.u, here.d + 1));
			}
		}
		System.out.println(ans == 987654321? "use the stairs" : ans);
		sc.close();
	}
}

//int l1 = U == 0 ? 0 :(int)((F)/(double)U)*2;
//int l2 = D == 0 ? 0 :(int)((F)/(double)D)*2;
//
//for (int i=0; i<=l1; i++) {
//	for (int j=0; j<=l2; j++) {
//		if (U*i - D*j == G - S) {
//			if (ans > i + j) {
//				ans = i+j;
//			}
//		}
//	}
//}
