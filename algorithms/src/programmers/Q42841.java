package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42841

import java.util.Set;
import java.util.HashSet;

public class Q42841 {
	public static void main(String args[]) {
		
	}
    int count = 0;
    public int solution(int[][] baseball) {
        for(int i=111; i<=999; i++) {
            String ta = Integer.toString(i);
            if(ta.contains("0")) continue;
            Set<Character> s = new HashSet<>();
            for(int x=0; x<3; x++) s.add(ta.charAt(x));
            if(s.size() < 3) continue;
            int tc = 0;
           
            for (int j=0; j<baseball.length; j++) {
                int sc = 0;
                int bc = 0;
                String t = Integer.toString(baseball[j][0]);
            
                for(int k=0; k<3; k++) {
                    boolean bcb = false;
                    boolean st = false;
                    for(int l=0; l<3; l++) {
                        if(t.charAt(k) == ta.charAt(l)) {
                            if(k==l) {
                                sc++;
                                st = true;
                            }
                            else bcb = true;
                        }
                    }
                    if (!st && bcb) bc++;
                }
                
                if(sc == baseball[j][1] && bc == baseball[j][2]) tc++;
            }
            
            if(tc == baseball.length) count++;
        }
        return count;
    }
}