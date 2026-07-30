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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        List<Integer> values = new ArrayList<>();

        for (ListNode list : lists) {
            while (list != null) {
                values.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(values);
        ListNode result = new ListNode();
        ListNode dummy = result;
        for (int val : values) {
            dummy.next = new ListNode(val);
            dummy = dummy.next;
        }
        return result.next;

    }
}
