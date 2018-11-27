package baekjoon;

//https://www.acmicpc.net/problem/12904

import java.util.Scanner;

public class Q12904 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		String T = sc.nextLine();
		
		while(T.length() > S.length()) {
			if (T.charAt(T.length()-1)=='A') {
				T = T.substring(0, T.length()-1);
			} else {
				T = T.substring(0, T.length()-1);
				T = new StringBuilder(T).reverse().toString(); // 참고(문자열 뒤집기): https://stackoverflow.com/questions/7569335/reverse-a-string-in-java
			}
			if (T.equals(S)) {
				System.out.println(1);
				
				sc.close();
				return;
			}
		}
		System.out.println(0);
		sc.close();
	}
}