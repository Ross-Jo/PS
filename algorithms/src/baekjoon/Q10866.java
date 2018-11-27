package baekjoon;

// https://www.acmicpc.net/problem/10866

import java.util.Scanner;

//주어지는 명령의 수 N(1<=N<=10,000)
//명령에서 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같음
//링크드리스트로 덱 구현

class DequeNode{
	int number = 0;
	DequeNode left = null;
	DequeNode right = null;
	
	public DequeNode(int number){
		this.number = number;
	}
	
	public DequeNode(int number, DequeNode left, DequeNode right){
		this.number = number;
		this.left = left;
		this.right = right;
	}
}

class Deque{
	DequeNode head = null;
	DequeNode tail = null;
	int size = 0;
	public Deque(){
		head = new DequeNode(-1); // head임을 나타내기 위한 -1
		tail = new DequeNode(-2); // tail임을 나타내기 위한 -2
		
		head.right = tail;
		tail.left = head;
	}
	
	public void push_front(int X){
		DequeNode newNode = new DequeNode(X, head, head.right);
		head.right.left = newNode;
		head.right = newNode;
		size++;
	}
	
	public void push_back(int X){
		DequeNode newNode = new DequeNode(X, tail.left, tail);
		tail.left.right = newNode;
		tail.left = newNode;
		size++;
	}
	
	public int pop_front(){ // 연결 부분 주의해서 작성할 것
		if(size==0) return -1;
		else {
			DequeNode tmp = head.right;
			tmp.right.left = head;
			head.right = tmp.right;
			size--;
			return tmp.number;
		}
	}
	
	public int pop_back(){ // 연결 부분 주의해서 작성할 것
		if(size==0) return -1;
		else {
			DequeNode tmp = tail.left;
			tmp.left.right = tail;
			tail.left = tmp.left;
			size--;
			return tmp.number;
		}
	}
	
	public int size(){
		return size;
	}
	
	public int empty(){
		if(size==0) return 1;
		else return 0;
	}
	
	public int front(){
		if(size==0) return -1;
		else{
			return head.right.number;
		}
	}
	
	public int back(){
		if(size==0) return -1;
		else{
			return tail.left.number;
		}
	}
	
	public void printD(){
		DequeNode pointer = head;
		while(pointer.right!=null){
			System.out.print(pointer.number+" ");
			pointer = pointer.right;
		}
		System.out.print(pointer.number);
	}
}

public class Q10866 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Deque d = new Deque();
		
		for(int i=0; i<N; i++){
			String order = sc.next();
			
			if(order.equals("push_front")){
				int X = sc.nextInt();
				d.push_front(X);
			}
			else if(order.equals("push_back")){
				int X = sc.nextInt();
				d.push_back(X);
			}
			else if(order.equals("pop_front")){
				System.out.println(d.pop_front());
			}
			else if(order.equals("pop_back")){
				System.out.println(d.pop_back());
			}
			else if(order.equals("size")){
				System.out.println(d.size());
			}
			else if(order.equals("empty")){
				System.out.println(d.empty());
			}
			else if(order.equals("front")){
				System.out.println(d.front());
			}
			else if(order.equals("back")){
				System.out.println(d.back());
			}
			
//			System.out.print("덱을 출력합니다: "); 
//			d.printD();
//			System.out.println();
			
		}
		sc.close();
	}
}