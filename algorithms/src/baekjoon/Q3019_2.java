package baekjoon;

//https://www.acmicpc.net/problem/3019

import java.util.*;

public class Q3019_2 {
	static int[] a;
	static int n, m;

	static int calc(int i, String s) {
		if (i + s.length() > n) return 0; // 블록이 주어진 구역을 벗어나면 당연히 실패 
		int base = a[i] - (s.charAt(0) - '0'); // 일단 해당 칼럼과 블록(상대적 높이 정보를 가지고 있음)과의 기본적인 높이차를 구한다. - 기준이 되는 갚 구하기  
		for (int j = 0; j < s.length(); j++) { // 해당 블록이 가로길이 만큼만 따져주면 된다. 
			if (base != a[i + j] - (s.charAt(j) - '0')) return 0; // 만약 상대적 높이 차이가 깨지는 지점이 있다면, 빈 공간이 있다는 얘기이므로 실패 
		}
		return 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (m == 1) {
				ans += calc(i, "0") + calc(i, "0000"); // 각 블록을 어떻게 모델링 했는지 참고할 것 : http://stack07142.tistory.com/300
													   // 높이 차이를 상대적으로 표현함 
			} else if (m == 2) {
				ans += calc(i, "00");
			} else if (m == 3) {
				ans += calc(i, "001") + calc(i, "10");
			} else if (m == 4) {
				ans += calc(i, "100") + calc(i, "01");
			} else if (m == 5) {
				ans += calc(i, "000") + calc(i, "01") + calc(i, "101") + calc(i, "10");
			} else if (m == 6) {
				ans += calc(i, "000") + calc(i, "00") + calc(i, "011") + calc(i, "20");
			} else if (m == 7) {
				ans += calc(i, "000") + calc(i, "00") + calc(i, "110") + calc(i, "02");
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
}
