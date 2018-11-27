package baekjoon;

// https://www.acmicpc.net/problem/12969

//[다시 풀기] #12969 

import java.util.Scanner;

public class Q12969 {
	static boolean[][][][] d = new boolean[31][31][31][436];
	static char[] ans;
	static int n, k;
	
	static boolean go(int i, int a, int b, int p) {
		if (i == n) {
			if (p == k) return true;
			else return false;
		}
		
		if (d[i][a][b][p]) return false; // 이미 탐색 했던 상황의 경우, 다음에는 탐색을 하지 않음. 이 문제에서는 되는 경우 한가지만 찾으면 되기 때문 
		d[i][a][b][p] = true; // 간 길에 대한 표시 
		
		ans[i] = 'A';
		if(go(i+1, a+1, b, p)) return true;
		
		ans[i] = 'B';
		if(go(i+1, a, b+1, p+a)) return true;
		
		ans[i] = 'C';
		if(go(i+1, a, b, p+a+b)) return true;
		
		return false;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		ans = new char[n];
		
		if (go(0,0,0,0)) {
			System.out.println(new String(ans));
		} else {
			System.out.println(-1);
		}
		
		sc.close();
	}
}