package leetcode.FastStringTraversal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static leetcode.FastStringTraversal.FastStringTraversal.Solution.lengthOfLongestSubstring;

public class TestFastestStringTraversal {
    @Test
    void testFastestStringTraversal() {
        int i = lengthOfLongestSubstring("abc");
        Assertions.assertEquals(i, 3);
    }
    @Test
    void testFastestStringTraversal2() {
        int i = lengthOfLongestSubstring("aabc");
        Assertions.assertEquals(i, 3);
    }
    @Test
    void testFastestStringTraversal3() {
        int i = lengthOfLongestSubstring("abbc");
        Assertions.assertEquals(i, 2);
    }
}
