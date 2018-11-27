package baekjoon;

// https://www.acmicpc.net/problem/2558

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q2558 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		System.out.println(Integer.parseInt(br.readLine()) + Integer.parseInt(br.readLine()));
		br.close();
	}
}
