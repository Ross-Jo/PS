package leetCode;

public class AddTwoNumbers {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	static ListNode addTwoNumbers_mySol(ListNode l1, ListNode l2) {
		ListNode now, tail = null, trailer = null;
		int carry = 0;
		boolean make = false, first = true;
		
		do {
			int sum = 0;
			
			if (l1!=null) {
				make = true;
				sum += l1.val;
			}
			if (l2!=null) {
				make = true;
				sum += l2.val;
			}
			if (carry == 1) {
				make = true;
			}
			
			if (make) {
				now = new ListNode(carry);
				carry = 0;
				
				if (first) {
					tail = now;
					trailer = tail;
					first = false;
				} else {
					trailer.next = now;
					trailer = trailer.next;
				}
				
				if (now.val + sum >= 10) {
					now.val += sum - 10;
					carry = 1;
				} else {
					now.val += sum;
				}
				
			}
			
			if (l1!=null) l1 = l1.next;
			if (l2!=null) l2 = l2.next;
			
		} while (l1!=null || l2!=null || carry == 1);
		
		return tail;
	}
	
	static ListNode addTwoNumbers_siteSol(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		
		while (p != null || q != null ) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		} 
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		ListNode ln1 = new ListNode(2);
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(3);
		
		ListNode ln2 = new ListNode(5);
		ln2.next = new ListNode(6);
		ln2.next.next = new ListNode(4);
		
		ListNode ans = addTwoNumbers_mySol(ln1, ln2);
		do {
			System.out.print(ans.val + " ");
			ans = ans.next;
		} while(ans!=null);
	}
}
