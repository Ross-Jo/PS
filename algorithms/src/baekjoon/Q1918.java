package baekjoon;

// https://www.acmicpc.net/problem/1918

import java.util.ArrayList;
import java.util.Stack;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1918 {
	int opWeight(char op) {
		switch(op) {
			case '+': case '-':
				return 1;
			case '*': case '/':
				return 2;
		}
		return -1;
	}
	
	int opComp(char op1, char op2) {
		int w1 = opWeight(op1);
		int w2 = opWeight(op2);
		return w1>w2 ? 1 : w1<w2 ? -1 : 0;
	}
	
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q1918 q = new Q1918();
		q.solve(br.readLine());
        br.close();
	}
	
	void solve(String input) {
		ArrayList<Character> postOrder = new ArrayList<>();
		Stack<Character> s = new Stack<>();
		
		for (char c: input.toCharArray()) {
			if(c>= 'A' && c<='Z') {
				postOrder.add(c);
			} else {
				char top;
				if (c == ')') {
					for(;;) {
						top = s.pop();
						if (top == '(') break;
						postOrder.add(top);
					}
				} else {
					for(;;) {
						if(!s.isEmpty()) { 
							if(c == '(') {
								s.push(c);
								break;
							} else {
								top = s.peek();
								if(opComp(c, top) > 0) { 
									s.push(c);
									break;
								}
								else {
									postOrder.add(s.pop());
								}
							}
						} else {
							s.push(c); 
							break;
						}
					}
				}
			}
		}
		
		while(!s.isEmpty()) postOrder.add(s.pop());
		
        for(char e: postOrder) System.out.print(e);
	}
}
