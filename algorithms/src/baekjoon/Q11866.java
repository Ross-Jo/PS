package baekjoon;

// https://www.acmicpc.net/problem/11866

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Q11866 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] ans = new int[N];
		int index = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i=0; i<N; i++) q.add(i+1);
		
		while(!q.isEmpty()) {
			int counter = 0;
			while(++counter <= M) {
				if (counter == M) {
					ans[index++] = q.poll();
				} else {
					int element = q.poll();
					q.add(element);
				}
			}
		}
		
		sb.append("<");
		for (int i=0; i<N; i++) {
			sb.append(ans[i]);
			if(i<N-1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb.toString());
		
		sc.close();
	}
}