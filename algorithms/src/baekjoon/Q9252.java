package baekjoon;

// https://www.acmicpc.net/problem/9252

import java.util.ArrayList;
import java.util.Scanner;

/*
 * public class Main { public static void main(String[] args) { Scanner sc = new
 * Scanner(System.in);
 * 
 * char[] line1 = sc.nextLine().toCharArray(); char[] line2 =
 * sc.nextLine().toCharArray(); char[] result = null;
 * 
 * int count = 0; int max_length = 0;
 * 
 * // 삼중 for문이라 효율성이 많이 떨어짐. 시간 복잡도가 대략 O(n^3) - 이 풀이법은 틀렸음 for(int k=0;
 * k<line1.length; k++){ char[] temp = new char[1000]; int temp_index = 0;
 * for(int i=k; i<line1.length; i++){ for(int j=temp_index; j<line2.length;
 * j++){ if(line1[i]==line2[j]){ count++; temp[count-1] = line1[i]; temp_index =
 * j; break; } } } if(count > max_length){ result = temp; max_length = count; }
 * count = 0; }
 * 
 * System.out.println(max_length); for(int i=0; i<result.length; i++){
 * System.out.print(result[i]); }
 * 
 * sc.close(); } }
 */

//LCS(Longest Common Subsequence)
public class Q9252 {

	public static ArrayList<Character> result;
	public static int[][] cache;

	public static int LCS(char[] line1, char[] line2) {
		cache = new int[line1.length + 1][line2.length + 1];
		for (int i = 1; i <= line1.length; i++) {
			for (int j = 1; j <= line2.length; j++) {
				if (line1[i - 1] == line2[j - 1]) {
					cache[i][j] = cache[i - 1][j - 1] + 1;
				} else {
					cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
				}
			}
		}
		return cache[line1.length][line2.length];
	}

	public static void backTracking(int m, int n, char[] line1) {
		if (m == 0 || n == 0)
			return;
		if (cache[m][n] > cache[m - 1][n - 1] && cache[m][n] > cache[m - 1][n] && cache[m][n] > cache[m][n - 1]) {
			result.add(line1[m - 1]);
			backTracking(m - 1, n - 1, line1);
		} else if (cache[m][n] > cache[m - 1][n] && cache[m][n] == cache[m][n - 1])
			backTracking(m, n - 1, line1);
		else
			backTracking(m - 1, n, line1);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		char[] line1 = sc.nextLine().toCharArray();
		char[] line2 = sc.nextLine().toCharArray();

		System.out.println(LCS(line1, line2));

		result = new ArrayList<Character>();
		backTracking(line1.length, line2.length, line1);

		for (int i = result.size() - 1; i >= 0; i--) {
			System.out.print(result.get(i));
		}

		sc.close();
	}
}