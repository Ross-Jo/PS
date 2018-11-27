package baekjoon;

// https://www.acmicpc.net/problem/2210
	
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q2210 {
	static int[][] map = new int[5][5];
	static Set<String> s = new HashSet<>();
	static int[] xs = {0, -1, 0, 1};
	static int[] ys = {-1, 0, 1, 0};
	
	static void solve(int x, int y, int c, char[] nums) {
		if(c==0) {
			s.add(new String(nums));
			return;
		}
		nums[-(c-6)] = Character.forDigit(map[x][y], 10);
		
		for (int i=0; i<4; i++) {
			int nx = x + xs[i];
			int ny = y + ys[i];
			if ((nx >=0 && nx < 5) && (ny >= 0 && ny < 5)) {
				solve(nx, ny, c - 1, nums);
			}
		}
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				solve(i, j, 6, new char[6]);
			}
		}
		System.out.println(s.size());
		sc.close();
	}
}
