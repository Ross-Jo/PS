package leetCode;

// 참고 : https://leetcode.com/problems/longest-palindromic-substring/solution/

public class LongestPalindromicSubstring {
	
	static String longestPalindrome_dp(String s) {
		if (s == null || "".equals(s)) return s;
		int len = s.length();

		String ans = "";
		int max = 0;

		boolean[][] dp = new boolean[len][len];
		
		for (int j = 0; j < len; j++) {
			for (int i = 0; i <= j; i++) {
				
				boolean judge = s.charAt(i) == s.charAt(j);
				
				dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] && judge : judge; // j - i > 2 판별문의 의미 : 길이가 1, 2, 3인 팰린드롬의 경우 판별 규칙을 다르게 적용하겠다는 의미
				
				if (dp[i][j] && j - i + 1 > max) {
					max = j - i + 1;
					ans = s.substring(i, j + 1);
				}
			}
		}
		
		return ans;
	}
	
	public String longestPalindrome_expandAroundCenter(String s) {
		if (s == null || s.length() < 1) return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			
			int len = Math.max(len1, len2);
			
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
			
		}
		
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome_dp("aaaa"));
	}

}
