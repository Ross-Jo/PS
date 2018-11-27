package baekjoon;

// https://www.acmicpc.net/problem/2629

import java.util.Scanner;

//참고(양팔저울) : http://joonas-yoon.blogspot.com/2016/02/2718.html

public class Q2629 {
	static int N;
	static int[] weights = new int[30];
	static boolean[] can = new boolean[15001]; // 잴 수 있는 무게 목록 
	static boolean[] tmp = new boolean[15001];
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for (int i=0; i<N; i++) weights[i] = sc.nextInt();
		
		tmp[0] = can[0] = true;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<=15000; j++) {
				if(can[j] == true) { // 만약 j라는 무게를 잴 수 있다면 
					int left=Math.abs(j-weights[i]); // |j-현재 타깃 무게추| 혹은 |j+현재 타깃 무게추| 만큼의 무게를 또 잴 수 있음 
					int right=Math.abs(j+weights[i]);
					if(left >= 0 && left < 15000) tmp[left] = true;
					if(right >= 0 && right < 15000) tmp[right] = true;
					tmp[weights[i]] = true; // 무게 추 자체로 잴 수 있는 것 
				}
			}
			for(int j=0; j<=15000; j++) can[j] = tmp[j]; // 일단 사이클이 끝나고 옮겨담는식으로 진행 
		}
		
		int M = sc.nextInt();
		for (int i=0; i<M; i++) {
			int target = sc.nextInt();
			System.out.print(target <= 15000 && can[target] ? "Y " : "N ");
		}
		sc.close();
	}
}