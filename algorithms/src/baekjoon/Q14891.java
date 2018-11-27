package baekjoon;

// https://www.acmicpc.net/problem/14891

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q14891 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
//		int T = 4;
		
		String[] cog = new String[T+1];
		for (int i=1; i<=T; i++) cog[i] = br.readLine();
		int round = Integer.parseInt(br.readLine());

		while(round-- > 0) {
			String[] info = br.readLine().split(" ");
			int target = Integer.parseInt(info[0]);
			int dir = Integer.parseInt(info[1]);
			int[] set = new int[T+1];
			for (int i=0; i<=T; i++) set[i] = i;
			
			for (int i=1; i<T; i++) if (cog[i].charAt(2) != cog[i+1].charAt(6)) set[i+1] = set[i];

			int r_dir = dir; // 변수의 사용에 유의할 것 
			for (int i=1, j=target; i<=T; i++, j++) {
				if (j == T+1) j = 1;
				if (set[j] == set[target]) {
					if(Math.abs(target - j) % 2 != 0) r_dir = -dir;
					else r_dir = dir;
					if(r_dir == 1) {
						String el = cog[j];
						String tail = el.substring(el.length()-1);
						String body = el.substring(0, el.length()-1);
						cog[j] = tail + body;
					} else {
						String el = cog[j];
						String head = el.substring(0, 1);
						String body = el.substring(1);
						cog[j] = body + head;
					}
				}
			}
		}
		
		int ans = 0;
		for (int i=1; i<=T; i++) if(cog[i].charAt(0) == '1') ans++;
		
//		int ans = 0;
//		for (int i=1; i<=T; i++) if(cog[i].charAt(0) == '1') {
//			switch(i) {
//				case 1:
//					ans += 1;
//					break;
//				case 2:
//					ans += 2;
//					break;
//				case 3:
//					ans += 4;
//					break;
//				default:
//					ans += 8;
//			}
//		}
		
		System.out.println(ans);
		
		br.close();
	}
}