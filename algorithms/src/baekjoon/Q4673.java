package baekjoon;

// https://www.acmicpc.net/problem/4673

public class Q4673 {
	public static int d(int x) {
		int sum = x;
		while (x > 0) {
			sum += x % 10;
			x = x / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		boolean[] numbers = new boolean[10001];

		for (int i = 1; i <= 10000; i++) {
			if (numbers[i] == false) {
				int tmp_index = i;
				while (tmp_index <= 10000) {
					tmp_index = d(tmp_index);
					if (tmp_index > 10000)
						break;
					if (tmp_index <= 10000 && numbers[tmp_index] == true)
						continue;
					numbers[tmp_index] = true;
				}
			} else
				continue;
		}
		for (int i = 1; i <= 10000; i++) {
			if (numbers[i] == false)
				System.out.println(i);
		}
	}
}