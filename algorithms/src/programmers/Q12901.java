package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12901

public class Q12901 {
	public static void main(String args[]) {

	}
	public String solution(int a, int b) {
		String[] DOW = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int[] months = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int days = 0;
		for (int i = 0; i < a - 1; i++) {
			days += months[i];
		}

		days += b;

		return DOW[(5 + days - 1) % 7];
	}
}
