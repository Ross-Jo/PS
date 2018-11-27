package baekjoon;

// https://www.acmicpc.net/problem/9012

import java.util.Scanner;
import java.util.Stack;

public class Q9012 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		String line = null;

		boolean flag = true;
		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < testCase; i++) {
			line = sc.nextLine();
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == '(') {
					st.push(line.charAt(j));
				} else {
					if (st.isEmpty() == false && st.peek() == '(') { // 스택에 내용물이 있고, 위쪽이 '('라면 매칭되는 ')'를 읽어들일 때마다 pop연산을
																		// 해준다.
						st.pop();
					} else {
						System.out.println("NO"); // 제대로 pop이 되지 않는 경우는 올바른 PS가 아니므로 NO출력
						flag = !flag; // 플래그 반전
						break; // 내부 for문을 벗어남
					}
				}
			}
			if (flag == true && st.isEmpty())
				System.out.println("YES"); // 내부에서 flag를 건드리지 않았고(즉, 결과출력을 한적이 없고) 스택이 비어있는 상태라면 YES를 출력
			else if (flag == true)
				System.out.println("NO"); // 내부에서 flag를 건드리지 않았고, YES의 조건을 만족시키지 못한다면 NO출력
			flag = true; // flag 원위치
			st.removeAllElements(); // 스택 초기화
		}

		sc.close();
	}
}