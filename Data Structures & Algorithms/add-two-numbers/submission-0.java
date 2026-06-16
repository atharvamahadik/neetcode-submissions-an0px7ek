/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode m = dummy;
        int carry = 0;
        while(p1!=null || p2!=null || carry!=0) {
            int val1 = p1!=null ? p1.val : 0;
            int val2 = p2!=null ? p2.val : 0;
            int addition = val1 + val2 + carry;
            int digit = addition%10;
            carry = addition/10;
            ListNode temp = new ListNode(digit);
            m.next=temp;
            m=m.next;
            if(p1!=null) {
                p1=p1.next;
            }
            if(p2!=null) {
                p2=p2.next;
            }
        }
        return dummy.next;
    }
}
