package baekjoon;

// https://www.acmicpc.net/problem/9663

import java.util.Scanner;

//참고: http://hsp1116.tistory.com/17
public class Q9663 {
	static int N;
	static int count = 0;
	int[] coordinate = new int[15]; // 행렬 표현의 테크닉 : index - 행, value - 열 
	
	boolean check(int currentRow) {
		for (int i=1; i<currentRow; i++) { // 현재 행 바로 직전까지의 행들을 확인해서 과연 이 행에 말을 놓을 수 있는지 체크 
			// 열 겹침 및 대각 겹침 확인  
			if (coordinate[i] == coordinate[currentRow] || currentRow - i == Math.abs(coordinate[currentRow] - coordinate[i])) return false;
		}
		return true;
	}
	
	void nQueen(int currentRow) {
		if (currentRow == N) {
			count++;
			return;
		}
		for (int i=1; i<=N; i++) {
			coordinate[currentRow + 1] = i; // 현재 행의 열에 차례로 말들을 놔 보고 
			if(check(currentRow + 1)) nQueen(currentRow + 1); // 그렇게 놓는 것이 가능한 경우, 행을 내리면서 재귀호출 
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Q9663 q = new Q9663();
		N = sc.nextInt();
		
		q.nQueen(0);
		System.out.println(count);
		
		sc.close();
	}
}