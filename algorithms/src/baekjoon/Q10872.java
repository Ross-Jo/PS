package baekjoon;

import java.util.Scanner;

public class Q10872 {
	static int[] c = new int[12+1];
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		c[0] = 1;
		for (int i=1; i<=n; i++) c[i] = i * c[i-1];
		
		System.out.println(c[n]);
		
		sc.close();
	}
}	
