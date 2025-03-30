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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // left 이전 값을 기억한다. left 값도 기억한다.
        // left + 1 부터 right 까지는..
        // left 이전 값 '뒤에' 새로운 값들을 붙인다.
        // left 값의 next를 새로운 값의 next로 교체한다.
        // 새로운 값의 next를 left로 교체한다.
        ListNode dummy = new ListNode(-1, head);
        ListNode current = dummy;
        for (int i = 1; i < left; i++) {
            current = current.next;
        }
        ListNode beforeLeft = current;
        ListNode leftNode = beforeLeft.next;
        if (leftNode == null || leftNode.next == null) {
            return head;
        }
        ListNode tail = leftNode;
        current = leftNode.next;
        for (int i = left; i < right; i++) {
            leftNode.next = current.next;
            beforeLeft.next = current;
            current.next = tail;
            tail = current;
            current = leftNode.next;
            System.out.println(tail.val);
        }
        return dummy.next;
    }
}