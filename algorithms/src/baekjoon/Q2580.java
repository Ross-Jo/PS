package baekjoon;

// https://www.acmicpc.net/problem/2580 
// 시간 초과 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Q2580 {
	static int[][] board = new int[9][9];
	static int[] xs = {0, -1, -1, -1, 0, 1, 1, 1, 0};
	static int[] ys = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
	static int[] cx = {1, 1, 1, 4, 4, 4, 7 ,7, 7};
	static int[] cy = {1, 4, 7, 1, 4, 7, 1, 4, 7};
	
	static void fill(int l) throws Exception {
		if (l==0) {
			throw new Exception();
		}
		
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (board[i][j] != 0) continue;
				
				for (int t=1; t<=9; t++) {
					boolean flag = false;
					
					for (int c=0; c<9; c++) {
						if(board[i][c] == t) {
							flag = true;
							break;
						}
					}
					
					if (flag) continue;
					
					for (int r=0; r<9; r++) {
						if(board[r][j] == t) {
							flag = true;
							break;
						}
					}
					
					if (flag) continue;
					
					label:
					for (int cc=0; cc<9; cc++) { // center change
						int nx = i + xs[cc];
						int ny = j + ys[cc];
						if (0<=nx && nx<9 && 0<=ny && ny<9) {
							for (int wc=0; wc<9; wc++) { // which center
								if (nx == cx[wc] && ny == cy[wc]) {
									for (int n=0; n<9; n++) {
										if (board[cx[wc]+xs[n]][cy[wc]+ys[n]] == t) {
											flag = true;
											break label;
										};
									}
								}
							}
						}
					}
					
					if (flag) continue;
					
					board[i][j] = t;
					fill(l-1);
					board[i][j] = 0;
				}
				
			}
		}
	}
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i=0; i<9; i++) board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int l = 0;
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (board[i][j]==0) l++;
			}
		}
		try {
			fill(l);
		}
		catch(Exception e) {
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
