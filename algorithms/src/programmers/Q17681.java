package programmers;

//https://programmers.co.kr/learn/courses/30/lessons/17681

import java.util.Arrays;
import java.util.Scanner;

public class Q17681 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		int[] arr1 = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		int[] arr2 = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		
		for (int i=0; i<n; i++) {
			String line = Integer.toBinaryString(arr1[i] | arr2[i]);
			
			if (line.length() < n) {
				line = new String(new char[n-line.length()]).replace("\0", "0") + line; // dummy 0s 의 삽입, \0는 NUL을 의미함
			}
			
			for (int j=0; j<line.length(); j++) {
				if (line.charAt(j) == '0') {
					System.out.print(" ");
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
		
		sc.close();
	}
}
