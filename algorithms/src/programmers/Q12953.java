package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12953

public class Q12953 {
	public static void main(String args[]) {
		
	}
	public int solution(int[] arr) {

		int[] els = new int[100 + 1];
		int[] tmp;
		int ret = 1;

		for (int number : arr) {
			int k = number;
			tmp = new int[100 + 1];
			for (int i = 2; i <= number; i++) {
				while (k % i == 0) {
					tmp[i]++;
					k = k / i;
				}

				if (tmp[i] > els[i]) {
					els[i] = tmp[i];
				}
				if (k == 1)
					break;
			}
		}

		for (int i = 0; i < els.length; i++) {
			if (els[i] != 0) {
				ret *= (int) Math.pow(i, els[i]);
			}
		}

		return ret;
	}
}