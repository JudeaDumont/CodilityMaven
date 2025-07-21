package leetcode.NextPermutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSolution {
    @Test
    public void testNextPermutation() {
        int[] nums = {1, 2, 3};

        Solution solution = new Solution();
        solution.nextPermutation(nums);

        int[] expectedNums = {1, 3, 2};
        assertArrayEquals(expectedNums, nums, "The array after removing duplicates should contain 1 and 2.");
    }
    @Test
    public void testNextPermutation2() {
        int[] nums = {3,2,1};

        Solution solution = new Solution();
        solution.nextPermutation(nums);

        int[] expectedNums = {1, 2, 3};
        assertArrayEquals(expectedNums, nums, "The array after removing duplicates should contain 1 and 2.");
    }
    @Test
    public void testNextPermutation3() {
        int[] nums = {1,1,5};

        Solution solution = new Solution();
        solution.nextPermutation(nums);

        int[] expectedNums = {1,5,1};
        assertArrayEquals(expectedNums, nums, "The array after removing duplicates should contain 1 and 2.");
    }
}
