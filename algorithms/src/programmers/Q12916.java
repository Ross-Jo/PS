package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12916

public class Q12916 {
	public static void main(String args[]) {
		Q12916 q = new Q12916();
		String s = "pPoooyY";
		q.solution(s);
	}
	
    boolean solution(String s) {
		s = s.toLowerCase();
        int p = 0;
		int y = 0;
		
		for (char c: s.toCharArray()) {
			if (c == 'p') {
				p++;
			}
			else if (c == 'y') {
				y++;
			}
		}
		
		if (p == 0 && y == 0) return true;
		else if (p == y) return true;
		else return false;
    }
}

//boolean solution(String s) {
//    s = s.toUpperCase();
//    return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
//}

// 참고 : https://stackoverflow.com/questions/22435833/why-is-string-chars-a-stream-of-ints-in-java-8
