package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17684

import java.util.ArrayList;

public class Q17684 {
	public static void main(String[] args) {
		String msg = "ABABABABABABABAB";
		
		ArrayList<String> dic = new ArrayList<String>();
		ArrayList<Integer> dicNums = new ArrayList<Integer>();
		
		for (int i=1; i<=26; i++) {
			char target = (char)('A' + (i-1)); // 알파벳 증가 
			dic.add(Character.toString(target));
		}
		
		while(msg.length() > 0) {
			
			for (int i=dic.size()-1; i>=0; i--) {
				String word = dic.get(i);
				
				if(msg.length() >= word.length() && word.equals(msg.substring(0,word.length()))) {
					dicNums.add(i);
					
					try {
						dic.add(word + Character.toString(msg.charAt(word.length())));
					} catch(StringIndexOutOfBoundsException e) {
						// void
					}
					
					msg = msg.substring(word.length());
					break;
				}
			}
		}
		
		for (int num : dicNums) {
			System.out.print(num+1 + " ");
		}
		
	}
}
