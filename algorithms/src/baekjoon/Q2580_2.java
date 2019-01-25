package baekjoon;

// https://www.acmicpc.net/problem/2580 
// 참고 : https://www.geeksforgeeks.org/sudoku-backtracking-7/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Q2580_2 {
	static int[][] board = new int[9][9];
	
	public static boolean isSafe(int row, int col, int num) {
		for (int d=0; d<board.length; d++) if (board[row][d] == num) return false;
		for (int r=0; r<board.length; r++) if (board[r][col] == num) return false;
		
		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;
		
		// 그리드 확인 방법 
		for (int r=boxRowStart; r<boxRowStart+sqrt; r++) {
			for (int d=boxColStart; d<boxColStart+sqrt; d++) {
				if (board[r][d]==num) return false;
			}
		}
		
		return true;
	}
	
	public static void solveSudoku() throws Exception {
		int row = -1;
		int col = -1;
		
		label:
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if(board[i][j] == 0) {
					row = i;
					col = j;
					break label;
				}
			}
		}
		
		if (row == -1) throw new Exception();
		
		for (int num=1; num<=9; num++) {
			if (isSafe(row, col, num)) {
				board[row][col] = num;
				solveSudoku();
				board[row][col] = 0;
			}
		}
	}
	
	public static void main(String args[])  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i=0; i<9; i++) board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		try {
			solveSudoku();
		} catch(Exception e) {
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					bw.write(Integer.toString(board[i][j]));
					bw.write(" ");
				}
				bw.newLine();
			}
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
