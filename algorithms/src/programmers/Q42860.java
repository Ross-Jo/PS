package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42860

public class Q42860 {
	public static void main(String args[]) {}

	public int solution(String name) {
		StringBuilder sb = new StringBuilder();
		int n = name.length();
		for (int i = 0; i < n; i++)
			sb.append("A");
		String target = sb.toString();

		int idx = 0;
		int ans = 0;
		boolean[] checked = new boolean[n];
		while (!name.equals(target)) {
			if (name.charAt(idx) != 'A') {
				ans += Math.min(26 - (name.charAt(idx) - 'A'), (name.charAt(idx) - 'A'));
				checked[idx] = true;
				StringBuilder tmp = new StringBuilder(target);
				tmp.setCharAt(idx, name.charAt(idx));
				target = tmp.toString();
				if (name.equals(target))
					break;
			}
			int min = 20;
			int mi = -1;
			for (int i = 0; i < n; i++) {
				if (!checked[i] && name.charAt(i) != 'A') {
					int t = Math.min(Math.abs(n - Math.abs(i - idx)), Math.abs(i - idx));
					if (t < min) {
						min = t;
						mi = i;
					}
				}
			}
			idx = mi;
			ans += min;
		}

		return ans;
	}
}
