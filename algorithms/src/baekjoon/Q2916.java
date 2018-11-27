package baekjoon;

// https://www.acmicpc.net/problem/2916

import java.util.Scanner;

//2916
//틀린 코드 => 왜 이 코드가 틀리는지 알아볼 것 
public class Q2916 {
	static boolean[] a1 = new boolean[361];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] a = new int[N];
		a1[0] = true;
		
		for (int i=0; i<N; i++) {
			a[i] = sc.nextInt();
			
			/**
			* 아래 부분에서 각도를 파생시키는 부분이 잘못됨.
			* 정확히 말하면 42~46 부분(의미가 불명확한 코드). 해당 부분의 코드를 
			* a1[(k-a[i]+360)%360] = true;
			* a1[(k+a[i])%360] = true;
			* 와 같이 바꿔야 함. 
			* 
			* 그리고 가장 내측의 반복문 진입을 위한 판별식 설정도 틀렸음 (40줄).
			* 한 각도로 생성할 수 있는 것들을 주욱 생성하고 또 그 생성된 각도들로 생성할 수 있는 각을 산출하는 반복문을
			* 104-2와 같이 작성해야 됨.
			* 
			* 그리고 위와 같이 수정하면 34~37라인과 같은 초기화도 필요 없게 됨.
			*/
			for (int j=1; j<=360; j++) {
				if(j%a[i] == 0) a1[j] = true;
				if(j%(360-a[i]) == 0) a1[j] = true;
			}
			
			for (int j=1; j<=360; j++) {
				if(a1[j] == true) {
					for (int k=1; k<=360; k++) {
						if (j-a[i]*k >= 1) a1[Math.abs(j-a[i]*k)] = true;
						if (j+a[i]*k <= 360) a1[j+a[i]*k] = true;
						
						if (j-(360-a[i])*k >= 1) a1[Math.abs(j-(360-a[i])*k)] = true;
						if (j+(360-a[i])*k <= 360) a1[j+(360-a[i])*k] = true;
					}
				}
			}
		}
			
		while(K-- > 0) {
			int t = sc.nextInt();
			String ret = a1[t] ? "YES" : "NO";
			System.out.println(ret);
		}
		
		sc.close();
	}
}