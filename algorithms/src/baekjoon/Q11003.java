package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Deque;

public class Q11003 {
	static int N, L;
	static class Node {
		int idx, num;
		Node(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]); L = Integer.parseInt(tmp[1]);
		Deque<Node> d = new LinkedList<>();
		
		tmp = br.readLine().split(" ");
		for (int i=0; i<N; i++) {
			int target = Integer.parseInt(tmp[i]);
			while(d.size()>0 && d.peekFirst().idx<=i-L) d.pollFirst();
			while(d.size()>0 && d.peekLast().num>=target) d.pollLast();
			d.addLast(new Node(i, target));
			
			bw.write(Integer.toString(d.peekFirst().num) + " ");
		}
		bw.flush();
		
		br.close();
		bw.close();
	}
}
