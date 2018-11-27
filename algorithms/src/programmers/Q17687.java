package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17687

public class Q17687 {
	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		
		int startNum = 0;
		
		String targetString = new String();
		String retString = new String();
		
		while (targetString.length() < m * t) {
			targetString += Integer.toString(startNum++, n); // 진법변환 방법
		}
		
		for (int i=0; i<t; i++) {
			retString += targetString.charAt(p - 1 + i * m);
		}
		
		System.out.println(retString.toUpperCase());
	}
}
