package baekjoon;

// https://www.acmicpc.net/problem/10815

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Q10815 {
	static int N, M;
	static int[] ns, ms;
	
	static int bs (int t) {
		int l = 0;
		int u = ns.length-1;
		int m;
		
		while(l<=u) {
			m = (l+u) / 2;
			if (t < ns[m]) u = m-1;
			else if (t > ns[m]) l = m+1;
			else return 1;
		}
		return 0;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ns = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		M = Integer.parseInt(br.readLine());
		ms = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(ns);
		
		StringBuilder sb = new StringBuilder();
		for (int e: ms) sb.append(bs(e) + " ");
		
		System.out.println(sb);
		br.close();
	}
}
