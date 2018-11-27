package baekjoon;

// https://www.acmicpc.net/problem/15552

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q15552 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			String[] numbers = br.readLine().split(" ");
			
			bw.write(String.valueOf(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1])));
			bw.newLine();
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}