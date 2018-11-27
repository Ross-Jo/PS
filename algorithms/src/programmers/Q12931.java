package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12931

import java.util.Arrays;

public class Q12931 {
	public static void main(String args[]) {
		Q12931 q = new Q12931();
		int n = 987;
		System.out.println(q.solution(n));
	}
	
    public int solution(int n) {
    	return Arrays.stream(Integer.toString(n).split("")).mapToInt(Integer::parseInt).sum();
    }
}

// 스트림 관련 내용 
// http://palpit.tistory.com/647
