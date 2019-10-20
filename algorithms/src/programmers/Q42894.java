package programmers;

// 참고 : https://www.youtube.com/watch?v=1nm7s8-0iEA&t=7s

public class Q42894 {
	static int N, Board[][];

	static boolean canFill(int row, int col) {
		for (int i = 0; i < row; ++i) if (Board[i][col] != 0) return false;
		return true;
	}

	static boolean find(int row, int col, int h, int w) {
		int emptyCnt = 0;
		int lastValue = -1;
		for (int r = row; r < row + h; ++r) {
			for (int c = col; c < col + w; ++c) {
				if (Board[r][c] == 0) {
					if (!canFill(r, c)) return false;
					if (++emptyCnt > 2) return false;
				} else {
					if (lastValue != -1 && lastValue != Board[r][c]) return false;
					lastValue = Board[r][c];
				}
			}
		}

		for (int r = row; r < row + h; ++r) {
			for (int c = col; c < col + w; ++c) {
				Board[r][c] = 0;
			}
		}
		return true;
	}

	static int solution(int[][] board) {
		Board = board;
		N = board.length;
		int ans = 0;
		int cnt;

		do {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i <= N - 2 && j <= N - 3 && find(i, j, 2, 3)) {
						cnt++;
					} else if (i <= N - 3 && j <= N - 2 && find(i, j, 3, 2)) {
						cnt++;
					}
				}
			}
			ans += cnt;
		} while (cnt != 0);
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 8, 8, 8, 0, 0, 0, 0 }, { 7, 0, 0, 8, 0, 6, 0, 0, 0, 0 },
				{ 7, 7, 5, 6, 6, 6, 0, 1, 0, 0 }, { 7, 5, 5, 3, 3, 3, 1, 1, 0, 0 }, { 0, 4, 5, 1, 3, 2, 9, 1, 0, 0 },
				{ 4, 4, 4, 1, 0, 2, 9, 9, 0, 0 }, { 0, 0, 1, 1, 2, 2, 9, 0, 0, 0 } }));
	}

}
