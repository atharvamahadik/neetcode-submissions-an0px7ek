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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list : lists) {
            if(list!=null) {
                minHeap.offer(list);
            }   
        }

        ListNode dummy = new ListNode(-1);
        ListNode m = dummy;

        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            if(temp.next!=null) {
                minHeap.offer(temp.next);
            }
            m.next = temp;
            m = m.next;
        }

        return dummy.next;
    }
}
