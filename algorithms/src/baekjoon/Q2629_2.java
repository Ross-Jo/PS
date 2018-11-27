package baekjoon;

// https://www.acmicpc.net/problem/2629

import java.util.Scanner;

//참고 : http://jaimemin.tistory.com/497
//아래의 코드는 런타임 에러 발생

public class Q2629_2 {
	static int weightNum, marbleNum;
	static int[] weight = new int[30+1]; // 와...씨발...자바에서는 인덱스가 배열을 넘어가는것을 항상 조심하자. 그런데 C++ 코드는 왜 에러가 안나냐?  
	static int[] marble = new int[7+1];
	static int[][] cache = new int[30+1][30*500+1]; // 추의 갯수, 추의 갯수로 만들 수 있는 무게 
	
	static void preCalculate(int currentWeightNum, int currentWeight) {
		if (currentWeightNum > weightNum) return;
		int result = cache[currentWeightNum][currentWeight];
		if (result != 0) return;
		
		cache[currentWeightNum][currentWeight] = 1;
		
		preCalculate(currentWeightNum + 1, currentWeight + weight[currentWeightNum]);
		preCalculate(currentWeightNum + 1, currentWeight);
		preCalculate(currentWeightNum + 1, Math.abs(currentWeight - weight[currentWeightNum]));
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		weightNum = sc.nextInt();
		for (int i=0; i<weightNum; i++) weight[i] = sc.nextInt();
		
		marbleNum = sc.nextInt();
		for (int i=0; i<marbleNum; i++) marble[i] = sc.nextInt();

		preCalculate(0,0);
		
		for (int i=0; i<marbleNum; i++) {
			System.out.print(marble[i] >  30 * 500 ? "N " : cache[weightNum][marble[i]] == 1 ? "Y ": "N "); 
		}
		
		sc.close();
	}
}