package baekjoon;

// https://www.acmicpc.net/problem/1193

import java.util.Scanner;

//1<=X<=10,000,000
public class Q1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		
		int[] memo = new int[10000000];
		int count = 1;
		while(true){
			memo[count] = count + memo[count-1];
			if(X<=memo[count]) break;
			count++;
		}
		
		if(count%2==0){
			System.out.println((X-memo[count-1])+"/"+(count+1-(X-memo[count-1])));
		}
		else{
			System.out.println((count+1-(X-memo[count-1]))+"/"+(X-memo[count-1]));
		}	
		sc.close();
	}
}