package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12933

import java.util.Comparator;
import java.util.stream.*;

public class Q12933 {
	public static void main(String args[]) {
		Q12933 q = new Q12933();
		long n = 118372;
		System.out.println(q.solution(n));
	}
	
	public long solution(long n) {
		return Long.parseLong(Stream.of(("" + n).split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining()));
	}
}

//String str = Integer.toString(n);
//char[] c = str.toCharArray();
//Arrays.sort(c);
//StringBuilder sb = new StringBuilder(new String(c,0,c.length));  
//return Integer.parseInt(((sb.reverse()).toString()));

//public int reverseInt(int n){
//    res = "";
//    Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
//    return Integer.parseInt(res);
//}