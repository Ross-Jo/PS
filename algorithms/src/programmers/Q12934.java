package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12934

public class Q12934 {
	public static void main(String args[]) {
		Q12934 q = new Q12934();
		long n = 121;
		System.out.println(q.solution(n));
	}
	
	public long solution(long n) {
		return (long)Math.pow((int)Math.sqrt(n), 2) == n ? (long) Math.pow(Math.sqrt(n)+1, 2) : -1 ; // 자료형에 유의할 것
	}
}

//public long solution(long num) {
//    double sqrt = Math.sqrt(num);
//      return (long) ((sqrt % 1) == 0 ? (sqrt + 1) * (sqrt + 1) : -1);
//}
