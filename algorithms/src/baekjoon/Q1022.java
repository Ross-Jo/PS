package baekjoon;

// https://www.acmicpc.net/problem/1022

import java.util.ArrayList;
import java.util.Scanner;

public class Q1022 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		int length = 0;
		
		for (int i=r1; i<=r2; i++) {
			for (int j=c1; j<=c2; j++) {
				
				int k = Math.max(Math.abs(i), Math.abs(j)); // k+1번째 소용돌이 (몇번째 소용돌이인지 알아내기) 
				
				int startNum;
				if (i==0 && j==0) startNum = 1;
				else startNum = (2*k-1) * (2*k-1); // k+1번째 소용돌이 시작을 위한 base번호가 무엇인지 알아내기 
				 
				int number;
				
				// 그래서 해당 좌표의 숫자가 k+1번째 소용돌이에서 몇 번째에 위치하고 있는지 알아내기
				if (j == k && i!=j) {
					number = i*(-1) + j;
				} else if (i == -k || j == -k) {
					number = 2*2*k - (i*(-1) + j);
				} else {
					number = 4*2*k + (i*(-1) + j);
				}
				
				number += startNum;
				length = Math.max(length, (int)(Math.log10(number)+1)); // int의 자릿수 알아내기 
				
				al.add(number);
			}
		}
		
		int m = 0;
		int width = c2-c1+1;
		for (int num: al) {
			if (m>width-1) {
				System.out.println();
				m = 0;
			}
			System.out.format("%" + length + "d ", num); // 특이한 방법의 format 
			m++;
		}
		
		sc.close();
	}
}
