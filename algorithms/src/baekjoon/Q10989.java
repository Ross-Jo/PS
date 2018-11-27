package baekjoon;

//https://www.acmicpc.net/problem/10989

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10989 {
	private static final int BITS_PER_BYTE = 8;
	
	static void sort(int[] arr) {
		final int BITS = 32;
		final int R = 1 << BITS_PER_BYTE;
		final int MASK = R-1;
		final int w = BITS / BITS_PER_BYTE;
		
		int n = arr.length;
		int[] aux = new int[n];
		
		for (int d = 0; d<w; d++) {
			
			int[] count = new int[R+1];
			
			for (int i=0; i<n; i++) {
				int c = (arr[i] >> BITS_PER_BYTE*d) & MASK;
				count[c+1]++;
			}
			
			for (int r=0; r<R; r++) count[r+1] += count[r];
			
			if (d == w-1) {
				int shift1 = count[R] - count[R/2];
				int shift2 = count[R/2];
				for (int r=0; r<R/2; r++) count[r] += shift1;
				for (int r=R/2; r<R; r++) count[r] -= shift2;
			}
			
			for (int i=0; i<n; i++) {
				int c = (arr[i] >> BITS_PER_BYTE*d) & MASK;
				aux[count[c]++] = arr[i];
			}
			
			for (int i=0; i<n; i++) arr[i] = aux[i];
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sort(arr);
		
		for (int e: arr) {
			bw.write(Integer.toString(e));
			bw.newLine();
		}
		bw.flush();
		
		bw.close();
		br.close();
	}
}