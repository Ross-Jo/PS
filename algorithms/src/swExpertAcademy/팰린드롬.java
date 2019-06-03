package swExpertAcademy;

import java.util.Scanner;

public class 팰린드롬 {
	static int T;
	static String input;
	static char[] tmp;
	
	static int palindrome(int index) {
		int ret = 1;
		for (int i=1; index - i >= 0; i++) {
			if (index + i < tmp.length && tmp[index-i] == tmp[index+i]) ret++;
			else break;
		}
		if (tmp[index]=='0') {
			if ((ret & 1) == 0) return ret;
			else return ret-1;
		} else {
			if ((ret & 1) == 0) return ret-1;
			else return ret;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			input = sc.next();
			tmp = new char[input.length() * 2];

			for (int i = 0; i < tmp.length; i++) tmp[i] = '0';
			for (int i = 0; i < input.length(); i++) tmp[i * 2] = input.charAt(i);

			int max = 0, len;
			for (int i = 0; i < tmp.length; i++) if (max < (len = palindrome(i))) max = len;

			System.out.println("#" + t + " " + max);
		}
		sc.close();
	}
}
