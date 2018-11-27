package baekjoon;

// https://www.acmicpc.net/problem/2916

import java.util.Scanner;

public class Q2916_2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = sc.nextInt();

		boolean[] d = new boolean[360];
		d[0] = true; // 각도 0은 언제나 생성 가능 
		for (int i = 0; i < n; i++) { 
			for (int k = 0; k < 360; k++) { // 아래의 for문에서 파생된 각도들을 이용해 다시 a[i]를 이용하여 새로운 각도를 만들 수 있으므로 최대 360회의 반복을 시행함. 1도로 359번 반복하면 360도 까지도 생성 가능. 즉, 이 줄은 단순 '반복'의 의미 
				for (int j = 0; j < 360; j++) { // a[i]라는 각도 + 현재 만든 각도 j를 통해 생성할 수 있는 각도들 
					if (d[j] == false) continue;
					d[(j - a[i] + 360) % 360] = true;
					d[(j + a[i]) % 360] = true;
				}
			}
		}
		while (m-- > 0) {
			int x = sc.nextInt();
			System.out.println(d[x] ? "YES" : "NO");
		}
		sc.close();
	}
}
