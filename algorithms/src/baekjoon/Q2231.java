package baekjoon;

// https://www.acmicpc.net/problem/2231

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1<=N<=1,000,000
public class Q2231 {
//	static int MAX = 1000000;
	public static int generaterCheck(int N){
		int[] numbers = new int[N+1];
		for(int i=1; i<=N; i++){
			generateNum(i, numbers);
		}
//		for(int i=0; i<=N; i++){
//			System.out.print(numbers[i]+" ");
//		}
//		System.out.println();
		return numbers[N];
	}
	
	public static void generateNum(int startIndex, int[] array){
		int currentIndex = startIndex;
//		while(currentIndex<array.length){
			int generator = currentIndex; int nextIndex = 0;
			
			nextIndex += generator;
			while(generator/10!=0){
				nextIndex += generator%10;
				generator = generator/10;
			}
			nextIndex += generator; // 남은 한자리수 더하기
			
			if(nextIndex<array.length && array[nextIndex]==0) array[nextIndex] = startIndex;
			
//			currentIndex = nextIndex; // loop을 위한 구문
//		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			int N = Integer.parseInt(br.readLine());
			System.out.println(generaterCheck(N));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
