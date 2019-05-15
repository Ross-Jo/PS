package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11279 {
	
	static class HeapRef {
		static final int MAX_SIZE = 100000 + 10;
		int[] heap = new int[MAX_SIZE];
		int heapSize = 0;

		HeapRef() {
			heapSize = 0;
		}

		void heapPush(int value) {
			if (heapSize >= MAX_SIZE) return;
			heap[++heapSize] = value;

			int current = heapSize;
			while (current > 1 && heap[current] > heap[current / 2]) {
				int tmp = heap[current / 2];
				heap[current / 2] = heap[current];
				heap[current] = tmp;
				current = current / 2;
			}
		}

		int heapPop() {
			if (heapSize <= 0) return 0;
			int value = heap[1];

			heap[1] = heap[heapSize];
			heapSize--;

			int current = 1;
			while (current <= heapSize && current * 2 <= heapSize) {
				int child;
				if (current * 2 + 1 > heapSize) child = current * 2;
				else child = heap[current * 2] > heap[current * 2 + 1] ? current * 2 : current * 2 + 1;
				if (heap[current] > heap[child]) break;

				int tmp = heap[current];
				heap[current] = heap[child];
				heap[child] = tmp;

				current = child;
			}
			return value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HeapRef heap = new HeapRef();
		
		int x;
		for (int i=0; i<N; i++) {
			x = Integer.parseInt(br.readLine());
			if (x != 0) heap.heapPush(x);
			else {
				bw.write(Integer.toString(heap.heapPop()));
				bw.newLine();
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
