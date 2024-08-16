package leetcode.removeDuplicatesFromSrotedArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolution {
    @Test
    public void testRemoveDuplicates() {
        // Given
        int[] nums = {1, 1, 2};

        // When
        Solution removeDuplicates = new Solution();
        int newSize = removeDuplicates.removeDuplicates(nums);

        // Then
        assertEquals(2, newSize, "The size of the array after removing duplicates should be 2.");

        // The nums array should contain unique elements after the operation
        int[] expectedNums = {1, 2};
        assertArrayEquals(expectedNums, Arrays.copyOfRange(nums, 0, newSize), "The array after removing duplicates should contain 1 and 2.");
    }

    @Test
    public void testRemoveDuplicates2() {
        // Given
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        // When
        Solution removeDuplicates = new Solution();
        int newSize = removeDuplicates.removeDuplicates(nums);

        // Then
        assertEquals(5, newSize, "The size of the array after removing duplicates should be 2.");

        // The nums array should contain unique elements after the operation
        int[] expectedNums = {0, 1, 2, 3, 4};
        assertArrayEquals(expectedNums, Arrays.copyOfRange(nums, 0, newSize), "The array after removing duplicates should contain 1 and 2.");
    }

    @Test
    public void testRemoveDuplicates3() {
        // Given
        int[] nums = {0, 1};

        // When
        Solution removeDuplicates = new Solution();
        int newSize = removeDuplicates.removeDuplicates(nums);

        // Then
        assertEquals(2, newSize, "The size of the array after removing duplicates should be 2.");

        // The nums array should contain unique elements after the operation
        int[] expectedNums = {0, 1};
        assertArrayEquals(expectedNums, Arrays.copyOfRange(nums, 0, newSize), "The array after removing duplicates should contain 1 and 2.");
    }

    @Test
    public void testRemoveDuplicates4() {
        // Given
        int[] nums = {1, 1, 1};

        // When
        Solution removeDuplicates = new Solution();
        int newSize = removeDuplicates.removeDuplicates(nums);

        // Then
        assertEquals(1, newSize, "The size of the array after removing duplicates should be 2.");

        // The nums array should contain unique elements after the operation
        int[] expectedNums = {1};
        assertArrayEquals(expectedNums, Arrays.copyOfRange(nums, 0, newSize), "The array after removing duplicates should contain 1 and 2.");
    }

    @Test
    public void testRemoveDuplicates5() {
        // Given
        int[] nums = {1, 2, 3};

        // When
        Solution removeDuplicates = new Solution();
        int newSize = removeDuplicates.removeDuplicates(nums);

        // Then
        assertEquals(3, newSize, "The size of the array after removing duplicates should be 2.");

        // The nums array should contain unique elements after the operation
        int[] expectedNums = {1, 2, 3};
        assertArrayEquals(expectedNums, Arrays.copyOfRange(nums, 0, newSize), "The array after removing duplicates should contain 1 and 2.");
    }
}
