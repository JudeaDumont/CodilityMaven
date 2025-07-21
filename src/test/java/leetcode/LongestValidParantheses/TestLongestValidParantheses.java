package leetcode.LongestValidParantheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static leetcode.LongestPalindromicSubstring.LongestPalindromicSubstring.LongestPalindromicSubstring.longestPalindromicSubstring;

public class TestLongestValidParantheses {
    @Test
    void testLongestValidParantheses(){
        Solution solution = new Solution();
        int i = solution.longestValidParentheses("))()()(()");
        Assertions.assertEquals(4, i);
    }
}
