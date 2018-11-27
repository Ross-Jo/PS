package baekjoon;

// https://www.acmicpc.net/problem/10828

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10828 {
	static class Stack { // array를 이용한 스택 구현
		int[] stack;
		int stack_size = 0;
		int counter = 0;
		int top = -1;

		public Stack() {
		}

		public Stack(int initial_size) {
			stack = new int[initial_size];
			stack_size = initial_size;
		}

		void resize(int new_stack_length) {
			int[] tmp = new int[new_stack_length];
			for (int i = 0; i < counter; i++) {
				tmp[i] = stack[i];
			}
			top = counter - 1;
			stack = tmp;
			stack_size = new_stack_length;
		}

		void push(int number) {
			if (top == stack.length - 1) {
				resize(stack.length * 2);
			}
			top++;
			stack[top] = number;
			counter++;
		}

		int empty() {
			if (counter == 0)
				return 1;
			else
				return 0;
		}

		int size() {
			return counter;
		}

		int pop() {
			if (empty() == 1) {
				return -1;
			}
			int result = stack[top];
			stack[top] = Integer.MIN_VALUE;
			top--;
			counter--;
			if (counter > 0 && counter == (stack.length / 4)) {
				resize(stack.length / 2);
			}
			return result;
		}

		int top() {
			if (empty() == 1)
				return -1;
			else
				return stack[top];
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num_of_ins = 0;

		String ins = new String();
		StringTokenizer st;

		num_of_ins = Integer.parseInt(sc.nextLine());

		Stack q = new Stack(5);

		for (int i = 0; i < num_of_ins; i++) {
			ins = sc.nextLine();
			st = new StringTokenizer(ins, " ");
			if (st.nextToken().equals("push")) {
				q.push(Integer.parseInt(st.nextToken()));
			} else if (ins.equals("pop")) {
				System.out.println(q.pop());
			} else if (ins.equals("size")) {
				System.out.println(q.size());
			} else if (ins.equals("empty")) {
				System.out.println(q.empty());
			} else if (ins.equals("top")) {
				System.out.println(q.top());
			}
		}

		sc.close();
	}
}
