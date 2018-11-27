package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12904

public class Q12904_2 {
	public static void main(String args[]) {
		Q12904_2 q = new Q12904_2();
		String s = "aa";
		System.out.println(q.solution(s));
	}
	public int solution(String s) {
		int A[] = new int[2501 * 2];
		String str = "";

		// 짝수 부분 문자열의 팰린드롬을 구하기 위해 # 추가
		for (int i = 0; i < s.length(); i++) {
			str += '#';
			str += s.charAt(i);
		}
		str += '#';
		int N = str.length();

		int r = 0; // 각 인덱스 별 팰린드롬이 될 수 있는 최대 범위
		int p = 0; // r이 형성되고 있는 중심 인덱스 번호
		for (int i = 0; i < N; i++) {
			
			printer(str, A, r, p, i, "위치1, " + "i: " + i);
			
			// A[i]의 초기값 결정
			if (i > r) A[i] = 0;
			// i는 p를 중심으로 한 회문에 속함 그 회문에서 i의 대칭점은 2p - i 이고 A[i]의 초기값은 min(A[2p - i], r - i)
			else A[i] = Math.min(A[2 * p - i], r - i);
			
			printer(str, A, r, p, i, "위치2, " + "i: " + i);

			// str.charAt(i - A[i] - 1) 와 str.charAt(i + A[i] + 1) 같으면 A[i] 증가 
			while (i - A[i] - 1 >= 0 && i + A[i] + 1 < N && str.charAt(i - A[i] - 1) == str.charAt(i + A[i] + 1)) {
				A[i]++;
				printer(str, A, r, p, i, "위치3, " + "i: " + i);
			}

			if (r < i + A[i]) {
				r = i + A[i];
				p = i;
			}
			
			printer(str, A, r, p, i, "위치4, " + "i: " + i);
		}
		int ans = 1;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, A[i]);
		}
		return ans;
	}
	
	public void printer(String str, int[] A, int r, int p, int i, String flag) {
		System.out.println("=================[ " + flag + " ]==================");
		for (int j=0; j<str.length(); j++) {
			System.out.print(str.charAt(j)+ " ");
		}
		System.out.println();
		for (int j=0; j<str.length(); j++) {
			System.out.print(A[j]+ " ");
		}
		System.out.println();
		System.out.println("r: " + r + ", p: " + p + ", i: " + i);
		System.out.println("=================[ " + flag + " ]==================");
		System.out.println();
	}
}
// 참고 : https://www.youtube.com/watch?v=nbTSfrEfo6M
// 참고 : http://platinant.tistory.com/8