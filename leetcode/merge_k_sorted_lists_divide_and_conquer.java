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
        return daq(lists, 0, lists.length - 1);
    }
    
    public ListNode daq(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        
        if (l < r) {
            int mid = (l + r) >> 1;
            ListNode left = daq(lists, l, mid);
            ListNode right = daq(lists, mid + 1, r);
            return merge(left, right);
        }
        return null;
    }
    
    public ListNode merge(ListNode x, ListNode y) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        while (x != null && y != null) {
            if (x.val > y.val) {
                tail.next = y;
                y = y.next;
            } else {
                tail.next = x;
                x = x.next;
            }
            tail = tail.next;
        }
        if (x != null) tail.next = x;
        else tail.next = y;
        return head.next;
    }
}
