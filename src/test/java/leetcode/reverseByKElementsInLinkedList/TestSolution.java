package leetcode.reverseByKElementsInLinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSolution {
    @Test
    void testSolution() {
        Solution solution = new Solution();
        ListNode node = solution.reverseKGroup(new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6,
                                                                null)))))),
                2);
        Assertions.assertEquals(node.print(), "2, 1, 4, 3, 6, 5, ");
    }
    @Test
    void testSolution3() {
        Solution solution = new Solution();
        ListNode node = solution.reverseKGroup(new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        null))))),
                2);
        Assertions.assertEquals(node.print(), "2, 1, 4, 3, 5, ");
    }
    @Test
    void testSolution2() {
        Solution solution = new Solution();
        ListNode node = solution.reverseKGroup(new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6,
                                                                null)))))),
                3);
        Assertions.assertEquals(node.print(), "3, 2, 1, 6, 5, 4, ");
    }
}
