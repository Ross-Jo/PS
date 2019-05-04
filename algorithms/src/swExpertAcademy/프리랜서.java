package swExpertAcademy;

import java.util.Scanner;

public class 프리랜서 {
	static int T, N, M;
	static int dp[], works[][];

	static void quickSort(int s, int e) {
		if (s < e) {
			int p = works[1][s + (e - s) / 2];
			int l = s;
			int r = e;
			while (l <= r) {
				while (works[1][l] < p) {l++;}
				while (works[1][r] > p) {r--;}
				if (l <= r) {
					int t0, t1, t2;
					t0 = works[0][l]; 
					t1 = works[1][l]; 
					t2 = works[2][l];
					
					works[0][l] = works[0][r]; 
					works[1][l] = works[1][r]; 
					works[2][l] = works[2][r];
					
					works[0][r] = t0; 
					works[1][r] = t1; 
					works[2][r] = t2;
					
					l++;
					r--;
				}
			}
			quickSort(s, l - 1);
			quickSort(l, e);
		}
	}

	
	static int before(int i) {
		int j = 0;
		if (i-1>0) {
			for (j = i-1; j > 0; j--) {
				if (works[1][j] < works[0][i]) return j;
			}
		}
		return j;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		T = Integer.parseInt(sc.next());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(sc.next());
			M = Integer.parseInt(sc.next());
			works = new int[3][N + 1];
			dp = new int[N + 1];
			
			for (int i = 1; i <= N; i++) {
				works[0][i] = Integer.parseInt(sc.next());
				works[1][i] = Integer.parseInt(sc.next());
				works[2][i] = Integer.parseInt(sc.next());
			}
			
			quickSort(0, N);
			
			for (int i = 1; i <= N; i++) dp[i] = Math.max(dp[i - 1], works[2][i] + dp[before(i)]);
			System.out.println("#" + t + " " + dp[N]);
		}
		sc.close();
	}
}
