package baekjoon;

// https://www.acmicpc.net/problem/1654

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고 : http://jason9319.tistory.com/35

public class Q1654 {
	static long K, N, lo, hi;
	static long[] l;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp[] = br.readLine().split(" ");
		
		K = Integer.parseInt(tmp[0]);
		N = Integer.parseInt(tmp[1]);
		l = new long[10001];
		
		for (int i=0; i<K; i++) l[i] = Integer.parseInt(br.readLine());
		
		lo = 0;
		hi = Integer.MAX_VALUE;
		
		while (lo <= hi) {
			long mid = (lo + hi) >> 1;
			long t = 0;
			for (int i=0; i<K; i++) t += l[i]/mid;
			if (t >= N) lo = mid + 1;
			else hi = mid - 1;
		}
		System.out.println(lo - 1);
		
		br.close();
	}
}
