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
        int count = countNodes(head);
        int nth = count - n;
        ListNode ans = head;
        // System.out.println(nth);
        while (nth > 1) {
            head = head.next;
            nth--;
        }
        //System.out.println(head.val);
        if (nth == 0) {
            return head.next;
        }
        head.next = head.next.next;
        return ans;
    }
    
    public int countNodes(ListNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.next);
    }
}
