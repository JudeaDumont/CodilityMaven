package org.example.leetcode.mergeTwoArrays;

import org.example.leetcode.TOP150INTERVIEW.NeedsAcceptance.removeValue.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    @Test
    void Test() {
        Solution solution = new Solution();
        int[] a = {0, 1, 2, 2, 3, 0, 4, 2};
        int k = solution.removeValue(a, 2);
        Assertions.assertEquals(k, 5);
        int[] ints = Arrays.copyOfRange(a, 0, k);
        Arrays.sort(ints);
        Assertions.assertArrayEquals(ints, new int[]{0, 0, 1, 3, 4});
    }
}