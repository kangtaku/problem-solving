/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> {
            if (x.val > y.val) return 1;
            return -1;
        });
        
        for (ListNode item : lists) {
            if (item != null) {
                pq.add(item);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode list = pq.poll();
            tail.next = list;
            if (list.next != null) {
                pq.add(list.next);
            }
            tail = tail.next;
        }
        
        return head.next;
    }
}
