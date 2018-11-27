package baekjoon;

// https://www.acmicpc.net/problem/10451

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열의 크기 N(2<=N<=1000)
public class Q10451 {
	public static int findTarget(int[] specific_array) {
		for (int i = 0; i <= specific_array.length; ++i) {
			if (specific_array[i] == 1)
				return i;
		}
		return -1;
	}

	public static void loop(int[][] original, int[][] check, int i, int j) {
		if (original[i][j] == 1 && check[i][j] == 0) {
			check[i][j] = 1;
			i = j;
			j = findTarget(original[i]);
			loop(original, check, i, j);
		}
	}

	public static int findCycle(int size, int[] array) {
		int[][] original = new int[1001][1001];
		int[][] check = new int[1001][1001]; // 1-마킹, 0-비었음
		int countGroups = 0;

		for (int i = 1; i <= size; ++i) {
			original[i][array[i]] = 1;
		}

		for (int i = 1; i <= size; ++i) {
			for (int j = 1; j <= size; ++j) {
				if (original[i][j] == 1 && check[i][j] == 0) {
					loop(original, check, i, j);
					countGroups++;
				}
			}
		}
		return countGroups;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < T; ++i) {

				int size = Integer.parseInt(br.readLine());
				int[] array = new int[size + 1];
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= size; ++j) {
					array[j] = Integer.parseInt(st.nextToken());
				}
				System.out.println(findCycle(size, array));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// ID : cjypassion93 참고. 보다 효율적인 코드니 참고토록 할 것
//import java.util.*;
//import java.io.*;
//
//class Main {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int T = Integer.parseInt(br.readLine());
//		while (T > 0) {
//			int N = Integer.parseInt(br.readLine());
//			int[] map = new int[N];
//			String[] input = br.readLine().split(" ");
//			for (int i = 0; i < N; i++) {
//				map[i] = Integer.parseInt(input[i]) - 1;
//			}
//			bw.write(compute(map) + "\n");
//			T--;
//		}
//		bw.flush();
//	}
//
//	public static int compute(int[] map) {
//		int[] total = new int[map.length];
//		int retVal = 0;
//		for (int i = 0; i < map.length; i++) {
//			int j = map[i];
//			if (total[j] == 0) {
//				retVal++;
//				while (total[j] == 0) {
//					total[j] = retVal;
//					j = map[j];
//				}
//			}
//		}
//		return retVal;
//	}
//}
