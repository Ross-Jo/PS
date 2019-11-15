package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class BinaryTreeInorderTraversal {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	static List<Integer> inorderTraversal_stack(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}
	
	static List<Integer> inorderTraversal_morris(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		TreeNode curr = root;
		TreeNode pre;
		while (curr != null) {
			if (curr.left == null) {
				res.add(curr.val);
				curr = curr.right; // move to next right node
			} else { // has a left subtree
				pre = curr.left;
				while (pre.right != null) { // find rightmost
					pre = pre.right;
				}
				pre.right = curr; // put cur after the pre node
				TreeNode temp = curr; // store cur node
				curr = curr.left; // move cur to the top of the new tree
				temp.left = null; // original cur left be null, avoid infinite loops
			}
		}
		return res;
	}
	
	public static void main(String[] args) {

	}

}
