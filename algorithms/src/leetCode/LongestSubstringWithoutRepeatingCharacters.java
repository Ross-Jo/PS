package leetCode;

import java.util.HashMap;
import java.util.Map;

// 솔루션 참고 

public class LongestSubstringWithoutRepeatingCharacters {
	static int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}
	public static void main(String args[]) {
		System.out.println(lengthOfLongestSubstring("abcaefghi"));
	}
}
