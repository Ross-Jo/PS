package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12922

public class Q12922 {
	public static void main(String args[]) {
		Q12922 q = new Q12922();
		int n = 4;
		System.out.println(q.solution(n));
	}
	public String solution(int n) {
		String su = "수";
		String bak = "박";
		String ret = "";
		for (int i=0; i<n; i++) {
			ret += i%2 == 0? su: bak;
		}
		
		return ret;
	}
}

//public String watermelon(int n){
//    return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
//}