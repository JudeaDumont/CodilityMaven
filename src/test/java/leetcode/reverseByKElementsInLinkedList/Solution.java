package leetcode.reverseByKElementsInLinkedList;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode[] array = new ListNode[k];
        int count = 0;
        ListNode curr = head;
        ListNode last = null;
        ListNode nextCurr = null;

        while (curr != null) {
            array[count++] = curr;
            if (count == k) {
                ListNode n = array[--count];
                nextCurr = n.next;
                if (last != null) {
                    last.next = n;
                } else {
                    head = n;
                }
                while (count > 0) {
                    n.next = array[--count];
                    n = n.next;
                }
                last = n;
                n.next = nextCurr;
                curr = nextCurr;
            } else {
                curr = curr.next;
            }
        }

        if (count == 0) {
            assert last != null;
            last.next = null;
        }

        return head;
    }
}
