package leetcode.mergeTwoLists;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    void testMergeTwoLists() {

        ListNode a= new ListNode(
                1, new ListNode(2, new ListNode(3)));
        ListNode b= new ListNode(
                0, new ListNode(2, new ListNode(3)));
        Solution solution = new Solution();
        solution.mergeTwoLists(a, b);
    }

}
