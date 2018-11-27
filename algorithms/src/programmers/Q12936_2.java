package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12936

import java.util.ArrayList;

public class Q12936_2 {
	public static void main(String args[]) {
		Q12936_2 q = new Q12936_2();
		System.out.println(q.solution(3, 5));
	}
	
	public int[] solution(int n, long k) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(n+1);
		for (int i=0; i<n+1; i++) numbers.add(i); // 처음 arraylist의 사이즈는 0이기 때문에 초기화 할 때, numbers.size()하면 수치가 안들어간다.
		int[] ret = new int[n];
		
		while(factorial(n-1) > k) {
			ret[ret.length - n] = ret.length - n + 1;
			numbers.remove(new Integer(ret[ret.length - n])); // Integer ArrayList()에서 특정 엘리먼트 자체를 지우는 방법
			n--;
		}
		
		while(n > 0) {
			if (k % factorial(n-1) == 0) {
				
				int res = (int)(k / factorial(n-1));
				
				ret[ret.length - n] = numbers.get(res);
				numbers.remove(new Integer(ret[ret.length - n]));
				n--;
				
				for (int i=numbers.size()-1; i>=1; i--) {
					ret[ret.length - n] = numbers.get(i);
					numbers.remove(new Integer(ret[ret.length - n]));
					n--;
				}
						
			} else {
				
				int res = (int)(k / factorial(n-1)) + 1;
				
				ret[ret.length - n] = numbers.get(res);
				numbers.remove(new Integer(ret[ret.length - n]));
				
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

// 참고 : http://gurumee92.tistory.com/57
// 참고(스트림 함수 관련) : http://knight76.tistory.com/entry/IntStream-LongStream%EC%9D%98-%EB%B2%94%EC%9C%84-range-rangeClose-%EC%B0%A8%EC%9D%B4-%EB%B0%8F-%EC%98%88%EC%A0%9C

//public int[] setAlign(int n, long k) {
//	// 1. 리스트와 배열을 만든다.
//	List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
//
//	int[] answer = new int[n];
//	int idx = 0;
//	k -= 1;
//
//	while (n > 0) {
//		long factor = factorial(n - 1); // 2. 해당 자리 수가 가질 수 있는 경우의 수 저장
//		int index = (int) (k / factor); // 3. 인덱스 계산
//
//		answer[idx++] = list.remove(index); // 3. 해당 인덱스의 요소 삭제와 동시에 배열에 순서대로 넣는다.
//
//		k %= factor; // 4. 다음 자리수를 검사하기 위해 나머지 연산을 한다.
//		n -= 1; // 5. n을 1 빼고 6. 이를 반복한다.
//	}
//
//	return answer;
//}