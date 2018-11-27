package baekjoon;

// https://www.acmicpc.net/problem/2018

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

// 1<=N<=500,000, N은 홀수로 제한
// 입력되는 정수의 절대값은 4000을 넘지 않음
public class Q2018 {
	static int CUTSIZE = 5;

	public static void InsertionSort(int[] a, int low, int high) {
		for (int i = low + 1; i <= high; i++) { // i<=high, print와 다른 부분. 주의하자
			for (int j = i; j > low; j--) {
				if (a[j] < a[j - 1])
					swap(a, j, j - 1);
			}
		}
	}

	// improvement를 적용하지 않은 qsort의 경우 소요시간 : 1372MS
	// median of three 방식으로 improvement시 소요시간 : 1380MS (시간이 오히려 늘었네?)
	// knuth shuffle로 input배열 shuffling시 소요시간 : 1420MS (improvement 방법의 중복 적용으로 수행
	// 시간이 더 늘어나는 것으로 보인다)
	// Hybrid of Quick and Insertion Sort시 소요시간 : 1476MS
	public static void sort(int[] a, int low, int high) {
		if (high < low + CUTSIZE) { // Hybrid of Quick and Insertion Sort로 improvement
			InsertionSort(a, low, high);
			return;
		}
		int median = findMedian(a, low, (high - low) / 2, high); // median of three 방식으로 improvement
		swap(a, low, median); // median of three 방식으로 improvement
		int j = partition(a, low, high);
		sort(a, low, j - 1);
		sort(a, j + 1, high);
	}

	public static int partition(int[] a, int low, int high) {
		int i = low;
		int j = high + 1;
		int v = a[low];
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

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static int findMedian(int[] a, int low, int med, int high) {
		return a[low] < a[med] ? (a[med] < a[high] ? med : (a[low] < a[high] ? high : low))
				: (a[low] < a[high] ? low : (a[med] < a[high] ? high : med));
	}

	// Knuth shuffle
	public static void shuffle(int[] a) {
		int N = a.length - 1;
		Random rand = new Random();
		for (int i = 0; i < N; i++) {
			int r = rand.nextInt(i + 1);
			swap(a, i, r);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// quick sort 및 개선된 quick sort 연습
		int[] num = new int[N + 1];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		num[N] = Integer.MAX_VALUE; // infinite 값

		shuffle(num); // Knuth shuffle로 quick sort 성능 improvement 시도
		sort(num, 0, N - 1);

		float sum = 0; // 숫자들의 합계를 담기 위한 변수
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			sum += num[i];
			if (h.containsKey(num[i]))
				h.put(num[i], h.get(num[i]) + 1); // 각 숫자들이 등장하는 빈도 체크
			else
				h.put(num[i], 1);
			if (h.get(num[i]) >= max)
				max = h.get(num[i]); // 최빈값을 잡기 위한 변수
		}

		Iterator<Integer> it = h.keySet().iterator();
		int[] freq = new int[h.size()];
		Arrays.fill(freq, -4001);
		int count = 0;
		while (it.hasNext()) {
			Integer key = it.next();
			if (h.get(key) == max)
				freq[count++] = key;
		}

		Arrays.sort(freq);

		System.out.printf("%.0f\n", sum / (num.length - 1)); // 산술평균
		System.out.println(num[N / 2]); // 중앙값

		// 최빈값
		if (count == 1) {
			for (int i = 0; i < freq.length; i++) {
				if (freq[i] != -4001) {
					System.out.println(freq[i]);
					break;
				}
			}
		} else { // 두번째로 작은 최빈값을 찾아내기 위한 과정
			boolean flag = false;
			for (int i = 0; i < freq.length; i++) {
				if (freq[i] != -4001 && flag == false) {
					flag = true;
				} else if (flag == true) {
					System.out.println(freq[i]);
					break;
				}
			}
		}
		// 코드가 너무 지저분 하다 : 빈도수를 배열에 저장한 다음 delaying 값을 저장하는 int를 두어 2번째로 작은 최빈값을 찾는 코드가
		// 깔끔할 듯 하다.
		System.out.println(num[N - 1] - num[0]); // 범위

		sc.close();
	}
}