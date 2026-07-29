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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode dummy = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        } 

        ListNode secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverseList(secondHalf);

        ListNode firstNext, secondNext;
        while (secondHalf != null) {
            firstNext = dummy.next;
            secondNext = secondHalf.next;

            dummy.next = secondHalf;
            secondHalf.next = firstNext;
            dummy = firstNext;
            secondHalf = secondNext;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
