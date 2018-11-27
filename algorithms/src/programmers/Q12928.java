package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12928

public class Q12928 {
	public static void main(String args[]) {
		Q12928 q = new Q12928();
		int n = 3000;
		System.out.println(q.solution(n));
	}
	
	public int solution(int n) {
		
		int sum = 0;
		for (int i=1; i<=n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		
		return sum;
	}
}

//for(int i = 1; i <= num/2; i++){
//	if(num%i == 0) answer += i;
//}