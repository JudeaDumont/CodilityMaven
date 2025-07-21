package leetcode.firstOccurrence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static leetcode.FastStringTraversal.FastStringTraversal.Solution.lengthOfLongestSubstring;

public class TestFirstOccurrence {
    @Test
    void testFastestStringTraversal() {
        Solution solution = new Solution();
        Assertions.assertEquals(2,solution.strStr("hello", "ll"));
    }
}
