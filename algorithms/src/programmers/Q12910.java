package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12910

import java.util.ArrayList;
import java.util.Collections;

public class Q12910 {
	public static void main(String args[]) {
		int[] arr = {5,9,7,10};
		int divisor = 5;
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for (int el : arr) {
			if (el % divisor == 0) {
				ans.add(el);
			}
		}
		
		if (ans.isEmpty()) {
			ans.add(-1);
		}
		
		Collections.sort(ans);
		
		int[] answer = ans.stream().mapToInt(i -> i).toArray();
	}
}

//public int[] divisible(int[] array, int divisor) {
//    return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
//}