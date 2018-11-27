package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12926

public class Q12926 {
	public static void main(String args[]) {
		
	}
	public String solution(String s, int n) {

		String ret = "";
		for (char c : s.toCharArray()) {

			if (c == ' ') {
				ret += " ";
			} else if (c >= 'a' && c <= 'z') {
				ret += Character.toString((char) ((c + n - 'a') % 26 + 'a'));
			} else {
				ret += Character.toString((char) ((c + n - 'A') % 26 + 'A'));
			}
		}

		return ret;
	}
}