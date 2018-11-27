package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12919

public class Q12919 {
	public static void main(String args[]) {
		Q12919 q = new Q12919();
		String[] seoul = {"Jane", "Kim"};
		System.out.println(q.solution(seoul));
	}
	
	public String solution(String[] seoul) {
		int index = 0;
		for (String el: seoul) {
			if (el.equals("Kim")) {
				break;
			}
			index++;
		}
		
		return String.format("김서방은 %d에 있다", index);
	}
}

//int x = Arrays.asList(seoul).indexOf("Kim");