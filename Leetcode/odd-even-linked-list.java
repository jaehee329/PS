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
    public ListNode oddEvenList(ListNode head) {
        /*
        odd의 맨 처음을 기억했다가 return한다.
        odd의 맨 끝을 기억했다가 다음 odd를 붙인다.
        even의 맨 처음을 기억했다가 새로 붙은 odd의 맨 끝과 계속 이어붙인다.
        even의 맨 끝을 기억했다가 다음 even을 붙인다.
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;
        ListNode current = head.next.next; // 세 번째에서 시작
        boolean odd = true;
        while (current != null) {
            ListNode next = current.next;
            if (odd) {
                oddTail.next = current;
                oddTail = current;
                oddTail.next = evenHead;
                evenTail.next = next;
                current = next;
            } else {
                evenTail = current;
                current = next;
            }
            odd = !odd;
        }
        return oddHead;
    }
}