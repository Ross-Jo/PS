package baekjoon;

// https://www.acmicpc.net/problem/2448

import java.util.Scanner;

//N은 항상 3*2^k (K<=10) - 다시풀기
//public class Main {
//	
//	public static StringBuffer makeWhiteSpace(int space){
//		StringBuffer sb = new StringBuffer();
//		for(int i=0; i<space; i++){
//			sb.append(" ");
//		}
//		return sb;
//	}
//	
//	public static StringBuffer makeString(StringBuffer ws, String string){
//		StringBuffer sb = new StringBuffer();
//		sb.append(ws).append(string).append(ws);
//		return sb;
//	}
//	
//	public static void printTriangle(StringBuffer ws){
//		System.out.println(makeString(ws, "  *  "));
//		System.out.println(makeString(ws, " * * "));
//		System.out.println(makeString(ws, "*****"));
//	}
//	
//	public static void printStar(int N){
//		StringBuffer ws = new StringBuffer();
//		printStar(N, ws);
//	}
//	
//	public static void printStar(int N, StringBuffer ws){
//		if(N<3) return;
//		
//		ws.append(makeWhiteSpace(N/2));
//		printStar(N/2, ws);
//		
//		printTriangle(ws);
//		
//		System.out.println(makeString(ws, "  *  ").append(" ").append("  *  "));
//		System.out.println(makeString(ws, " * * ").append(" ").append(" * * "));
//		System.out.println(makeString(ws, "*****").append(" ").append("*****"));
//		
//	}
//	
//	public static void main(String args[]){
//		Scanner sc = new Scanner(System.in);
//		
//		int N = sc.nextInt();
//		
//		printStar(N);
//
//		sc.close();
//	}
//}

//참고코드
public class Q2448 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int k = (int) (Math.log(N / 3) / Math.log(2)) + 1;
		String[] arr = new String[N];

		arr[0] = "  *  ";
		arr[1] = " * * ";
		arr[2] = "*****";
		int copyHeight = 3;

		for (int i = 1; i < k; i++) {
			for (int j = 0; j < copyHeight; j++) {
				arr[copyHeight + j] = arr[j] + " " + arr[j];
				for (int m = 0; m < copyHeight / 3; m++) {
					arr[j] = "   " + arr[j] + "   ";
				}
			}
			copyHeight *= 2;
		}

		for (int i = 0; i < copyHeight; i++) {
			System.out.println(arr[i]);
		}

		sc.close();
	}
}