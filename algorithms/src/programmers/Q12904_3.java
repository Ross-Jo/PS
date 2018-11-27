package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12904

public class Q12904_3 {
	public static void main(String args[]) {
		Q12904_3 q = new Q12904_3();
		String s = "abcfba";
		System.out.println(q.solution(s));
	}
	public int solution(String s) {
		int answer = 1;
		int length = s.length();
		char[] cs = s.toCharArray();
		int[][] palindrome = new int[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				
				if (cs[i] == cs[j]) {
					
					
					if (i == 0 || j == length - 1) {
						palindrome[i][j] = 1;
					} else {
						palindrome[i][j] = palindrome[i - 1][j + 1] + 1;
					}
					
					printer(palindrome);

					if (i == j) {
						answer = Math.max(answer, palindrome[i][j] * 2 - 1);
					} else if (i + 1 == j) {
						answer = Math.max(answer, palindrome[i][j] * 2);
					}
				}
				
			}
		}

		return answer;
	}
	
	public void printer(int[][] plate) {
		for (int i=0; i<plate.length; i++) {
			for (int j=0; j<plate[0].length; j++) {
				System.out.print(plate[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}