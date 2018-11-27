package baekjoon;

// https://www.acmicpc.net/problem/12869

import java.util.Arrays;
import java.util.Scanner;

public class Q12869 {
	static int n;
	static int[] scvs = new int[3];
	static int[][][][] d = new int[61][61][61][15];
	
	static void attack(int a, int b, int c, int count) {
		a = a<0 ? 0 : a;
		b = b<0 ? 0 : b;
		c = c<0 ? 0 : c;
		
		if(count >= 15) return;
		if(a==0 && b==0 && c==0) {
			d[a][b][c][count] = count;
			return;
		}
		
		if (d[a][b][c][count] != -1) return;
		d[a][b][c][count] = count;
		
		attack(a-9, b-3, c-1, count+1);
		attack(a-9, b-1, c-3, count+1);
		attack(a-3, b-9, c-1, count+1);
		attack(a-3, b-1, c-9, count+1);
		attack(a-1, b-9, c-3, count+1);
		attack(a-1, b-3, c-9, count+1);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i=0; i<n; i++) scvs[i] = sc.nextInt();
		
		for (int i=0; i<61; i++) {
			for (int j=0; j<61; j++) {
				for (int k=0; k<61; k++) {
					Arrays.fill(d[i][j][k], -1);
				}
			}
		}
		attack(scvs[0], scvs[1], scvs[2], 0);
		
		int ans = 15;
		for (int i=0; i<d[0][0][0].length; i++) {
			if(d[0][0][0][i] != -1) {
				ans = Math.min(ans, d[0][0][0][i]);
			}
		}
		System.out.println(ans);
		
		sc.close();
	}
}
