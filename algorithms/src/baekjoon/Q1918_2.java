package baekjoon;

//https://www.acmicpc.net/problem/1918

import java.util.Stack;

//	출처: http://mygumi.tistory.com/181 [마이구미의 HelloWorld]
public class Q1918_2 {
public static void main(String args[]) {
	
}

private void solve() {
//    char[] s = sc.readLine().toCharArray();
	char[] s = {};
	int len = s.length;

	Stack<Character> stack = new Stack<Character>();
	StringBuilder sb = new StringBuilder();

	for (int i = 0; i < len; i++) {
		int p = priority(s[i]);
		char ch = s[i];

		switch (ch) {
		case '+': case '-':
		case '*': case '/':
			while (!stack.isEmpty() && priority(stack.peek()) >= p) {
				sb.append(stack.pop());
			}
			stack.push(ch);
			break;
		case '(':
			stack.push(ch);
			break;
		case ')':
			while (!stack.isEmpty() && stack.peek() != '(') {
				sb.append(stack.pop());
			}
			stack.pop();
			break;
		default:
			sb.append(ch);
		}
	}

	while (!stack.isEmpty()) sb.append(stack.pop());

	System.out.println(sb.toString());
}

public static int priority(char ch) {
	switch (ch) {
	case '*': case '/':
		return 2;
	case '+': case '-':
		return 1;
	case '(': case ')':
		return 0;
	}
	return -1;
}
}
