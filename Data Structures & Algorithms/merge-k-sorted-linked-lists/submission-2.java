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
        if (lists == null || lists.length == 0) return null;
        
        while (lists.length > 1) {
            ListNode[] mergedLists = new ListNode[(lists.length + 1) / 2];
            int j = 0;
            for (int i = 0; i < lists.length; i+=2) {
                ListNode list1 = lists[i];
                ListNode list2 = (i + 1 < lists.length) ? lists[i + 1] : null;
                mergedLists[j++] = mergeTwoLists(list1, list2);
            }    
            lists = mergedLists;
        }
        
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = (list1 == null) ? list2 : list1;
        return result.next;
    }
}
