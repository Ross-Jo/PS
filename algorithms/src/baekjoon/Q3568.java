package baekjoon;

//https://www.acmicpc.net/problem/3568

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q3568 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().replaceAll(",", "").replaceAll(";", "").split(" ");
		
		Pattern p = Pattern.compile("[a-zA-Z]+"); // 1개이상 매치(+), 0개이상 매치(*)
		StringBuilder sb = new StringBuilder();
		
		for (int i=1; i<input.length; i++) {
			Matcher m = p.matcher(input[i]);
			if (m.find()) { // 정규식 패턴을 이용할 때, 이 부분을 꼭 써줘야 함
				String var = m.group();
				String type = input[i].substring(var.length());
				
				Stack<String> s = new Stack<String>();
				for (char c : type.toCharArray()) {
					if (c==']') continue;
					else if (c=='[') s.push("[]");
					else if (c=='&') s.push("&");
					else s.push("*");
				}
				
				StringBuilder isb = new StringBuilder();
				while(!s.isEmpty()) isb.append(s.pop());
				
				sb.append(input[0] + isb.toString() + " " + var + ";" + "\n");
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}