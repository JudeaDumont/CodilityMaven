package org.example.leetcode.mergeTwoArrays;

import leetcode.NeedsAcceptance.mergeTwoArrays.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void Test() {
        Solution solution = new Solution();
        int[] a = {1, 2, 3, 0, 0, 0};
        solution.mergeTwoArrays(a, new int[]{2, 5, 6});
        Assertions.assertArrayEquals(a, new int[]{1, 2, 2, 3, 5, 6});
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        int[] a = {1, 2, 3, 6, 0, 0, 0, 0};
        solution.mergeTwoArrays(a, new int[]{0, 2, 5, 6});
        Assertions.assertArrayEquals(a, new int[]{0, 1, 2, 2, 3, 5, 6, 6});
    }
}