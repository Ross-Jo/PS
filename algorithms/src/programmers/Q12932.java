package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12932

public class Q12932 {
	public static void main(String args[]) {
		Q12932 q = new Q12932();
		long n = 12345;
		for (int el: q.solution(n)) {
			System.out.print(el + " ");
		}
	}
	
	public int[] solution(long n) {
		String number = Long.toString(n);
		char[] arr = number.toCharArray();
		int[] ret = new int[arr.length];
		
		for (int i=0; i<arr.length; i++) {
			ret[i] = Character.getNumericValue(arr[arr.length - 1 - i]);
		}
		
		return ret;
	}
}

//public int[] solution(long n) {
//    String a = "" + n;
//      int[] answer = new int[a.length()];
//      int cnt=0;
//
//      while(n>0) {
//          answer[cnt]=(int)(n%10);
//          n/=10;
//          cnt++;
//      }
//    return answer;
//}