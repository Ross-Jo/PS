package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12903

public class Q12903 {
	public static void main(String args[]) {
		String s = "abcd";
		int length = s.length();
		
		System.out.println(length % 2 == 0 ? s.substring(length / 2 - 1, length / 2 + 1): Character.toString(s.charAt(length / 2)));
	}
}