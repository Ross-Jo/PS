package baekjoon;

// https://www.acmicpc.net/problem/10219

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Q10219 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- >0) {
			String[] info = br.readLine().split(" ");
			Stack<String> s = new Stack<String>();
			int row = Integer.parseInt(info[0]);
			
			for(int i=0; i<row; i++) s.add(br.readLine());
			
			while(row-- > 0) {
				bw.write(s.pop());
				bw.newLine();
			}
			bw.flush();
		}
		br.close();
	}
}
