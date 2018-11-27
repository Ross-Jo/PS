package baekjoon;

// https://www.acmicpc.net/problem/1107

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1107 {
	static int N;
	static int M;
	static int[] buttons;
	static boolean[] t;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); M = Integer.parseInt(br.readLine());
		
		if (M == 0) {
			System.out.println(Math.min(Integer.toString(N).length(), Math.abs(100-N)));
			return;
		} 
		
		buttons = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		if(M == 10) {
			System.out.println(Math.abs(100-N));
			return;
		}
		
		t = new boolean[10];
		for (int el: buttons) t[el] = true;
		
		if (isOk(N)) {
			System.out.println(Math.min(Integer.toString(N).length(), Math.abs(100-N)));
			return;
		}
		
		int target_u = N + 1;
		int target_d = N - 1;
		if(target_d < 0) target_d = 0;
		
		while(!isOk(target_u) && target_u <= 500000 + 500000) target_u += 1;
		while(!isOk(target_d) && target_d > 0) target_d -= 1;
		
		if(isOk(target_u) && isOk(target_d)) {
			System.out.println(Math.min(
							   Math.min(Math.abs(N - target_u) + Integer.toString(target_u).length(), 
									    Math.abs(N - target_d) + Integer.toString(target_d).length()), 
							   Math.abs(100-N)));
		} else if(isOk(target_u) && !isOk(target_d)) {
			System.out.println(Math.min(
					   Math.abs(N - target_u) + Integer.toString(target_u).length(), 
					   Math.abs(100-N)));
		} else {
			System.out.println(Math.min(
					   Math.abs(N - target_d) + Integer.toString(target_d).length(), 
					   Math.abs(100-N)));
		}
		
		br.close();
	}
	
	static boolean isOk(int target) {
		if(target == 0) return !t[target];
		while(target > 0) {
			int number = target % 10;
			if(t[number]) return false;
			target = target / 10;
		}
		return true;
	}
}

//import java.util.Scanner;
//
//public class Main {
//	static int n, m;
//	static int result;
//	static boolean[] broken = new boolean[10];
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		m = sc.nextInt();
//		for (int i = 0; i < m; i++) {
//			int k = sc.nextInt();
//			broken[k] = true;
//		}
//		result = Math.abs(n - 100); // + or - 버튼만으로 이동하는 수
//
//		// 숫자버튼으로 이동
//		for (int i = 0; i <= 1000000; i++) {
//			int x = i;
//			int len = possible(x); // 숫자버튼 사용가능하다면 몇번 눌렸는지
//			if (len > 0) {
//				int press = Math.abs(x - n); // 누른 숫자에서 목표숫자까지 눌러야하는 횟수
//				result = Math.min(result, press + len);
//			}
//		}
//
//		System.out.println(result);
//	} // end main()
//
//	public static int possible(int x) {
//		if (x == 0) {
//			if (broken[0]) {
//				return 0;
//			} else {
//				return 1;
//			}
//		}
//		int len = 0;
//		while (x > 0) {
//			if (broken[x % 10])
//				return 0;
//			x /= 10;
//			len += 1;
//		}
//		return len;
//	} // end possible()
//}
