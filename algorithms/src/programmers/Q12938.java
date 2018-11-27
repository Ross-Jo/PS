package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12938

import java.util.Arrays;

public class Q12938 {
	public static void main(String args[]) {
		Q12938 q = new Q12938();
		for (int el: q.solution(2, 9)) {
			System.out.print(el + " ");
		}
	}
	public int[] solution(int n, int s) {
		if (n>s) return new int[]{-1};
		
		int[] holes = new int[n];
		int target = (int) Math.ceil(s/(double)n);
		int sum = target * holes.length;
		
		Arrays.fill(holes,target);
		
		while(sum!=s) {
			for (int i=0; i<holes.length && sum > s; i++) {
				holes[i]--;
				sum--;
			}
		}

		return holes;
	}
}

//public int[] solution(int n, int s) {
//	if (n>s) return new int[]{-1};
//	
//	int[] holes = new int[n];
//	while(s>0) {
//		for (int i=holes.length-1; i>=0 && s>0; i--) {
//			holes[i] += 1;
//			s--;
//		}
//	}
//	
//	return holes;
//}

//public int[] bestSet(int n, int s) {
//	int[] answer = null;
//	if (n > s) {
//		answer = new int[1];
//		answer[0] = -1;
//	} else {
//		answer = new int[n];
//		int i = 0;
//		while (s > 0) {
//			answer[(i % n)]++;
//			i++;
//			s--;
//		}
//
//	}
//	Arrays.sort(answer);
//	return answer;
//}