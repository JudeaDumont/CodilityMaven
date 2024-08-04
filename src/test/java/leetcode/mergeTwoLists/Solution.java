package leetcode.mergeTwoLists;


public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode mergeHead = curr1.val <= curr2.val ? curr1 : curr2;
        if (mergeHead == curr1) {
            curr1 = curr1.next;
        } else {
            curr2 = curr2.next;
        }
        ListNode mergeCurr = mergeHead;
        while (curr1 != null || curr2 != null) {
            if (curr1!=null && (curr2 == null || curr1.val < curr2.val)) {
                mergeCurr.next = curr1;
                curr1 = curr1.next;
            } else {
                mergeCurr.next = curr2;
                curr2 = curr2.next;
            }
            mergeCurr = mergeCurr.next;
        }
        return mergeHead;
    }
}
