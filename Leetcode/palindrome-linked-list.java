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
    public boolean isPalindrome(ListNode head) {
        // 1. runner로 중간 지점을 찾는다
        // 1.1 노드 수가 홀수라면? 1 -> 2 -> 3 -> 2 -> 1
        // 1.2 fast는 초과, slow는 3, 중간
        // 1.3 노드 수가 짝수라면? 1 -> 2 -> 2 -> 1 : fast는 마지막인 1, slow는 2 중간
        // 1.4 탐색은 fast가 마지막이거나 마지막을 초과할 때까지 진행하며, 탐색 종료 뒤 slow의 next부터를 뒤집는다.
        // 2. 중간부터 끝까지를 뒤집는다
        // 2.1 중간 노드를 current에 저장, 다음 노드 next의 다음을 미리 저장, next.next를 current로 교체한다.
        // 3. 처음부터와 중간부터를 비교한다.
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;

        ListNode cur = mid.next;
        ListNode tail = cur;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = tail;
            tail = next;
        }
        mid.next = tail;

        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        while (rightHead != null) {
            if (leftHead.val != rightHead.val) {
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }
}