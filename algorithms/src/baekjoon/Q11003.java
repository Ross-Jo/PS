package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//public class Q11003 {
//	static int N, L;
//	static class Node {
//		int idx, num;
//		Node(int idx, int num) {
//			this.idx = idx;
//			this.num = num;
//		}
//	}
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken()); L = Integer.parseInt(st.nextToken());
//		Deque<Node> d = new LinkedList<>();
//		
//		st = new StringTokenizer(br.readLine());
//		for (int i=0; i<N; i++) {
//			int target = Integer.parseInt(st.nextToken());
//			while(!d.isEmpty() && d.getLast().num >= target) d.removeLast();
//			d.addLast(new Node(i, target));
//			if(d.getFirst().idx <= i-L) d.removeFirst();
//			
//			bw.write(d.getFirst().num + " ");
//		}
//		bw.flush();
//		
//		br.close();
//		bw.close();
//	}
//}

// 참고 : https://www.acmicpc.net/board/view/36231
// 위의 코드는 시간 초과

/*
 * [배운점]
 * - 선언 순서에 따라 속도차이가 발생하기도 한다. 
 * - split 보다는 stringTokenizer가 빠르다. 참고 : https://mygumi.tistory.com/78
 * - Integer.toString은 생각보다 느리다. 참고 : https://stackoverflow.com/questions/11001330/java-split-string-performances
 * - ArrayDeque가 LinkedList Deque보다 빠르다. 참고 : https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
 */
public class Q11003 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int value[] = new int[N];

		st = new StringTokenizer(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		int result[] = new int[N];
		for (int i = 0; i < N; ++i) {
			value[i] = Integer.parseInt(st.nextToken());
			while (!deque.isEmpty() && value[deque.peekLast()] > value[i]) deque.pollLast();
			deque.offer(i);
			if (deque.peekFirst() < i - L + 1) deque.pollFirst();
			result[i] = value[deque.peekFirst()];
		}
		for (int e: result) bw.write(e + " ");
		bw.flush();
		bw.close();
	}
}
