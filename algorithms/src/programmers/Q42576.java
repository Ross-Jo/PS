package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42576

import java.util.HashMap;
import java.util.Map.Entry;

public class Q42576 {
	public static void main(String args[]) {
		
	}
	
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        
        for (String p: participant) {
            if(h.containsKey(p)) {
                int val = h.get(p);
                h.put(p, val + 1);
            } else {
                h.put(p, 1);
            }
        }
        
        for (String c: completion) {
            int val = h.get(c);
            h.put(c, val-1);
        }
        
        for (Entry<String, Integer> e: h.entrySet()) {
            if (e.getValue() == 1) {
                answer = e.getKey();
            }
        }
        
        return answer;
    }
}

//class Solution {
//	public String solution(String[] participant, String[] completion) {
//		String answer = "";
//		HashMap<String, Integer> hm = new HashMap<>();
//		for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
//		for (String player : completion) hm.put(player, hm.get(player) - 1);
//
//		for (String key : hm.keySet()) {
//			if (hm.get(key) != 0) {
//				answer = key;
//			}
//		}
//		return answer;
//	}
//}
