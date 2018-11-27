package baekjoon;

// https://www.acmicpc.net/problem/9251

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9251 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine(); String str2 = br.readLine();
		int str1_l = str1.length(); int str2_l = str2.length();
		int[][] result = new int[str1_l+1][str2_l+1];
		
		for (int i=0; i<=str1_l; i++) {
			for (int j=0; j<=str2_l; j++) {
				if (i == 0 || j == 0) result[i][j] = 0;
				else if (str1.charAt(i-1) == str2.charAt(j-1)) result[i][j] = result[i-1][j-1] + 1;
				else result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
			}
		}
		System.out.println(result[str1_l][str2_l]);
		
		br.close();
	}
}