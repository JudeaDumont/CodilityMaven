package leetcode.reverseByKElementsInLinkedList;

import java.util.HashSet;
import java.util.Set;

public class ListNode {
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

    public String print() {
        Set<Integer> set = new HashSet<>();
        StringBuilder nodeString = new StringBuilder();
        ListNode curr = this;
        while (curr != null) {
            if (!set.contains(curr.val)) {
                set.add(curr.val);
            } else {
                throw new RuntimeException("Cycle: " + nodeString + ", " + curr.val);
            }
            nodeString.append(curr.val).append(", ");
            curr = curr.next;
        }
        System.out.println(nodeString);
        return nodeString.toString();
    }
}