package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42577

import java.util.Arrays;
import java.util.Comparator;

public class Q42577 {
	class Trie {
	    class Node {
	        Node[] child;
	        boolean end;
	        
	        Node() {
	            child = new Node[10];
	            end = false;
	        }
	    }
	    
	    Node root;
	    Trie() {
	      root = new Node();  
	    }
	    
	    boolean insert(String number) {
	        Node curNode = root;
	        for(char c: number.toCharArray()) {
	            Node node = curNode.child[c-'0'];
	            if (node == null) {
	                node = new Node();
	                curNode.child[c-'0'] = node;
	            } else {
	              if (node.end) return false;  
	            }
	            curNode = node;
	        }
	        curNode.end = true;
	        return true;
	    }
	    
	}
	
	public static void main(String args[]) {
		
	}
	
    public boolean solution(String[] phone_book) {
        Trie t = new Trie();
        
        Arrays.sort(phone_book, new Comparator<String>() {
           @Override
            public int compare(String o1, String o2) {
               return o1.length() - o2.length();
           } 
        });
        
        boolean ans = true;
        for (String number: phone_book) {
            if(!t.insert(number)) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}

//class Solution {
//	public boolean solution(String[] phoneBook) {
//		for (int i = 0; i < phoneBook.length - 1; i++) {
//			for (int j = i + 1; j < phoneBook.length; j++) {
//				if (phoneBook[i].startsWith(phoneBook[j])) return false;
//				if (phoneBook[j].startsWith(phoneBook[i])) return false;
//			}
//		}
//		return true;
//	}
//}