package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17677

import java.util.Map;
import java.util.HashMap;

public class Q17677 {
	public static void main (String[] args) {
		String str1 = "handshake";
		String str2 = "shake hands";
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		Map<String, Integer> set1 = subProcess(str1);
		Map<String, Integer> set2 = subProcess(str2);
		
		System.out.println((int)Math.floor(jak(set1, set2) * 65536));
	}
	
	public static double jak(Map<String, Integer> set1, Map<String, Integer> set2) {
		
		if (set1.size() == 0 && set2.size() == 0) {
			return 1;
		}
		
		double min = 0; // 자료형에 유의할 것
		double max = 0;
		
		Map<String, Integer> minSet = new HashMap<>();
		Map<String, Integer> maxSet = new HashMap<>();
		
		// 참고(맵 순회 방법): http://starblood.tistory.com/entry/Map-HashMap-%EC%88%9C%ED%9A%8C%ED%95%98%EA%B8%B0
		for (Map.Entry<String, Integer> entry: set1.entrySet()) {
			maxSet.put(entry.getKey(), entry.getValue());
		}
		
		for (Map.Entry<String, Integer> entry: set2.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			
			if (set1.containsKey(key)) {
				minSet.put(key, Math.min(set1.get(key), value));
				maxSet.put(key, Math.max(maxSet.get(key), value));
			} else {
				maxSet.put(key, value);
			}
		}
		
		for (Map.Entry<String, Integer> entry: minSet.entrySet()) {
			min += entry.getValue();
		}
		
		for (Map.Entry<String, Integer> entry: maxSet.entrySet()) {
			max += entry.getValue();
		}
		
		return min/max;
	}
	
	// 이렇게 하는 방법도 있지만 for문을 이용해서 문자를 2개씩 따면서 패턴매칭을 통해 확인하는 경우도 있다.
	public static Map<String, Integer> subProcess(String str) {
		Map<String, Integer> set = new HashMap<>();
		
		char laggedChar = '0';
		for (int i=0; i<str.length(); i++) {
			char target = str.charAt(i);
			
			if (target >= 'a' && target <='z' && laggedChar != '0') {
				
				// 참고(char->string을 위한 방): https://hashcode.co.kr/questions/155/char%EB%A5%BC-string%EC%9C%BC%EB%A1%9C-%EB%B0%94%EA%BE%B8%EB%8A%94%EB%B2%95
				String concat = Character.toString(laggedChar) + Character.toString(target);
				
				if (set.containsKey(concat)) {
					set.put(concat, set.get(concat).intValue() + 1);
				} else {
					set.put(concat, 1);
				}
				
			} 
			
			if (target >= 'a' && target <='z') {
				laggedChar = target;
			} else {
				laggedChar = '0';
			}
		}
		
		return set;
	}
}
