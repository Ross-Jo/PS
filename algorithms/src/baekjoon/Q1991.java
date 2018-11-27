package baekjoon;

// https://www.acmicpc.net/problem/1991

import java.util.Scanner;

//이진 트리의 노드의 개수 N(1<=N<=26)

class BinaryNode {
	String nodeName;
	BinaryNode left;
	BinaryNode right;

	public BinaryNode(String nodeName, BinaryNode left, BinaryNode right) {
		this.nodeName = nodeName;
		this.left = left;
		this.right = right;
	}

	public void inorder(BinaryNode t) {
		if (t != null) {
			inorder(t.left);
			System.out.print(t.nodeName);
			inorder(t.right);
		}
	}

	public void preorder(BinaryNode t) {
		if (t != null) {
			System.out.print(t.nodeName);
			preorder(t.left);
			preorder(t.right);
		}
	}

	public void postorder(BinaryNode t) {
		if (t != null) {
			postorder(t.left);
			postorder(t.right);
			System.out.print(t.nodeName);
		}
	}

	public BinaryNode getNode(BinaryNode N, String nodeName) { // 이 부분을 주의해서 볼 것
		// 트리 단말에서의 리턴 과정때문에 애를 먹었었음
		if (N.nodeName.equals(nodeName))
			return N;
		else {
			BinaryNode result = null;
			if (left != null)
				result = left.getNode(left, nodeName);
			if (result != null)
				return result;

			if (right != null)
				result = right.getNode(right, nodeName);
			if (result != null)
				return result;
		}
		return null;
	}
	/*
	 * CF. StackOverFlow :
	 * https://stackoverflow.com/questions/33429359/how-to-find-a-specific-node-in-a
	 * -non-binary-tree public Node findNode(Node n, String s) { if (n.name == s) {
	 * return n; } else { for (Node child: n.children.values()) { Node result =
	 * findNode(child, s); if (result != null) { return result; } } } return null; }
	 */

	public void setLeft(String nodeName) {
		this.left = new BinaryNode(nodeName, null, null);
	}

	public void setRight(String nodeName) {
		this.right = new BinaryNode(nodeName, null, null);
	}

}

class BinaryTree {
	BinaryNode root;
	int size;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(String rootName) {
		root = new BinaryNode(rootName, null, null);
	}

	public BinaryNode getRoot() {
		return root;
	}

	public boolean isEmpty() {
		return root == null;
	}
}

public class Q1991 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		BinaryTree bt = new BinaryTree();

		for (int i = 0; i < N; i++) {
			String tmp;
			if (bt.isEmpty()) {
				if (!(tmp = sc.next()).equals("."))
					bt.root = new BinaryNode(tmp, null, null);
				BinaryNode node = bt.root.getNode(bt.root, tmp);
				if (!(tmp = sc.next()).equals(".") && node != null)
					node.setLeft(tmp);
				if (!(tmp = sc.next()).equals(".") && node != null)
					node.setRight(tmp);
			} else {
				BinaryNode node = bt.root.getNode(bt.root, sc.next());
				if (!(tmp = sc.next()).equals(".") && node != null)
					node.setLeft(tmp);
				if (!(tmp = sc.next()).equals(".") && node != null)
					node.setRight(tmp);
			}
		}

		bt.root.preorder(bt.root);
		System.out.println();
		bt.root.inorder(bt.root);
		System.out.println();
		bt.root.postorder(bt.root);

		sc.close();
	}
}
