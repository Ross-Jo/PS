package baekjoon;

//https://www.acmicpc.net/problem/10178

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Q10178 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		while(n-- > 0) {
			String[] arg = br.readLine().split(" ");
			int a = Integer.parseInt(arg[0]);
			int b = Integer.parseInt(arg[1]);
			int c = a/b;
			bw.write("You get " + c + " piece(s) and your dad gets " + (a - c*b) + " piece(s)." + "\n");
		}
		
		bw.close();
		br.close();
	}
}
