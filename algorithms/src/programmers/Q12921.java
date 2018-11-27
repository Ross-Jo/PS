package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12921

public class Q12921 {
	public static void main(String args[]) {
		Q12921 q = new Q12921();
		int n = 100000000;
//		int n = 100;
		System.out.println("결과: " + q.solution(n));
	}
	
	public int solution(int n) {
		int answer = 0;
		
		boolean[] num = new boolean[n+1];
		
		for (int i=2; i<=Math.sqrt(n); i++) {
			if (num[i] == false) {
				for (int j=i+i; j<=n; j += i) {
					if(num[j] == false && j < num.length) {
						num[j] = true;
					}
				}
			}
		}
		
		for (boolean bool: num) {
			if (bool == false) answer++;
		}
		
		return answer - 2;
	}
}

// 참고 : http://marobiana.tistory.com/91
