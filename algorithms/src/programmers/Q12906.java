package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12906

import java.util.ArrayList;

public class Q12906 {
	public static void main(String args[]) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		int lagged = -1;

		for (int el : arr) {
			if(el != lagged) {
				ans.add(el);
			}
			lagged = el;
		}
		
		int[] answer = ans.stream().mapToInt(i -> i).toArray();
	}
}