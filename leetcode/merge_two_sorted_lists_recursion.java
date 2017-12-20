/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode resTail = res;
        if (l2 == null) {
            return l1;
        } else if (l1 == null) {
            return l2;
        }
        
        if (l1.val < l2.val) {
            resTail.next = l1;
            resTail = resTail.next;
            resTail.next = mergeTwoLists(l1.next, l2);
        } else {
            resTail.next = l2;
            resTail = resTail.next;
            resTail.next = mergeTwoLists(l1, l2.next);
        }
        
        return res.next;
    }
}
