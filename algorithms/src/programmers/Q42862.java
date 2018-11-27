package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42862

import java.util.Arrays;

public class Q42862 {
	public static void main(String args[]) {
		
	}
    public int solution(int n, int[] lost, int[] reserve) {
        int[] p = new int[n+1];
        int count = 0;
        Arrays.fill(p, 1);
        for(int i=0; i<reserve.length; i++) p[reserve[i]]++;
        for(int i=0; i<lost.length; i++) p[lost[i]]--;
        for(int i=1; i<=n; i++) {
            if(p[i] == 0) continue;
            else {
                if(i-1 >=1 && p[i-1] == 0 && p[i] == 2) {
                    p[i-1] = 1;
                    p[i]--;
                    if(p[i] == 1) continue;
                }
                if(i+1 <=n && p[i+1] == 0 && p[i] == 2) {
                    p[i+1] = 1; 
                    p[i]--;
                }
            }
        }
        for (int i=1; i<=n; i++) if(p[i] >= 1) count++;       
        return count;
    }
}