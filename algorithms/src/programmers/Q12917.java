package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12917

import java.util.Arrays;
import java.util.Comparator;

public class Q12917 {
	public static void main(String args[]) {
		Q12917 q = new Q12917();
		String s = "efgHjkIU";
		System.out.println(q.solution(s));
	}
	
	public String solution(String s) {
		String small = s.chars().filter(c -> c >= 'a' && c<= 'z').mapToObj(i -> (char)i).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
		String large = s.chars().filter(c -> c >= 'A' && c<= 'Z').mapToObj(i -> (char)i).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
		
		return sorter(small) + sorter(large);
	}
	
	public String sorter(String s) {
		Character[] chs = new Character[s.length()]; int i=0;
		String ret = "";
		
		for (char c: s.toCharArray()) {
			chs[i++] = c;
		}
		
		Arrays.sort(chs, new Comparator<Character>() {
			@Override
			public int compare(Character a, Character b) {
				if (a.compareTo(b) < 0) { // 그냥 무턱대로 -1, 1 로 비교하지 말자 
					return 1;
				} else if (a.compareTo(b) > 0) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		for (Character c: chs) {
			ret += Character.toString(c);
		}
		
		return ret;
	}
}

//import java.util.Arrays;

//public String reverseStr(String str){
//	char[] sol = str.toCharArray();
//	Arrays.sort(sol);
//	return new StringBuilder(new String(sol)).reverse().toString();
//}


//import java.util.stream.Stream;
//import java.util.stream.Collectors;
//import java.util.Comparator;

//public String reverseStr(String str){
//    return Stream.of(str.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
//}

//import java.util.*;
//public String solution(String s) {
//    return s.chars().boxed().sorted(Collections.reverseOrder()).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
//}
