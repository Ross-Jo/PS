package baekjoon;

// https://www.acmicpc.net/problem/1934

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소 공배수를 구하는 프로그램
public class Q1934 {

	// A와 B를 swap
	public static void swap(int A, int B) {
		int tmp = 0;
		tmp = A;
		A = B;
		B = tmp;
	}

	public static int euclid(int A, int B) {
		if (A < B)
			swap(A, B);
		while (A % B != 0) {
			int tmp_A = A;
			A = B;
			B = tmp_A % B;
		}
		return B;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			
			int T = Integer.parseInt(br.readLine()); // 1<=T<=1000
			for(int i=0; i<T; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()); // 1<=A, B<=45000
				int B = Integer.parseInt(st.nextToken());
				
				int G = euclid(A, B);
				
				System.out.println((A*B)/G);
			}
		} catch(IOException e){
			System.out.println("입력오류");
		}
	}
}