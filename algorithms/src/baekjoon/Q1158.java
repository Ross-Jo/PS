package baekjoon;

// https://www.acmicpc.net/problem/1158

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Q1158 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] ans = new int[N];
		int index = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i=0; i<N; i++) q.add(i+1);
		
		while(!q.isEmpty()) {
			int counter = 0;
			while(++counter <= M) {
				if (counter == M) {
					ans[index++] = q.poll();
				} else {
					int element = q.poll();
					q.add(element);
				}
			}
		}
		
		sb.append("<");
		for (int i=0; i<N; i++) {
			sb.append(ans[i]);
			if(i<N-1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb.toString());
		
		sc.close();
	}
}

// 아래의 코드가 깔끔한데 참고할 수 있도록 할 것
//public static void main(String[] args) throws IOException {
//	BufferedReader sRead = new BufferedReader(new InputStreamReader(System.in));
//	BufferedWriter sWrite = new BufferedWriter(new OutputStreamWriter(System.out));
//	String num = sRead.readLine();
//	String arr[] = num.split(" ");
//	ArrayList<Integer> jo = new ArrayList<Integer>();
//	int number = Integer.parseInt(arr[0]);
//	int length = Integer.parseInt(arr[1]);
//	int counter = -1;
//	for (int i = 1; i <= number; i++) {
//		jo.add(i);
//	}
//	sWrite.write("<");
//	for (int i = 1; i < number; i++) {
//		counter += length;
//		counter %= jo.size();
//		sWrite.write(Integer.toString(jo.remove(counter)) + ", ");
//		counter--;
//	}
//	sWrite.write(Integer.toString(jo.get(0)) + ">");
//	sWrite.flush();
//	sWrite.close();
//}