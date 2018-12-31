package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// https://www.acmicpc.net/problem/1977

import java.util.Scanner;

public class Q1977 {
	static int M, N;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		
		int sqrtM = (int) Math.sqrt((double)M);
		int sqrtN = (int) Math.sqrt((double)N);
		
		int min = 0, max = 0;
		if (sqrtM * sqrtM < M) {
			if ((sqrtM+1)*(sqrtM+1) <= N)
				min = sqrtM+1;
			else 
				min = -1;
		} else {
			min = sqrtM;
		}
		
		if (min != -1) {
			max = sqrtN;
			
			int sum = 0;
			for (int i = min; i<=max; i++) sum += i*i;
			System.out.println(sum);
			System.out.println(min*min);
		}
		else {
			System.out.println(-1);
		}
		
		sc.close();
	}

	// 다른 사람의 풀이 - 참고 및 비교해 볼 것 
	//	public static void main(String args[]) throws IOException {
	//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	//		int M = Integer.parseInt(br.readLine());
	//		int N = Integer.parseInt(br.readLine());
	//
	//		int x = 25;
	//		int y = 25;
	//		for (int i = 0; i < 5; i++) {
	//			x = (x * x + M) / (2 * x);
	//			y = (y * y + N) / (2 * y);
	//		}
	//		if (x * x < M) {
	//			x++;
	//		}
	//
	//		int sum = 0;
	//		for (int i = x; i <= y; i++) {
	//			sum += i * i;
	//		}
	//		if (sum == 0)
	//			bw.write("-1\n");
	//		else {
	//			bw.write(sum + "\n");
	//			bw.write(x * x + "\n");
	//		}
	//		bw.flush();
	//	}
}
