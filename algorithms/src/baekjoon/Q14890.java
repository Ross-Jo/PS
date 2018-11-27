package baekjoon;

// https://www.acmicpc.net/problem/14890

import java.util.Scanner;

public class Q14890 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[][] map = new int[N][N];
		int ans = 0;
		
		Q14890 q = new Q14890();
		
		for (int i=0; i<N; i++) for (int j=0; j<N; j++) map[i][j] = sc.nextInt();
			
		for (int i=0; i<N; i++) {
			int[] row = new int[N];
			for (int j=0; j<N; j++) row[j] = map[i][j];
			if(q.isRoad(row, L, N, map)) ans++;
		}
		
		for (int j=0; j<N; j++) {
			int[] col = new int[N];
			for (int i=0; i<N; i++) col[i] = map[i][j];
			if(q.isRoad(col, L, N, map)) ans++;
		}
		System.out.println(ans);
		
		sc.close();
	}
	
	boolean isRoad(int[] line, int L, int N, int[][] map) {
		int[] count = new int[N+1];
		
		int ch = line[0]; // 현재 높이 
		int lh = line[0]; // 직전 높이
		boolean[] isSlope = new boolean[line.length]; 
		int meml = 0; // L 메모라이즈
		int k = 0;
		
		for(int h: line) {
			ch = h;
			if (ch != lh) {
				if(Math.abs(ch - lh) >= 2) return false;
				if(meml != 0) return false;
				else if(ch - lh == 1) {
					if (count[lh]>=L) {
						for(int i=1; i<=L; i++) {
							if (isSlope[k-i]) return false;
							isSlope[k-i] = true;
						}
					} else {
						return false;
					}
				}
				else if(ch - lh == -1) {
					meml = L-1;
					if (meml == 0) {
						if (isSlope[k]) return false;
						isSlope[k] = true;
					}
				}
				count[lh] = 0;
				count[ch]++;
			} else {
				count[ch]++;
				if (meml > 0) {
					meml--;
					if (meml == 0) {
						for (int i=0; i<L; i++) {
							if (isSlope[k-i]) return false;
							isSlope[k-i] = true;
						}
					}
				}
			}
			lh = h;
			k++;
		}
		return meml==0;
	}
}
