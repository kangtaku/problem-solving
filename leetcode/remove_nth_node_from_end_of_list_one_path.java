/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head,right = head;
        while (n-- > 0) {
            right = right.next;
        }
        if (right == null) return head.next;
        right = right.next;
        
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;

        return head;
    }
}
