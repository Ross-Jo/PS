package baekjoon;

//https://www.acmicpc.net/problem/4902

import java.util.*;

public class Q4902 {
	static int n;
	static int[][] a = new int[401][801];
	static int[][] s = new int[401][801];
	static int ans;
	
	static void calc(int row, int left, int right, int sum) {
		if (row < 1 || row > n) return;
		if (left < 1 || right > row * 2 - 1) return;
		
		sum += s[row][right] - s[row][left-1];
		if (ans < sum) ans = sum;
		
		if (right % 2 == 0) calc(row-1, left-2, right, sum); // 역방향 삼각형 
		else calc(row+1, left, right+2, sum); // 정방향 삼각형 
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for (int tc=1;; tc++) {
			n = sc.nextInt();
			if (n==0) break;
			
			ans = -100000;
			
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=i*2-1; j++) {
					a[i][j] = sc.nextInt();
					s[i][j] = s[i][j-1] + a[i][j];
				}
			}
			
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=i*2-1; j++) {
					calc(i, j, j, 0);
				}
			}
			
			System.out.printf("%d. %d\n", tc, ans);
		}
		sc.close();
	}
}