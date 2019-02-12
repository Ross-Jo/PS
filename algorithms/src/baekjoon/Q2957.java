package baekjoon;

// https://www.acmicpc.net/problem/2957
// AVL 트리. 참고 : https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
// [틀림 - 수정필요]

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2957 {
	static int c = 0;
	
	static class Node {
		int key, height;
		Node left, right;
		
		Node(int d) {
			key = d;
			height = 1;
		}
	}
	
	static class AVLTree {
		Node root;
		
		int height(Node N) {
			if (N == null) return 0;
			return N.height;
		}
		
		int getBalance(Node N) {
			if (N == null) return 0;
			return height(N.left) - height(N.right);
		}
		
		Node rightRotate(Node y) {
			Node x = y.left;
			Node T2 = x.right;
			
			x.right = y;
			y.left = T2;
			
			y.height = Math.max(height(y.left), height(y.right)) + 1;
			x.height = Math.max(height(x.left), height(x.right)) + 1;
			
			return x;
		}
		
		Node leftRotate(Node x) {
			Node y = x.right;
			Node T2 = y.left;
			
			y.left = x;
			x.right = T2;
			
			x.height = Math.max(height(x.left), height(x.right)) + 1;
			y.height = Math.max(height(y.left), height(y.right)) + 1;
			
			return y;
		}
		
		Node insert(Node node, int key) {
			c++;
			
			if (node == null) return new Node(key);

			if (key < node.key) node.left = insert(node.left, key);
			else if (key > node.key) node.right = insert(node.right, key);
			else return node;

			node.height = 1 + Math.max(height(node.left), height(node.right));

			int balance = getBalance(node);

			if (balance > 1 && key < node.left.key) return rightRotate(node);

			if (balance < -1 && key > node.right.key) return leftRotate(node);

			if (balance > 1 && key > node.left.key) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}

			if (balance < -1 && key < node.right.key) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}

			return node;
		}
	}
	
	static class PlainTree {
		Node root;
		
		void insert(Node node, int key) {
			c++;
			
			if (key < node.key) {
				if (node.left == null) node.left = new Node(key);
				else insert(node.left, key);
			}
			else if (key > node.key) {
				if (node.right == null) node.right = new Node(key);
				else insert(node.right, key);
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		AVLTree tree1 = new AVLTree();
		PlainTree tree2 = new PlainTree();
		
		boolean first = true;
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			int e = Integer.parseInt(br.readLine());
			
			if(first) {
				tree2.root = new Node(e);
				first = false;
			} else {
				tree2.insert(tree2.root, e);
			}
			bw.write(Integer.toString(c)+"\n");
		}
		
		bw.close();
		br.close();
	}
}
