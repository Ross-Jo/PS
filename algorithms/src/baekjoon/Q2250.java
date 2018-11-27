package baekjoon;

//https://www.acmicpc.net/problem/2250

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//유의할 점 [아예 문제를 풀때부터 고려 했어야 했음]
//root가 1이 아닐 수 있음
//각 줄 마다 노드의 번호/그 노드의 left child/그 노드의 right child가 들어오는데 노드의 번호가 1->2->3->...->N 순서로 들어오지 않을 수 있습니다.

//아래는 오답 

public class Q2250 {
	static int N, i;
	static int[] levels;
	static int levelCount;
	
	static class Node {
		int number, level;
		Node left, right;
		
		Node (int number, int level) {
			this.number = number;
			this.level = level;
		}
	}
	
	static class BinaryTree {
		Node root;
		BinaryTree() {
			root = new Node(1, 1);
		}
		
		Node findNode(Node root, int targetNum) {
			if (root == null) return null;
			if (targetNum == root.number) return root;
			
			Node ret = null;
			if ((ret = findNode(root.left, targetNum)) != null) {
				return ret;
			}
			else if ((ret = findNode(root.right, targetNum)) != null) {
				return ret;
			}
			return ret;
		}
		
		void inorderTraverse(Node root) {
			if (root == null) return;
			if (root.left != null)inorderTraverse(root.left);
			if (i<N) {
				levels[i] = root.level;
				i++;
			}
			if (root.right != null)inorderTraverse(root.right);
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		i = 0;
		levels = new int[N];
		
		BinaryTree bt = new BinaryTree();
		levelCount = 1;
		for (int i=0; i<N; i++) {
			String[] tmp = br.readLine().split(" ");
			Node ret = bt.findNode(bt.root, Integer.parseInt(tmp[0]));
			
			int l = Integer.parseInt(tmp[1]);
			int r = Integer.parseInt(tmp[2]);
			
			if (l!=-1) {
				levelCount = Math.max(levelCount, ret.level+1);
				ret.left = new Node(l, ret.level+1);
			}
			
			if (r!=-1) {
				levelCount = Math.max(levelCount, ret.level+1);
				ret.right = new Node(r, ret.level+1);
			}
		}
		
		int level = 0, ans = -1;
		bt.inorderTraverse(bt.root);
		
		for (int l=1; l<=levelCount; l++) {
			int i=0; 
			int j=N-1;
				while(i<N && levels[i]!=l) {i++;};
				while(j>=0 && levels[j]!=l) {j--;};
				int width = j-i+1;
				if (width > ans) {
					level = l;
					ans = width;
				}
		}
		
		System.out.println(level+ " " + ans);
		br.close();
	}
}