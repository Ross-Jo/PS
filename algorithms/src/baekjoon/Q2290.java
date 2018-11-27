package baekjoon;

// https://www.acmicpc.net/problem/2290

import java.util.Scanner;

public class Q2290 {
	static int s;
	static String number;
	static int[][] data = {
			{1,1,1,0,1,1,1},
			{0,0,1,0,0,1,0},
			{1,0,1,1,1,0,1},
			{1,0,1,1,0,1,1},
			{0,1,1,1,0,1,0},
			{1,1,0,1,0,1,1},
			{1,1,0,1,1,1,1},
			{1,0,1,0,0,1,0},
			{1,1,1,1,1,1,1},
			{1,1,1,1,0,1,1}
	};
	
	static void garo(StringBuilder sb, int index, int ...target) {
		sb.append(" ");
		if (data[index][target[0]] == 1) for (int j=0; j<s; j++) sb.append("-");
		else for (int j=0; j<s; j++) sb.append(" ");
		sb.append(" ");
		sb.append(" ");
	}
	
	static void sero(StringBuilder sb, int index, int ...target) {
		if (data[index][target[0]] == 1) sb.append("|");
		else sb.append(" ");
		for (int j=0; j<s; j++) sb.append(" ");
		if (data[index][target[1]] == 1) sb.append("|");
		else sb.append(" ");
		sb.append(" ");
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		number = sc.next();
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<2*s+3; i++) {
			for (int k=0; k<number.length(); k++) {
				int index = number.charAt(k) - '0';
				if (i==0) garo(sb, index, 0);
				else if (i>0 && i<=s) sero(sb, index, 1, 2);
				else if (i==s+1) garo(sb, index, 3);
				else if (i>s+1 && i<=2*s+1) sero(sb, index, 4, 5);
				else garo(sb, index, 6);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		
		sc.close();
	}
}