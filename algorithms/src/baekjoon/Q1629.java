package baekjoon;

//https://www.acmicpc.net/problem/1629

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;

//public class Q1629 {
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt();
//		
//		long ans = 1;
//		
//		ArrayList<Long> al = new ArrayList<>();
//		Map<Integer, Integer> m = new HashMap<>();
//		
//		for (int i=0; i<b; i++) {
//			ans = (ans*a)%c;
//			if (!al.contains(ans)) {
//				al.add(ans);
//				m.put((int)ans, 1);
//			} else {
//				if (m.get((int)ans) == 2) break;
//				m.put((int)ans, m.get((int)ans)+1);
//			}
//		}
//		
//		ArrayList<Integer> loop = new ArrayList<>();
//		
//		for (long e: al) {
//			if(m.get((int)e) == 2) {
//				loop.add((int)e);
//			}
//		}
//		
//		if (b <= al.size()) {
//			System.out.println(al.get(b-1));
//		} else {
//			System.out.println(loop.get((b-(al.size()-loop.size())-1)%loop.size()));
//		}
//	
//		sc.close();
//	}
//}

//import java.util.*;
//
//public class question_111 {
//	static long go(long a, long b, long c) {
//		if (b == 0) {
//			return 1;
//		} else if (b == 1) {
//			return a % c;
//		} else if (b % 2 == 0) {
//			long temp = go(a, b / 2, c);
//			return (temp * temp) % c;
//		} else {
//			return (a * go(a, b - 1, c)) % c;
//		}
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		long a = sc.nextLong();
//		long b = sc.nextLong();
//		long c = sc.nextLong();
//		System.out.println(go(a, b, c));
//		sc.close();
//	}
//}


