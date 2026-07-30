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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyLength = head;
        ListNode curr = head;
        int length = calculateLength(dummyLength);
        int index = length - n;

        if (index == 0) {
            curr = curr.next;
            head.next = null;
            head = curr;
            return head;
        }

        ListNode prev = null;
        while (index != 0) {
            prev = curr;
            curr = curr.next;
            index--;
        }

        prev.next = curr.next;
        curr.next = null;
        return head;
    }

    public int calculateLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
