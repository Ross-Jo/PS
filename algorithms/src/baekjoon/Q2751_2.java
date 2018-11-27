package baekjoon;

// https://www.acmicpc.net/problem/2751

import java.util.Scanner;

// 1<=N<=1,000,000, 제한시간 : 1초

public class Q2751_2 {

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void sort(int[] a, int N) {
		sort(a, 0, N - 1);
	}

	public static void sort(int[] a, int low, int high) {
		if (high <= low)
			return;
		int j = partition(a, low, high);
		sort(a, low, j - 1);
		sort(a, j + 1, high);
	}

	public static int partition(int[] a, int low, int high) {
		int i = low;
		int j = high + 1;
		int v = a[low]; // 피벗
		do {
			do
				i++;
			while (a[i] < v);
			do
				j--;
			while (v < a[j]);
			if (i < j)
				swap(a, i, j);
		} while (i < j);
		swap(a, low, j);
		return j;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] a = new int[N + 1]; // quick sort 용

		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		a[N] = Integer.MAX_VALUE; // quick sort 용

		// Bubble sort 연습 - 시간 복잡도 O(n^2) : 실패 (0%대)
//		for(int i=N-1; i>=1; i--){
//			for(int j=0; j<=i; j++){
//				if(a[j]>a[j+1]) swap(a, j, j+1);
//			}
//		}

		// Selection sort 연습 - 시간 복잡도 O(n(n-1)/2) : 실패(10%대)
//		for(int i=0; i<N; i++){
//			int min = i;
//			for(int j=i+1; j<N; j++){
//				if(a[min]>=a[j]) min = j;
//			}
//			swap(a, i, min);
//		}

		// Insertion sort 연습 - 시간 복잡도 (Best : n-1, Average : n(n-1)/4, Worst : n(n-1)/2)
		// : 실패(10%대)
//		for(int i=1; i<N; i++){
//			for(int j=i; j>0; j--){
//				if(a[j]<a[j-1]) swap(a, j, j-1);
//				else break;
//			}
//		}

		// quick sort 연습 -시간 복잡도 (Best : nlogn, Average : 2nlogn, Worst : 1/2n^2) : 통과

		sort(a, N);

		for (int i = 0; i < a.length - 1; i++) {
			System.out.println(a[i]);
		}
		sc.close();
	}
}