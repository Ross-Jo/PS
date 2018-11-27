package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42883

//비슷하지만 다른 풀이 방법(스택사용) -> 참고 : http://gall.dcinside.com/mgallery/board/view/?id=ps&no=1196&page=2

public class Q42883_2 {
	public static void main(String args[]) {
		
	}
	public String solution(String number, int k) {
		int n = number.length();
		int[] numbers = new int[n];
		int a = 0;
		for (char c : number.toCharArray())
			numbers[a++] = c - '0';

		int si = 0;
		int max = -1;
		int leftOver = n - k;
		StringBuilder sb = new StringBuilder();

		while (leftOver > 0) {
			int mi = si;
			for (int i = si; i <= n - leftOver; i++) {
				if (max < numbers[i]) {
					max = numbers[i];
					mi = i;
				}
			}
			sb.append(max);
			max = -1;
			si = mi + 1;
			leftOver--;
		}

		return sb.toString();
	}
}
