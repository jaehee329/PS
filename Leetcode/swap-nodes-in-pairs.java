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
    public ListNode swapPairs(ListNode head) {
        ListNode first = new ListNode(0, head);
        ListNode cur = first;
        while (cur != null && cur.next != null && cur.next.next != null) {
            ListNode next1 = cur.next;
            ListNode next2 = next1.next;
            cur.next = next2;
            next1.next = next2.next;
            next2.next = next1;
            cur = next1;
        }
        return first.next;
    }
}