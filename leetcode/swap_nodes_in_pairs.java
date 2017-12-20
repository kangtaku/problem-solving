/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode list) {
        ListNode head = new ListNode(0);
        head.next = list;
        ListNode tail = head;
        
        while (tail.next != null && tail.next.next != null) {
            ListNode first = tail.next;
            ListNode second = tail.next.next;
            first.next = second.next;
            second.next = first;
            tail.next = second;
            tail = tail.next.next;
        }
        
        return head.next;
    }
}
