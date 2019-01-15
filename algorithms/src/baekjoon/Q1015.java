package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1015 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n]; int[] b = new int[n]; boolean[] c = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) a[i] = b[i] = Integer.parseInt(st.nextToken()); // Stream을 이용한 입력 + Array.copyOf를 써서 복제하는 것보다 훨씬 빠름 
		Arrays.sort(b);
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<b.length; j++) {
				if(!c[j] && a[i]==b[j]) {
					sb.append(j+" ");
					c[j] = true;
					break;
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
}
