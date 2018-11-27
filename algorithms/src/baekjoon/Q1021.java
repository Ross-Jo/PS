package baekjoon;

// https://www.acmicpc.net/problem/1021

import java.util.LinkedList;
import java.util.Scanner;

// 아...문제를 제대로 이해하자...이게 1번 연산의 적용이 막 되는게 아님...
// 그리고 결과적으로 구현도 오류 스파게티 코드 같이 됨.
//import java.util.Deque;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Scanner;
//import java.util.stream.IntStream;
//
//class number{
//	int num;
//	boolean check;
//	public number(int num, boolean check){
//		this.num = num;
//		this.check = check;
//	}
//}
//
//class newDeque{
//	int N;
//	int M;
//	int[] loc;
//	int ans = 0;
//	Deque<number> d = new LinkedList<number>();
//	
//	public newDeque(int N, int M, int[] loc){
//		this.N = N;
//		this.M = M;
//		this.loc = loc;
//		for(int i=1; i<=N; i++){
//			int tmp = i;
//			if(IntStream.of(loc).anyMatch(k->k==tmp)){ // 자바 람다식
//				d.addLast(new number(i, true));
//			}
//			else{
//				d.addLast(new number(i, false));
//			}
//		}
////		System.out.print("생성자: ");print();
//	}
//	
//	public void print(){
//		Iterator<number> it = d.iterator();
//		while(it.hasNext()){
//			number tmp = it.next();
//			System.out.print(tmp.num+" ");//+tmp.check+" ");
//		}
//		System.out.println();
//	}
//	
//	public int method1(){
//		return d.removeFirst().num;
//	}
//	
//	public void method2(){
//		number tmp = d.removeFirst();
//		d.addLast(tmp);
//	}
//	
//	public void method3(){
//		number tmp = d.removeLast();
//		d.addFirst(tmp);
//	}
//	
//	public int findAns(){
//		int i = 0;
//		while(true){
//			int target = loc[i];
//			
//			
//			number comparator = d.peekFirst();
//			
////			System.out.print("최초 순환: ");print();
////			System.out.println();
////			System.out.println("target: "+target);
//			
//			if(target==comparator.num){
////				System.out.println("hit-A");
//				method1(); i++;
////				print();
//			}
//			else{
//				if(comparator.check){
//					
//					int cum = 0;
//					int count = 0;
//					Iterator<number> it = d.iterator();
//					while(it.hasNext()){
//						number tmp = (number) it.next();
//						count++;
//						if(tmp.check==true) cum++;
//						if(tmp.num==target) break;
//					}
//					
//					int cum_l = d.size()-count+1;
//					cum -= 1;
//					
//					if(cum>=cum_l){
//						do{
//							if(d.peekFirst().check==true){
//								method3();
////								print();
//								ans++;
//							}
//							else {
////								System.out.println("hit-B");
//								method1(); 
////								print();
//							}
//						}
//						while(d.peekFirst().num!=target); // find
//						method1(); i++;
//					}
//					else{
//						do{
//							method2();
////							print();
//							ans++;
////							System.out.println("첫부분 : " + d.peekFirst().num);
//						}
//						while(d.peekFirst().num!=target);
//						method1(); i++;
//					}
//					
//				}
//				else{
////					System.out.println("hit-C");
//					do{
//						method1();
//					}
//					while(d.peekFirst().check!=true);
////					print();
//				}
//			}
//			if(i==M-1) break;
//		}
//		return ans;
//	}
//}
//
//public class Main {
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt(); // N<=50, 자연수, 큐의 크기
//		int M = sc.nextInt(); // M<=N, 자연수, 뽑아내려고 하는 수의 갯수
//		
//		int[] loc = new int[M];
//		for(int i=0; i<M; i++){
//			loc[i] = sc.nextInt(); // 위치  1<=위치값<=N, 자연수
//		}
//		
//		newDeque d = new newDeque(N, M, loc);
//		System.out.println(d.findAns());
//		
//		sc.close();
//	}
//}


// 참고 : http://mygumi.tistory.com/59

class CircleQueue {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private int count = 0;
	private int[] loc;

		CircleQueue(int size, int[] loc) {
			for (int i = 1; i <= size; i++) {
				list.add(i);
			}
			this.loc = loc;
			start();
		}

		private void start() { 
			int length = loc.length; 
			for (int i = 0; i < length; i++) { 
				int n = loc[i]; 
				operate(n); // 여기 코드에 주목하자 
				} 
		}

		private void operate(int num) { 
			while (true) { 
				int pos = list.indexOf(num); 
				int size = list.size(); 
				int left = pos; 
				int right = size - pos - 1; 
				
				if (left == 0) { 
					list.remove(pos); 
					break; 
				} 
				
				if (left <= right) { 
					//2번 연산 왼쪽으로 한칸 이동 
					list.addLast(list.removeFirst()); 
					++count; 
				} else { 
					//3번 연산 오른쪽으로 한칸 이동 
					list.addFirst(list.removeLast()); 
					++count; 
				} 
			} 
		} 
	
		public int getCount() { 
			return count; 
		} 
	}


public class Q1021 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N<=50, 자연수, 큐의 크기
		int M = sc.nextInt(); // M<=N, 자연수, 뽑아내려고 하는 수의 갯수
		
		int[] loc = new int[M];
		for(int i=0; i<M; i++){
			loc[i] = sc.nextInt(); // 위치  1<=위치값<=N, 자연수
		}		
		
		CircleQueue cq = new CircleQueue(N, loc);
		System.out.println(cq.getCount());
		
		sc.close();
	}
}