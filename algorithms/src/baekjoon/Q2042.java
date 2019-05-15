package baekjoon;
import java.util.Scanner;

public class Q2042 {
	static int MAX = (int) 1e6 + 10;
	static int size, n, m, k, q;
	static long y, A[] = new long[MAX], bucket[] = new long[MAX];
	
	static void init() {
		size = (int) Math.sqrt(n);

		for (int i = 0; i < n; i++) bucket[i / size] += A[i];
	}
	
	static long query(int lo, int hi) {
		long ret = 0;

		while (lo % size != 0 && lo <= hi) ret += A[lo++];
		while ((hi + 1) % size != 0 && lo <= hi) ret += A[hi--];
		
		while (lo <= hi) {
			ret += bucket[lo / size];
			lo += size;
		}

		return ret;
	}
	
	static void update(int pos, long val) {
		long diff = val - A[pos];
		A[pos] = val;
		bucket[pos / size] += diff;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
		
		for (int i=0; i<n; i++) A[i] = sc.nextLong();
		init();
		
		for (int iter = 0; iter < m + k ; iter++) {
			int q = sc.nextInt();
			
			int pos, lo, hi;
			long val;
			if (q == 1) {
				pos = sc.nextInt();
				val = sc.nextLong();
				update(pos - 1, val);
			} else {
				lo = sc.nextInt();
				hi = sc.nextInt();
				System.out.println(query(lo - 1, hi - 1));
			}
		}
		
		sc.close();
	}
}
