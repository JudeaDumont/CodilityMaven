package leetcode.CorrectAssignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.old2ReallyHardJumpingProblem.old2ReallyHardJumpingProblemCode.leetcode.FastStringTraversal.CorrectAssignment.lengthOfLongestSubstring;


public class TestLengthOfLongestSubstring {
    @Test
    void testFastestStringTraversal() {
        int i = lengthOfLongestSubstring("dvdf");
        Assertions.assertEquals(i, 3);
    }
    @Test
    void testFastestStringTraversal1() {
        int i = lengthOfLongestSubstring("fdvdf");
        Assertions.assertEquals(i, 3);
    }
    @Test
    void testFastestStringTraversal2() {
        int i = lengthOfLongestSubstring("abcabc");
        Assertions.assertEquals(i, 3);
    }
    @Test
    void testFastestStringTraversal3() {
        int i = lengthOfLongestSubstring("aaaaac");
        Assertions.assertEquals(i, 2);
    }
}
