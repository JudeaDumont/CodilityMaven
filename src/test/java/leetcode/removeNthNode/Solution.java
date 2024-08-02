package leetcode.removeNthNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        if (n == list.size()) {
            head = head.next;
        } else if (!(list.size() - n + 1 > list.size() - 1)) {
            list.get(list.size() - n - 1).next = list.get(list.size() - n + 1);
        } else {
            list.get(list.size() - n - 1).next = null;
        }

        return head;
    }
}