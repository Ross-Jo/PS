package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12930

public class Q12930 {
	public static void main(String args[]) {
		Q12930 q = new Q12930();
		String s = "try hello world";
		System.out.println(q.solution(s));
	}
	
	public String solution(String s) {
		String ret = "";
		boolean flag = true;
		
		for (char c: s.toCharArray()) {
			
			if (c == ' ') {
				ret += ' ';
				flag = true;
			} else {
				if (flag) {
					ret += Character.toUpperCase(c);
				} else {
					ret += Character.toLowerCase(c);
				}
				flag = !flag;
			}
		}
		
		return ret;
	}
}