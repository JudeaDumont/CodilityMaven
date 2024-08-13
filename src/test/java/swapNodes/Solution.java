package swapNodes;

import leetcode.mergeTwoLists.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr!= null && curr.next != null) {
            ListNode temp = curr.next.next;
            curr.next.next = curr;
            if (prev != null) {
                prev.next = curr.next;
            } else {
                head = curr.next;
            }
            curr.next = temp;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}