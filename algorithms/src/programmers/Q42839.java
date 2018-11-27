package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42839

import java.util.Set;
import java.util.HashSet;

public class Q42839 {
	public static void main(String args[]) {}
	
	Set<Integer> s = new HashSet<Integer>();
	
	public int solution(String numbers) {
		for (int i = 1; i <= (1 << numbers.length()) - 1; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < numbers.length(); j++) {
				if (((1 << j) & i) > 0) sb.append(numbers.charAt(j));
			}
			String t = sb.toString();
			permutation(t, new boolean[t.length()], "");
		}
		return s.size();
	}

	void permutation(String s, boolean[] c, String n) {
		if (s.length() == n.length()) {
			isPrime(Integer.parseInt(n));
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if (!c[i]) {
				c[i] = true;
				permutation(s, c, n + s.charAt(i));
				c[i] = false;
			}
		}
	}

	void isPrime(int n) {
		if (s.contains(n)) return;
		if (n <= 1) return;
		else if (n == 2) {s.add(n); return;}
		for (int i = 2; i <= (int) Math.sqrt(n); i++) if (n % i == 0) return;
		s.add(n);
	}
}

//public int solution(String numbers) {
//	HashSet<Integer> set = new HashSet<>();
//	permutation("", numbers, set);
//	int count = 0;
//	while (set.iterator().hasNext()) {
//		int a = set.iterator().next();
//		set.remove(a);
//		if (a == 2)
//			count++;
//		if (a % 2 != 0 && isPrime(a)) {
//			count++;
//		}
//	}
//	return count;
//}
//
//public boolean isPrime(int n) {
//	if (n == 0 || n == 1)
//		return false;
//	for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
//		if (n % i == 0)
//			return false;
//	}
//	return true;
//}
//
//public void permutation(String prefix, String str, HashSet<Integer> set) {
//	int n = str.length();
//	if (!prefix.equals("")) set.add(Integer.valueOf(prefix));
//	for (int i = 0; i < n; i++)
//		permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
//}