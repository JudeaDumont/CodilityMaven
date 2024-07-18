package org.example.leetcode.Sum307182024.ConformantVersion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    void Test() {
        Solution solution = new Solution();
        List<List<Integer>> k = solution.threeSum(new int[]{-1,0,1,2,-1,-4});
        List<List<Integer>> expected = List.of(Arrays.stream(new int[]{-1, -1, 2}).boxed().toList(),
                Arrays.stream(new int[]{-1, 0, 1}).boxed().toList());
        Assertions.assertEquals(k, expected);
    }

    @Test
    void Test2() {
        Solution solution = new Solution();
        List<List<Integer>> k = solution.threeSum(new int[]{-1,-1,-1,3,0,-3});
        List<List<Integer>> expected = List.of(Arrays.stream(new int[]{-3,0,3}).boxed().toList());
        Assertions.assertEquals(k, expected);
    }
}
