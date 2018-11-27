package baekjoon;

// https://www.acmicpc.net/problem/1024

import java.util.Scanner;

public class Q1024 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		
		while(((2*N - (L-1) * L) % (2*L)) != 0) {
			L++;
			if (L>100) {
				System.out.println(-1);
				sc.close();
				
				return;
			}
		}
		
		int a = (2*N - (L-1) * L) / (2*L);
		
		if (a<0) {
			System.out.println(-1);
			sc.close();
			
			return;
		}
		
		for (int i=0; i<L; i++) {
			System.out.print((a+i)+ " ");
		}
		
		sc.close();
	}
}

// 유의하자 N : 18, L : 2 일때,
// (2*N - (L-1) * L) % 2*L => 결과값 : 0
// (2*N - (L-1) * L) % (2*L) => 결과값 : 2 
// 이유 *, % 는 산술연산자인데 연산자 우선순위가 동일해서 발생함 
// 교훈 : 괄호를 확실히 치자 