package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static List<List<Integer>> bucket = new ArrayList<>();
	static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

	static List<List<Integer>> levelOrder1(TreeNode root) {
		if (root == null) return bucket;
		levelOrder(root, 0);
		
		for (int i=0; i<map.size(); i++) {
			bucket.add(new ArrayList<Integer>());
			List<Integer> target = bucket.get(i);
			for (int e: map.get(i)) target.add(e);
		}
		
		return bucket;
	}
   
	static void levelOrder(TreeNode root, int depth) {
		if (root == null) return;
		if (map.get(depth) == null) map.put(depth, new ArrayList<Integer>());
		
		map.get(depth).add(root.val);
		levelOrder(root.left, depth + 1);
		levelOrder(root.right, depth + 1);
	}
	
	// ------------------------------------------------------------------------------------------
	static List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int cnt = queue.size();
			List<Integer> level = new ArrayList<>(cnt);
			for (int i = 0; i < cnt; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
			res.add(level);
		}
		return res;
	}
	// ------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		levelOrder1(root);
	}
}
