package baekjoon;

// https://www.acmicpc.net/problem/2661
// 참고 : https://mygumi.tistory.com/213

import java.util.Scanner;

public class Q2661_2 {
	static int n;
	static boolean stop = false; // 첫번째 정답만 출력하기 위함 
	
	public static void dfs(int len, String s) {
		if (stop) return;
		
		if (n==len) {
			stop = true;
			System.out.println(s);
		} else {
			for (int i=1; i<=3; i++) {
				if (isSatisfy(s+i)) dfs(len+1, s+i);
			}
		}
	}
	
	public static boolean isSatisfy(String s) {
		int len = s.length();
		int loop = len/2;
		int start = len - 1;
		int end = len;
		
		for (int i=1; i<=loop; i++) {
			if (s.substring(start-i, end-i).equals(s.substring(start, end))) return false;
			start -= 1;
		}
		return true;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dfs(1, "1");
		
		sc.close();
	}
}
