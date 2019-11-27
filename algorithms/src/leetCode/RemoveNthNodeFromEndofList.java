package leetCode;

// 참고 : https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/

public class RemoveNthNodeFromEndofList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i=1; i<=n+1; i++) first = first.next;
        
        while (first != null) {
        	first = first.next;
        	second = second.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
    }
	
	public static void main(String[] args) {

	}

}
