package leetcode.LongestPalindromicSubstring;

import org.junit.jupiter.api.Test;

import static leetcode.LongestPalindromicSubstring.LongestPalindromicSubstring.LongestPalindromicSubstring.longestPalindromicSubstring;

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
