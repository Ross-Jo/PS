package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12927

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q12927 {
	public static void main(String args[]) {
		Q12927 q = new Q12927();
		System.out.println(q.solution(4, new int[]{5, 6, 8, 7}));
	}

//	public long solution(int n, int[] works) {
//		Arrays.sort(works);
//		long ans = 0;
//		
//		while(n > 0) {
//			if (works[works.length-1] > 0) {
//				works[works.length-1]--;
//			}
//			n--;
//			Arrays.sort(works);
//		}
//		
//		for (int work: works) {
//			ans += work * work;
//		}
//		
//		return ans;
//	}
	
	public long solution(int n, int[] works) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, Collections.reverseOrder()); // 가장 큰수가 맨 꼭대기에 올라오게 된다.
		for (int work: works) pq.add(work);
		
		long ans = 0;
		while(n > 0) {
			if (pq.peek() > 0) {
				int top = pq.poll();
				pq.add(top - 1);
			}
			n--;
		}
		
		for (int work: pq) ans += work * work;
		return ans;
	}
}

//public int noOvertime(int no, int[] works) {
//	int result = 0;
//	List<Integer> list = IntStream.of(works).boxed().collect(Collectors.toList());
//
//	int index = 0;
//	while (no > 0) {
//		index = list.indexOf(Collections.max(list));
//		list.set(index, list.get(index) - 1);
//		no--;
//	}
//	result = list.stream().map(n -> n * n).mapToInt(Integer::intValue).sum();
//	return result;
//}
