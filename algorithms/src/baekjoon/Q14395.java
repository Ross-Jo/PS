package baekjoon;

//https://www.acmicpc.net/problem/14395

import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

//메모리 초과 boolean[1000000000 + 1] => 거의 1기가 
//자료형에 유의하자 int시 오버플로우 -> long으로 변환 
public class Q14395 {
	static long S, T;
	static Set<Long> s = new HashSet<Long>();
	static String res;
	static final int MAX = 1000000000;
	
	static class El {
		long num;
		String oper;
		El (long num, String oper) {
			this.num = num; this.oper = oper;
		}
	}
	
	static void bfs() {
		Queue<El> q = new LinkedList<>();
		s.add(S);
		q.add(new El(S, ""));
		
		while(!q.isEmpty()) {
			El h = q.poll();
			long num = h.num;
			String oper = h.oper;
			
			if (num == T) {
				res = oper;
			}
			
			long r = num*num;
			if (r <= MAX && r>=1 && !s.contains(r)) {
				s.add(r);
				q.add(new El(r, oper+"*"));
			}
			
			r = num+num;
			if (r <= MAX && r>=1 && !s.contains(r)) {
				s.add(r);
				q.add(new El(r, oper + "+"));
			}
			
			r = 0;
			if (!s.contains(r)) {
				s.add(r);
				q.add(new El(r, oper + "-"));
			}
			
			if (num != 0) {
				r = 1;
				if (!s.contains(r)) {
					s.add(r);
					q.add(new El(r, oper + "/"));
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextLong();
		T = sc.nextLong();
		
		if (S == T) {
			System.out.println(0);
			
			sc.close();
			return;
		}
		bfs();
		System.out.println(res==null?-1:res);
		
		
		sc.close();
	}
}