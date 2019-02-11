package baekjoon;

// https://www.acmicpc.net/problem/5639
// 참고 : https://www.geeksforgeeks.org/find-postorder-traversal-of-bst-from-preorder-traversal/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q5639_2 {
	static BufferedWriter bw;
	static class INT {
		int data;
		INT (int d) {
			data=d;
		}
	}
	
	// 범위로 출력 여부를 따지는 방법 
	// 객체 래퍼런스로 타깃팅하는 인덱스를 통제하고 있음에 유의하자
	// 범위를 통해 왼쪽 서브트리, 오른쪽 서브트리를 출력후, 루트를 출력하는 방식이다. 
	// 이때 객체 레퍼런스를 통해 인덱스를 다루기 때문에 int val = pre[preIndex.data]과 같이 val에 값을 저장하는 부분에 유의하자 
	static void findPostOrderUtil(int pre[], int n, int minval, int maxval, INT preIndex) throws IOException {
		if (preIndex.data == n) return;
		if (pre[preIndex.data] < minval || pre[preIndex.data] > maxval) return;
		int val = pre[preIndex.data];
		preIndex.data++;
		
		findPostOrderUtil(pre, n, minval, val, preIndex);
		findPostOrderUtil(pre, n, val, maxval, preIndex);
		bw.write(Integer.toString(val)+"\n");
	}
	
	static void findPostOrder(int pre[], int n) throws IOException {
		INT preIndex = new INT(0);
		findPostOrderUtil(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE, preIndex);
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String tmp; int i=0;
		int[] pre = new int[10000];
		while((tmp=br.readLine())!=null) pre[i++] = Integer.parseInt(tmp);
		
		int n = i;
		findPostOrder(pre, n);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
