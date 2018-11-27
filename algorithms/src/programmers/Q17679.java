package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17679

public class Q17679 {
	static boolean flag = true;
	
	public static void main(String[] args) {
		int m = 6; // height
		int n = 6; // width
		
//		String[] board = {
//			"CCBDE", 
//			"AAADE", 
//			"AAABF", 
//			"CCBBF"
//		};
		
		String[] board = {
			"TTTANT", 
			"RRFACC", 
			"RRRFCC", 
			"TRRRAA", 
			"TTMMMF", 
			"TMMTTJ"
		};
		
		char[][] boardInfo = new char[m][n];
		int[][] checkerBoard = new int[m][n];
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) { 
				boardInfo[i][j] = board[i].charAt(j);
			}
		}
		
		while(flag) {
			checkerBoard = check(boardInfo);
			boardInfo = remove(boardInfo, checkerBoard);
			boardInfo = pushDown(boardInfo);
			checkerBoard = new int[m][n];
		}
		
		System.out.println(countRemoval(boardInfo));
	}
	
	public static int[][] check(char[][] boardInfo){
		
		int[][] checkerBoard = new int[boardInfo.length][boardInfo[0].length];
		boolean miniFlag = false;
		
		for (int i=0; i<boardInfo.length; i++) {
			for (int j=0; j<boardInfo[0].length; j++) {
				
				char target = boardInfo[i][j];
				
				boolean cond1 = j+1 < boardInfo[0].length && target == boardInfo[i][j+1] && target != '0';
				boolean cond2 = i+1 < boardInfo.length && target == boardInfo[i+1][j] && target != '0';
				boolean cond3 = i+1 < boardInfo.length && j+1 < boardInfo[0].length && target == boardInfo[i+1][j+1] && target != '0';
				
				if (cond1 && cond2 && cond3) {
					checkerBoard[i][j] = 1;
					checkerBoard[i][j+1] = 1;
					checkerBoard[i+1][j] = 1;
					checkerBoard[i+1][j+1] = 1;
					miniFlag = true;
				}
				
			}
		}
		
		if(!miniFlag) {
			flag = false;
		}
		
		return checkerBoard;
	}
	
	public static char[][] remove(char[][] boardInfo, int[][] checkerBoard) {
		
		for (int i=0; i<boardInfo.length; i++) {
			for (int j=0; j<boardInfo[0].length; j++) {
				if (checkerBoard[i][j] == 1) {
					boardInfo[i][j] = '0';
				}
			}
		}
		
		return boardInfo;
	}
	
	public static char[][] pushDown(char[][] boardInfo){
		for (int j=0; j<boardInfo[0].length; j++) {
			for (int i=boardInfo.length-1; i>=0; i--) {
				for (int k=i; k<boardInfo.length; k++) {
					boolean cond = k+1 < boardInfo.length && boardInfo[k+1][j] == '0' && boardInfo[k][j] != '0';

					if (cond) {
						char tmp = boardInfo[k][j];
						boardInfo[k][j] = '0';
						boardInfo[k+1][j] = tmp;
					}
				}
			}
		}
		
		return boardInfo;
	}
	
	public static int countRemoval(char[][] boardInfo) {
		int count = 0;
		
		for (int i=0; i<boardInfo.length; i++) {
			for (int j=0; j<boardInfo[0].length; j++) {
				if (boardInfo[i][j] == '0') {
					count++;
				}
			}
		}
		
		return count;
	}
	
}
