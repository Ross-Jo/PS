package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/17685

//참고 : https://github.com/TheAlgorithms/Java/blob/master/DataStructures/Trees/TrieImp.java
class Trie {
	
	class Node {
		Node[] child;
		boolean end;
		int counter;
		
		public Node() {
			child = new Node[26];
			end = false;
			counter = 1;
		}
	}
	
	private final Node root;
	public Trie() {
		root = new Node();
	}
	
	public void insert(String word) {
		Node curNode = root;
		for (int i=0; i<word.length(); i++) {
			Node node = curNode.child[word.charAt(i)-'a'];
			
			if(node == null) {
				node = new Node();
				curNode.child[word.charAt(i)-'a'] = node;
			} else {
				node.counter++;
			}
			curNode = node;
		}
		curNode.end = true;
	}
	
//	public boolean search(String word) {
//		Node curNode = root;
//		for (int i=0; i<word.length(); i++) {
//			Node node = curNode.child[word.charAt(i)-'a'];
//			
//			if (node == null) {
//				return false;
//			}
//			
//			curNode = node;
//		}
//		return curNode.end;
//	}
	
	public int search(String word) {
		Node curNode = root;
		int charCount = 1;
		int depth = 0;
		
		for (int i=0; i<word.length(); i++) {
			Node node = curNode.child[word.charAt(i)-'a'];
			
			if (node == null) {
				return -1;
			}
			
			depth++;
			
			int childCount = 0;
			for (Node n: node.child) {
				if (n != null) {
					childCount++;
				}
			}
			
			if (node.counter == 1 && childCount == 1) { // 해당 알파벳이 한번 사용되는 경우, 그리고 그 알파벳으로 부터 뻗어나가는 자손이 하나인 경우
				return charCount;
			}
			
			if (node.end && depth == word.length()) { // 해당 단어를 다 작성한 경우
				return charCount;
			}
			
			charCount++;
			curNode = node;
		}
		
		if (curNode.end) {
			return charCount;
		} else {
			return -1;
		}
	}
	
	public boolean delete(String word) {
		Node curNode = root;
		for (int i=0; i<word.length(); i++) {
			Node node = curNode.child[word.charAt(i)-'a'];
			
			if (node == null) {
				return false;
			}
			
			curNode = node;
		}
		if (curNode.end == true) {
			curNode.end = false;
			return true;
		}
		return false;
	}
	
}

public class Q17685 {
	public static void main(String[] args) {
		String[] words = {
//			"go", "gone", "guild"
//			"abc", "def", "ghi", "jklm"
			"word", "war", "warrior", "world"
		};
		
		Trie trie = new Trie();
		int ans = 0;
		
		for (String word: words) {
			trie.insert(word);
		}
		
		for (String word: words) {
			ans += trie.search(word);
		}
		
		System.out.println(ans);
	}
}

