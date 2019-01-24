package baekjoon;

// https://www.acmicpc.net/problem/9375

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Q9375 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int w = sc.nextInt();
			Map<String, Integer> map = new HashMap<>();
			
			for(int i=0; i<w; i++) {
				String c = sc.next();
				String g = sc.next();
				map.put(g, map.getOrDefault(g, 0) + 1);
			}
			
			int ret = 1;
			for (Map.Entry<String, Integer> entry: map.entrySet()) {
				ret *= (1+entry.getValue());
			}
			
			System.out.println(ret-1);
		}
		
		sc.close();
	}
}
