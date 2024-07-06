package org.example.leetcode.removeDuplicates;

import org.example.leetcode.TOP150INTERVIEW.NeedsAcceptance.removeDuplicates.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    void Test() {
        Solution solution = new Solution();
        int[] a = {0,0,1,1,2,2,2,3,3,4,4};
        int k = solution.removeDuplicates(a);
        Assertions.assertEquals(k, 5);
        int[] ints = Arrays.copyOfRange(a, 0, k);
        Assertions.assertArrayEquals(ints, new int[]{0, 1, 2, 3, 4});
    }
    @Test
    void Test2() {
        Solution solution = new Solution();
        int[] a = {0,0,1,1,2,2,2,3,3,4,4, 5, 6, 7, 7};
        int k = solution.removeDuplicates(a);
        Assertions.assertEquals(k, 8);
        int[] ints = Arrays.copyOfRange(a, 0, k);
        Assertions.assertArrayEquals(ints, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
    }
}
