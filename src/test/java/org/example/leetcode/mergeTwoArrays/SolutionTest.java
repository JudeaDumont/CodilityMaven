package org.example.leetcode.mergeTwoArrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void Test(){
        Solution solution = new Solution();
        int[] a = {1, 2, 3, 0, 0, 0};
        solution.mergeTwoArrays(a, new int[]{2, 5, 6});
        Assertions.assertArrayEquals(a, new int[]{1, 2, 2, 3, 5, 6});
    }
}