package baekjoon;

// https://www.acmicpc.net/problem/1427

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1427 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		Integer[] num = new Integer[word.length()];
		for(int i=0; i<word.length(); i++){
			num[i] = word.charAt(i)-48;
		}
		
		Arrays.sort(num, new Comparator<Integer>(){ // 배열에 들어있는 것과, 비교하고자 하는 것들의 타입이 같아야 함.
			@Override
			public int compare(Integer A, Integer B){
				return -Integer.compare(A, B); // 정렬 순서를 반대로 설정
			}
		});
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
		
		sc.close();
	}
}