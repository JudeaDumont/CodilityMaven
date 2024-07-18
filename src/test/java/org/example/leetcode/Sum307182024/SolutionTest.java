package org.example.leetcode.Sum307182024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    void Test() {
        Solution solution = new Solution();
        int[][] k = solution.sum3(new int[]{-1,0,1,2,-1,-4});
        int[][] expected = {new int[]{-1, -1, 2}, new int[]{-1, 0, 1}};
        Assertions.assertArrayEquals(expected, k);
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        int[][] k = solution.sum3(new int[]{-1,-1,-1,-3,0,3});
        int[][] expected = {new int[]{-3,0,3}};
        Assertions.assertArrayEquals(expected, k);
    }
}
