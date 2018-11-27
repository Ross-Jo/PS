package baekjoon;

// https://www.acmicpc.net/problem/2751

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2751 {
	static int N;
	
	static void mergeSort(int[] arr, int[] aux, int lo, int hi) {
		if (hi<=lo) return;
		int mid = lo + (hi-lo)/2;
		mergeSort(arr, aux, lo, mid);
		mergeSort(arr, aux, mid+1, hi);
		merge(arr, aux, lo, mid, hi);
	}
	
	/*
	 * 만약, aux[] 배열을 그때그때 생성해서 소팅을 한다면 엄청난 시간적 손실을 볼 수 있다. 
	 * 아래와 위의 함수와 같이 한번 생성한 객체를 파라미터로 넘기고, 또 넘겨받으면서 계속 재활용해야 시간적 이득을 볼 수 있다. 
	 */
	static void merge(int[] arr, int[] aux, int lo, int mid, int hi) { 
		// int[] aux = new int[arr.length]; // do 'NOT' do this
		for (int k=lo; k<=hi; k++) aux[k] = arr[k];
		int i = lo; int j = mid+1;
		
		for (int k=lo; k<=hi; k++) {
			if (i>mid) arr[k] = aux[j++];
			else if (j>hi) arr[k] = aux[i++];
			else if (aux[i] > aux[j]) arr[k] = aux[j++];
			else arr[k] = aux[i++];
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		for (int i=0; i<N; i++) nums[i] = Integer.parseInt(br.readLine());
		mergeSort(nums, new int[N], 0 , N-1);
		
		for (int e : nums) {
			bw.write(Integer.toString(e));
			bw.newLine();
		}
		bw.flush();
		
		br.close();
	}
}
