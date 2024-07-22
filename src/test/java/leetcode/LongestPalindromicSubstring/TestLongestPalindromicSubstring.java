package leetcode.LongestPalindromicSubstring;

import org.junit.jupiter.api.Test;

import static ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.old2ReallyHardJumpingProblem.old2ReallyHardJumpingProblemCode.leetcode.LongestPalindromicSubstring.LongestPalindromicSubstring.longestPalindromicSubstring;

public class TestLongestPalindromicSubstring {
    @Test
    void testLongestPalindromicSubstring(){
        longestPalindromicSubstring("abacab");
    }
    @Test
    void testLongestPalindromicSubstring2(){
        longestPalindromicSubstring("abaccb");
    }
    @Test
    void testLongestPalindromicSubstring3(){
        longestPalindromicSubstring("cc");
    }
    @Test
    void testLongestPalindromicSubstring4(){
        longestPalindromicSubstring("cbbd");
    }
}
