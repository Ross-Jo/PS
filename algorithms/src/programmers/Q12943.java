package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12943

public class Q12943 {
	public static void main(String args[]) {
		
	}
	public int solution(int num) {
		int cnt = 0;
		long tmp = num;
		while (tmp != 1) {
			tmp = (tmp % 2 == 0) ? tmp / 2 : tmp * 3 + 1;
			if (++cnt > 500)
				return -1;
		}
		return cnt;
	}
}