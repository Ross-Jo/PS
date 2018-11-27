package baekjoon;

// https://www.acmicpc.net/problem/1094

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

class ReturnSet {
	int min;
	int targetIndex;

	public ReturnSet(int min, int targetIndex) {
		this.min = min;
		this.targetIndex = targetIndex;
	}
}

public class Q1094 {

	public static int simulation(int N) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(64); // 벡터 초기화

		while (addVector(v) > N) {
			// 1단계.
			ReturnSet rc = chooseShortest(v);
			int half = rc.min / 2; // 에러주의
			v.remove(rc.targetIndex);
			v.add(half);
			v.add(half);

			// 2단계.
			if ((addVector(v) - half) >= N) {
				v.remove(v.size() - 1);
			}
		}
		return v.size();
	}

	public static ReturnSet chooseShortest(Vector<Integer> v) {
		int targetIndex = 0;
		int min = 65;
		for (int i = 0; i < v.size(); i++) {
			if (v.elementAt(i) < min) {
				min = v.elementAt(i);
				targetIndex = i;
			}
		}
		return new ReturnSet(min, targetIndex);
	}

	public static int addVector(Vector<Integer> v) {
		int sum = 0;
		for (int i = 0; i < v.size(); i++) {
			sum += v.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int N = Integer.parseInt(br.readLine());
			System.out.println(simulation(N));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}