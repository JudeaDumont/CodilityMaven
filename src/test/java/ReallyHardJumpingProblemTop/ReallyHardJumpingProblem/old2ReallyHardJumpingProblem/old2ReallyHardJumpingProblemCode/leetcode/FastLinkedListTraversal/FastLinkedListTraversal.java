package ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.old2ReallyHardJumpingProblem.old2ReallyHardJumpingProblemCode.leetcode.FastLinkedListTraversal;

public class FastLinkedListTraversal {
    class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();
            ListNode current = result;
            int carry = 0;
            boolean run = true;
            while (run) {
                if (l1 == null) {
                    l1 = new ListNode();
                }
                if (l2 == null) {
                    l2 = new ListNode();
                }
                int val = l1.val + l2.val + carry;
                carry = val / 10;
                if (val > 9) {
                    val %= 10;
                }
                current.val = val;
                l1 = l1.next;
                l2 = l2.next;

                if (l1 != null || l2 != null || carry != 0) {
                    current.next = new ListNode();
                    current = current.next;
                } else {
                    run = false;
                }
            }
            return result;
        }
    }
}
