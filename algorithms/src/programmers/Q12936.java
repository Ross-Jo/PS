package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12936

public class Q12936 {
	
	public static void main(String args[]) {
		Q12936 q = new Q12936();
		System.out.println(q.solution(3, 5));
	}
	
	public int[] solution(int n, long k) {
		boolean[] numbers = new boolean[n+1];
		int[] ret = new int[n];
		
		while(factorial(n-1) > k) {
			ret[ret.length - n] = ret.length - n + 1;
			numbers[ret.length - n + 1] = true;
			n--;
		}
		
		while(n > 0) {
			if (k % factorial(n-1) == 0) {
				
				int res = (int)(k / factorial(n-1));
				
				int counter = 0;
				for (int i=1; i<numbers.length; i++) {
					if(!numbers[i]) {
						counter++;
						if (counter == res) {
							ret[ret.length - n] = i;
							numbers[i] = true;
							n--;
						}
					}
				}
				
				for (int i=numbers.length-1; i>=1; i--) {
					if(!numbers[i]) {
						ret[ret.length - n] = i;
						numbers[i] = true;
						n--;
					}
				}
						
						
			} else {
				
				int res = (int)(k / factorial(n-1)) + 1;
				
				int counter = 0;
				for (int i=1; i<numbers.length; i++) {
					if(!numbers[i]) {
						counter++;
						if (counter == res) {
							ret[ret.length - n] = i;
							numbers[i] = true;
						}
					}
				}
				
				k = k % factorial(n-1);
				n--;
			}
		}

		return ret;
	}
	public long factorial(int n) {
		long ret = 1;
		while(n>1) ret *= n--;
		return ret;
	}
}