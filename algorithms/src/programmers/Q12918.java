package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12918

public class Q12918 {
	public static void main(String args[]) {
		Q12918 q = new Q12918();
		String s = "12345";
		System.out.println(q.solution(s));
	}
	
	public boolean solution(String s) {
		if (!(s.length() ==4 || s.length() == 6)) {
			return false;
		}
		
		for (char c: s.toCharArray()) {
			if (!(c >= '0' && c<= '9')) {
				return false;
			}
		}
		return true;
	}
}

//public boolean solution(String s) {
//    if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
//    return false;
//}

//public boolean solution(String s) {
//    if(s.length() == 4 || s.length() == 6){
//        try{
//            int x = Integer.parseInt(s);
//            return true;
//        } catch(NumberFormatException e){
//            return false;
//        }
//    }
//    else return false;
//}
