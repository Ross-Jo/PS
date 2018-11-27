package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42889

import java.util.Arrays;

class Stage implements Comparable<Stage> {
	int number;
	double failRate;
	
	Stage(int number, double failRate) {
		this.number = number;
		this.failRate = failRate;
	}
	
	@Override
	public int compareTo(Stage target) {
		int res = Double.compare(failRate, target.failRate);
		if(res < 0) {
			return 1;
		} else if(res == 0) {
			return this.number < target.number ? -1 : 1;
		} else {
			return -1;
		}
	}
}

public class Q42889 {
	public static void main(String args[]) {
		Q42889 q = new Q42889();
		q.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
	}
	public int[] solution(int N, int[] stages) {
		Stage[] s = new Stage[N];
		int[] ap = new int[N+1];
		int[] nc = new int[N+1];
		int[] ret = new int[N];
		
		for (int i=0; i<stages.length; i++) {
			for (int j=1; j<=N; j++) { 
				if (j <= stages[i]) ap[j]++;
			}
			if (stages[i] < nc.length) nc[stages[i]]++;
			
		}
		
		for (int i=0; i<s.length; i++) {
			if (ap[i+1] != 0) {
				s[i] = new Stage(i+1, (double)nc[i+1]/ap[i+1]);
			} else {
				s[i] = new Stage(i+1, 0.0);
			}
			
		}
		
		Arrays.sort(s);
		
		for (int i=0; i<ret.length; i++) {
			ret[i] = s[i].number;
			System.out.println(ret[i]);
		}
		
		return ret;
	}
}
