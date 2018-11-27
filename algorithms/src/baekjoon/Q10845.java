package baekjoon;

// https://www.acmicpc.net/problem/10845

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10845 {
	static class Queue { // front가 가리키는 공간을 비워두는 Circular queue의 구현
		int[] queue;
		int queue_size;
		int front = 0, rear = 0;
		int counter = 0;

		public Queue() {
		}

		public Queue(int initial_size) {
			queue = new int[initial_size];
			queue_size = initial_size;
		}

		void resize(int new_queue_length) {
			int[] tmp = new int[new_queue_length];
			for (int i = 0; i < counter + 1; i++) { // 빈칸부터 내용물이 들어있는 마지막 칸까지 복사하기 위함
				tmp[i] = queue[(front + i) % queue.length]; // 여기가 핵심, 크기가 재설정 된 큐에 내용물을 복사해 넣는다.
			}
			front = 0; // 포인터 재설정
			rear = counter; // 포인터 재설정
			queue = tmp;
			queue_size = new_queue_length;
		}

		void push(int number) {
			if ((rear + 1) % queue.length == front) { // 만약 큐가 다 찬 상태이면
				resize(queue.length * 2); // 큐의 길이를 2배로 해준다
			}
			rear = (rear + 1) % queue.length;
			queue[rear % queue.length] = number;
			counter++;
		}

		int empty() { // 원형 큐 구조에서 rear==front인 경우 비어있음을 나타내는 모델을 채택하여 구현하였기 때문에 이 경우 큐가 비어있음을 나타낸다
			if (rear == front)
				return 1;
			else
				return 0;
		}

		int size() { // 큐 내부의 원소의 갯수를 반환한다
			return counter;
		}

		int pop() {
			if (empty() == 1) {
				return -1;
			}
			int result = queue[(front + 1) % queue.length];
			front = (front + 1) % queue.length;
			queue[(front) % queue.length] = Integer.MIN_VALUE;
			counter--;

			if (counter > 0 && counter == (queue.length / 4)) { // 큐에 담겨 있는 원소가 있고, 해당 원소의 갯수가 큐의 크기의 1/4일때
				resize(queue.length / 2); // 큐의 크기를 재설정한다(공간 낭비의 최소화)
			}
			return result;
		}

		int front() { // 큐 구조에서 가장 앞에 있는 원소를 반환한다
			if (empty() == 1)
				return -1;
			else
				return queue[(front + 1) % queue.length]; // 큐의 길이에 신경써서 모듈로 연산으로 처리하는 것을 잊지 않는다.
		}

		int back() { // 큐 구조에서 가장 뒤에 있는 원소를 반환한다
			if (empty() == 1)
				return -1;
			else
				return queue[(rear) % queue.length];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_of_ins = 0;

		String ins = new String();
		StringTokenizer st;

		num_of_ins = Integer.parseInt(sc.nextLine());

		Queue q = new Queue(5);

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
			} else if (ins.equals("front")) {
				System.out.println(q.front());
			} else if (ins.equals("back")) {
				System.out.println(q.back());
			}
		}

		sc.close();
	}
}