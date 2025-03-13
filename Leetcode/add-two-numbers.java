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
        ListNode tail = new ListNode();
        ListNode first = tail;
        boolean up = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (up ? 1 : 0);
            if (sum >= 10) {
                up = true;
                sum -= 10;
            } else {
                up = false;
            }
            tail.next = new ListNode(sum);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode head3 = null;
        if (l1 != null) {
            head3 = l1;
        } else if (l2 != null) {
            head3 = l2;
        }
        while (head3 != null) {
            int sum = head3.val + (up ? 1 : 0);
            if (sum >= 10) {
                up = true;
                sum -= 10;
            } else {
                up = false;
            }
            tail.next = new ListNode(sum);
            tail = tail.next;
            head3 = head3.next;
        }
        if (up) {
            tail.next = new ListNode(1);
        }
        return first.next;
    }

}