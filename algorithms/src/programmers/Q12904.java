package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12904

public class Q12904 {
	public static void main(String args[]) {
		Q12904 q = new Q12904();
		String s = "abcdcba";
		System.out.println(q.solution(s));
	}
	
	public int solution(String s) {
		int max = 1;
		int length = s.length();
		
		loop:
		for (int i=length; i>=1; i--) {
			for (int j=0; j+i-1 < length; j++) {
//				if (isPalindrome(s.substring(j, j+i))) { // substring이 있느냐 없느냐에 따라 통과 여부가 달라 졌었다. 이를 보면, substring의 실행시간이 어느정도의 영향을 미치는지 알 수 있다.
				if (isPalindrome(s, j, j+i-1)) {
					max = i;
					break loop;
				}
			}
		}
		
//        for (int answer = length; answer > 1; answer--) {
//            int start = 0;
//            int end = 0 + answer - 1;
//            while (end < length) {
//                if (isPalindrome(s, start, end)) {
//                    return answer;
//                }
//                start++;
//                end++;
//            }
//        }
		
		return max;
	}

// 방법1.
//	public boolean isPalindrome(String s) {
//		int length = s.length();
//		Stack<Character> stack = new Stack<Character>();
//		
//		boolean ret = true;
//		for (int i=0; i<length; i++) {
//			if (i < (int)length/2) {
//				stack.push(s.charAt(i));
//			} else if (i >= Math.ceil(length/2.0)) {
//				if (s.charAt(i) == stack.pop()) {
//					// void
//				} else {
//					ret = false;
//					break;
//				}
//			}
//		}
//		
//		return ret;
//	}

// 방법2. 
//	public boolean isPalindrome(String s) {
//		int length = s.length();
//		
//		boolean ret = true;
//		for (int i=0; i<length/2.0; i++) {
//			if(s.charAt(i) != s.charAt(length-(i+1))) {
//				ret = false;
//				break;
//			}
//		}
//		return ret;
//	}
		
// 방법2 - 변형1
	public boolean isPalindrome(String s, int a, int b) {
		for (int i=0; i<= ((b-a+1)/2 - 1); i++) {
			if(s.charAt(a+i) != s.charAt(b-i)) {
				return false;
			}
		}
		return true;
	}
	
}