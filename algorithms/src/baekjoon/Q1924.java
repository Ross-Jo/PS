package baekjoon;

// https://www.acmicpc.net/problem/1924

import java.util.Calendar;
import java.util.Scanner;

//2007년 1월 1일은 월요일
//1, 3, 5, 7, 8, 10, 12 : 31일
//4, 6, 9, 11 : 30일
//2 : 28일

public class Q1924 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int date = sc.nextInt();
		String[] day = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

		Calendar cal = Calendar.getInstance();

		cal.set(2007, month - 1, date);
		System.out.println(day[cal.get(Calendar.DAY_OF_WEEK) - 1]);
		sc.close();
	}
}