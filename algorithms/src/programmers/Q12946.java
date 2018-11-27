package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12946

import java.util.ArrayList;

public class Q12946 {
	ArrayList<int[]> al = new ArrayList<int[]>();
	
	public static void main(String args[]) {
		Q12946 q = new Q12946();
		int[][] ret = q.solution(3);
		System.out.println(ret);
	}

	public int[][] solution(int n) {
		hanoi(n, 1, 3);
		return al.toArray(new int[0][0]); // ArrayList<int[]> 의 2차원 Array화
	}
	
	public int hanoi(int num_of_plate, int start, int end) {
		if(num_of_plate == 1) {
			al.add(new int[]{start, end});
			return 1;
		}
		int bridge = 6-start-end;
		return hanoi(num_of_plate - 1, start, bridge) + hanoi(1, start, end) + hanoi(num_of_plate - 1, bridge, end);
	}
	


}

//public int[][] solution(int n) {
//	List<int[]> moveList = new ArrayList<>();
//	move(moveList, n, 1, 2, 3);
//	return moveList.toArray(new int[moveList.size()][]);
//}
//
//void move(List<int[]> moveList, int n, int from, int by, int to) {
//	if (n == 1)
//		moveList.add(new int[] { from, to });
//	else {
//		move(moveList, n - 1, from, to, by);
//		moveList.add(new int[] { from, to });
//		move(moveList, n - 1, by, from, to);
//	}
//}

//private int[][] answer;
//private int i = 0;
//
//public int[][] solution(int n) {
//	answer = new int[(int) Math.pow(2, n) - 1][];
//	move(1, 3, 2, n);
//	return answer;
//}
//
//private void move(int si, int di, int ti, int amount) {
//    if (amount > 1) {
//        move(si, ti, di, amount-1);
//        move(si, di, ti, 1);
//        move(ti, di, si, amount-1);
//    } else {
//        answer[i++] = new int[] {si, di};
//    }
//}
