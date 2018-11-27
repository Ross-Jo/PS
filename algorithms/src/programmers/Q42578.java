package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42578

import java.util.HashMap;

public class Q42578 {
	public static void main(String args[]) {
		
	}
    public int solution(String[][] clothes) {
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for (String[] cloth: clothes) h.put(cloth[1], h.getOrDefault(cloth[1], 0) + 1);
        
        int ans = 1;
        for (int val: h.values()) ans *= (val+1);
        return ans - 1;
    }
}
