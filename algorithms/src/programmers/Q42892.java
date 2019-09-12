package programmers;

// 참고 : https://www.youtube.com/watch?v=J8YxDIauh1g&list=PL6YHvWRMtz7CyRH31LhCHR0gp_x7eeSK6&index=5

import java.util.*;

public class Q42892 {
	static class Node {
		int id;
		int x, y;
		Node left, right;
		Node(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}
	}
	
	static int idx;
	static List<Node> Nodes = new ArrayList<Node>();
	
	static Comparator<Node> Comp = new Comparator<Node>() {
		public int compare(Node a, Node b) {
			if (a.y == b.y) return a.x - b.x;
			return b.y - a.y;
		}
	};
	
	static void addNode(Node parent, Node child) {
		if (child.x < parent.x) {
			if (parent.left == null) parent.left = child;
			else addNode(parent.left, child);
		}
		else {
			if (parent.right == null) parent.right = child;
			else addNode(parent.right, child);
		}
	}
	
	static void preorder(int[][] answer, Node node) {
		if (node == null) return;
		
		answer[0][idx++] = node.id;
		preorder(answer, node.left);
		preorder(answer, node.right);
	}
	
	static void postorder(int[][] answer, Node node) {
		if (node == null) return;
		
		postorder(answer, node.left);
		postorder(answer, node.right);
		answer[1][idx++] = node.id;
	}
	
    static public int[][] solution(int[][] nodeinfo) {
    	int size = nodeinfo.length;
    	for (int i=0; i<size; i++) Nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
    	Nodes.sort(Comp);
    	
    	Node root = Nodes.get(0);
    	for (int i=1; i<size; i++) addNode(root, Nodes.get(i));
    	
    	int[][] answer = new int[2][size];
    	preorder(answer, root);
    	idx = 0;
    	postorder(answer, root);
    	return answer;
    }
	

	public static void main(String[] args) {

	}

}
