package baekjoon;

//https://www.acmicpc.net/problem/6591

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q6591 {
	
	static long calc(int n, int m) {
		long ret = 1;
		if (n==m) return 1;
		if (m > n-m) m = n-m;
		for (int i=1; i<=m; i++) ret = ret * (n-m+i) / i;
		return ret;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			if (n==0 && m==0) break;
			
			bw.write(Long.toString(calc(n, m)));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
