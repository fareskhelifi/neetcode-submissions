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
        List<Integer> values = new ArrayList<>();
        ListNode dummy = head;
        while (dummy != null) {
            values.add(dummy.val);
            dummy = dummy.next;
        }

        int length = values.size();

        List<Integer> reordered = new ArrayList<>();
        int left = 0, right = length - 1;
        while (left < right) {
            reordered.add(values.get(left));
            reordered.add(values.get(right));
            left++;
            right--;
        }
        if (left == right) {
            reordered.add(values.get(left));
        }

        ListNode curr = head;
        for (int i = 0; i < length; i++) {
            curr.val = reordered.get(i);
            curr = curr.next;
        }
    }
}
