package baekjoon;

// https://www.acmicpc.net/problem/5639

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q5639 {
	
	static class Node {
		int num;
		Node left;
		Node right;
		Node(int num) {
			this.num = num;
		}
	}
	
	static Node r;
	static int[] nums = new int[10000];
	static int t;
	
	public static void makeTree(Node root) {
		if(root.num == 0) root.num = t;
		else if(root.num > t) {
			if(root.left == null) root.left = new Node(0);
			makeTree(root.left);
		}
		else if(root.num < t) {
			if(root.right == null) root.right = new Node(0);
			makeTree(root.right);
		}
	}
	
	public static void printPostOrder(BufferedWriter bw, Node root) throws IOException {
		if (root == null || root.num==0) return;
		printPostOrder(bw, root.left);
		printPostOrder(bw, root.right);
		bw.write(Integer.toString(root.num)+"\n");
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String tmp;
		boolean rootFlag = true;
		while((tmp=br.readLine())!=null) { // 자바의 BufferedReader를 통해 인풋 받을시, EOF를 활용한 인풋 입력 종료를 잡아내는 방법 
			t = Integer.parseInt(tmp);

			if (rootFlag) {
				r = new Node(t);
				rootFlag = false;
			}
			
			makeTree(r);
		}
		
		printPostOrder(bw, r);
		bw.flush();
		
		bw.close();
		br.close();
	}
}
