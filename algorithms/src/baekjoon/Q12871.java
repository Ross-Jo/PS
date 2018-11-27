package baekjoon;

//https://www.acmicpc.net/problem/12871

import java.util.Scanner;

public class Q12871 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String f = sc.next();
		String s = sc.next();
		
		char[] s1 = (f+f).toCharArray();
		char[] s2 = (s+s).toCharArray();
		
		boolean flag = true;
		
		if (s1.length <= s2.length) {
			for (int i=0; i<s2.length; i++) {
				if (s1[i%s1.length] != s2[i]) {
					flag = false;
				}
			}
		} else {
			for (int i=0; i<s1.length; i++) {
				if (s2[i%s2.length] != s1[i]) {
					flag = false;
				}
			}
		}
		
		System.out.println(flag ? 1 : 0);
		
		sc.close();
	}
}