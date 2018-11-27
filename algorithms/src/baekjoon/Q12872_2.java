package baekjoon;

// https://www.acmicpc.net/problem/12872

import java.util.Scanner;

public class Q12872_2 {
	public static final long mod = 1000000007;
	public static int n, m, p;
	public static long[][] d = new long[101][101];

	public static long go(int position, int x) {
		int y = n - x; // 한번도 쓰지 않은 곡은 n - x(이미 쓴 곡) 
		if (position == p) {
			if (y == 0) return 1;
			else return 0; // 여기 주석처리 하면 런타임에러남. 일단 p에 도달하면 그 이후로는 어차피 볼 필요도 없고 + 여기를 넘어가면 배열 할당범위를 벗어나기 때문에 p에 도달하면 무조건 로직 진행을 종료시켜야 함 
		}
		
		long ans = d[position][x];
		if (ans != -1) return ans;
		
		ans = 0;
		if (y > 0) ans += go(position + 1, x + 1) * y;
		if (x > m) // 쓴 곡을 또 포함시킬 수 있는 경우. (m개의 영역 안에는 서로 겹치는 곡이 존재할 수 없다)  
			ans += go(position + 1, x) * (x - m);
		
		ans %= mod;
		d[position][x] = ans;
		return ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		p = sc.nextInt();
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				d[i][j] = -1;
			}
		}
		
		System.out.println(go(0, 0));

		sc.close();
	}
}