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
        ListNode ansHead = new ListNode(0);
        ListNode ansTail = ansHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ansTail.next = l1;
                l1 = l1.next;
            } else if (l1.val >= l2.val) {
                ansTail.next = l2;
                l2 = l2.next;
            }
            ansTail = ansTail.next;
        }
        if (l1 != null) ansTail.next = l1;
        else ansTail.next = l2;
        return ansHead.next;
    }
}
