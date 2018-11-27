package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42842

public class Q42842 {
	public static void main(String args[]) {
		
	}
	public int[] solution(int brown, int red) {
		int[] ans = new int[2];
		for (int sum = 4; sum <= 2500; sum++) {
			for (int x = (int) Math.ceil(sum / 2.0); x <= sum - 3; x++) {
				int b = 2 * x + 2 * ((sum - x) - 2);
				int r = x * (sum - x) - (2 * x + 2 * ((sum - x) - 2));
				if (b == brown && r == red) {
					ans[0] = x;
					ans[1] = sum - x;
					return ans;
				}
			}
		}

		return ans;
	}
}

//public int[] solution(int brown, int red) {
//    for(int i=1; i<=red; i++) {
//        if(red%i==0 && (red/i+i)*2+4==brown) {
//            return new int[] {red/i+2, i+2};
//        }
//    }
//    return null;
//}

//public int[] solution(int brown, int red) {
//    int a = (brown+4)/2; // x + y
//    int b = red+2*a-4; // x * y
//    int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2}; // (x+y + x-y)/2, (x+y - (x-y))/2
//    return answer;
//}