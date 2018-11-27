package baekjoon;

// https://www.acmicpc.net/problem/1966

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Docs {
	int w;
	boolean t;
	Docs(int w, boolean t) {
		this.w = w; this.t= t;
	}
}

public class Q1966 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<Docs> q = new LinkedList<Docs>();
			Docs target;
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				if (i!=M) {
					q.add(new Docs(Integer.parseInt(st.nextToken()), false));
				} else {
					target = new Docs(Integer.parseInt(st.nextToken()), true);
					q.add(target);
				}
			}
			
			boolean isTargetPrinted = false;
			int ans = 0;
			do {
				Docs head = q.poll();
				boolean printed = true;
				for (Docs el: q) {
					if(el.w > head.w) {
						q.add(head);
						printed = false;
						break;
					}
				}
				if (printed) {
					ans++;
					if(head.t) isTargetPrinted = true;
				}
			} while(!isTargetPrinted);
			
			System.out.println(ans);
		}
		
		br.close();
	}
}
