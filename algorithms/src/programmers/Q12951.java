package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12951

public class Q12951 {
	public static void main(String args[]) {
		Q12951 q = new Q12951();
		System.out.println(q.solution("for the last week"));
	}

	public String solution(String s) {
		s = s.toLowerCase();
		String ret = "";
		boolean flag = true;
		
		for (char i: s.toCharArray()) {
			if(flag && i >= 'a' && i <= 'z') {
				ret += Character.toUpperCase(i);
				flag = false;
			} else {
				ret += i;
				flag = i == ' ' ? true : false;
			}
		}

		
		return ret;
	}
}