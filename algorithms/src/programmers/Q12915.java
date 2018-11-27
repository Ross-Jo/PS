package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12915

import java.util.Arrays;
import java.util.Comparator;

// 참고 : http://hochulshin.com/java-comparable-comparator/

public class Q12915 {
	public static void main(String args[]) {
//		String[] strings = {"abce", "abcd", "cdx"};
//		int n = 2;
		String[] strings = {"sun", "bed", "car"};
		int n = 1;
		
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {

				if (a.charAt(n) < b.charAt(n)) {
					return -1;
				} else if (a.charAt(n) > b.charAt(n)) {
					return 1;
				} else {
					return a.compareTo(b);
				}
			}
		});
		
		for (String el: strings) {
			System.out.println(el+" ");
		}
		
	}
}
// 참고: https://m.blog.naver.com/PostView.nhn?blogId=evella&logNo=90195439020&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
// 참고 : https://bestalign.github.io/2015/08/31/top-10-mistakes-java-developers-make-1/
// 참고 : http://asuraiv.blogspot.com/2015/06/java-list-toarray.html

//public String[] solution(String[] strings, int n) {
//    List<String> list = Arrays.asList(strings); // Arrays.asList()로 만든 List에 새로운 원소를 추가하거나 삭제는 할 수 없음
//    list.sort((a, b) -> {
//        int result = (a.split(""))[n].compareTo((b.split(""))[n]);
//        if(result == 0) return a.compareTo(b);
//        return result;
//    });
//    return list.toArray(new String[0]);
//}

// 진짜 어레이리스트를 돌려받기 위해서는 : ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));
