package baekjoon;

//https://www.acmicpc.net/problem/3019

import java.util.Scanner;

public class Q3019_3 {
	public static int[][][] block = { 
			{ { 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0 } },
			{ { 0, 0, 1 }, { 1, 0 } },
			{ { 1, 0, 0 }, { 0, 1 } },
			{ { 0, 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 0, 1 } },
			{ { 0, 0, 0 }, { 0, 0 }, { 0, 1, 1 }, { 2, 0 } },
			{ { 0, 0, 0 }, { 0, 0 }, { 1, 1, 0 }, { 0, 2 } } };
	public static int C, P;
	public static Scanner sc = new Scanner(System.in);
	public static int[] board;

	public static void main(String[] args) {
		int res = 0;
		C = sc.nextInt();
		P = sc.nextInt() - 1; // 주목 
		board = new int[C];
		
		for (int i = 0; i < board.length; i++) board[i] = sc.nextInt();
		
		for (int i = 0; i < C; i++) {
			for (int dir = 0; dir < block[P].length; dir++) {
				boolean flag = true;
				
//				if (block[P][dir].length > 0) {
					int prev = board[i] - block[P][dir][0]; // 역시 base가 되는 차이를 구하고 
					for (int check = 1; check < block[P][dir].length; check++) { // 역시 블록의 길이만큼 따짐 
						if (i + check >= C) { // 주어진 영역 벗어나는 순간 실패 
							flag = false;
							break;
						}
						int now = board[i + check] - block[P][dir][check];
						if (now != prev) {
							flag = false; // 균일 높이차가 깨지는 지점이 발생하면 실패 
							break;
						}
//						prev = now;
					}
//				}

				if (flag) {
					res++;
				}
			}
		}
		
		System.out.println(res);
		if(sc != null) sc.close();
	}
}