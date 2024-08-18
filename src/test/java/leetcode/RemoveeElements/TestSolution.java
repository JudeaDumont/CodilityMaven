package leetcode.RemoveeElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestSolution {
    @Test
    void testSolution(){
        Solution solution = new Solution();
        int[] nums = {3, 2, 2, 3};
        int k = solution.removeElement(nums, 3);
        Assertions.assertEquals(k, 2);
        Assertions.assertArrayEquals(Arrays.copyOfRange(nums, 0, k), new int[]{2, 2});
    }
    @Test
    void testSolution2(){
        Solution solution = new Solution();
        int[] nums = {3, 2, 2};
        int k = solution.removeElement(nums, 3);
        Assertions.assertEquals(k, 2);
        Assertions.assertArrayEquals(Arrays.copyOfRange(nums, 0, k), new int[]{2, 2});
    }
    @Test
    void testSolution3(){
        Solution solution = new Solution();
        int[] nums = {3, 3, 2, 2};
        int k = solution.removeElement(nums, 3);
        Assertions.assertEquals(k, 2);
        Assertions.assertArrayEquals(Arrays.copyOfRange(nums, 0, k), new int[]{2, 2});
    }
    @Test
    void testSolution4(){
        Solution solution = new Solution();
        int[] nums = {3, 2, 3, 3, 2};
        int k = solution.removeElement(nums, 3);
        Assertions.assertEquals(k, 2);
        Assertions.assertArrayEquals(Arrays.copyOfRange(nums, 0, k), new int[]{2, 2});
    }
    @Test
    void testSolution5(){
        Solution solution = new Solution();
        int[] nums = {3, 2, 2, 3, 3};
        int k = solution.removeElement(nums, 3);
        Assertions.assertEquals(k, 2);
        Assertions.assertArrayEquals(Arrays.copyOfRange(nums, 0, k), new int[]{2, 2});
    }
    @Test
    void testSolution6(){
        Solution solution = new Solution();
        int[] nums = {2, 2};
        int k = solution.removeElement(nums, 3);
        Assertions.assertEquals(k, 2);
        Assertions.assertArrayEquals(Arrays.copyOfRange(nums, 0, k), new int[]{2, 2});
    }
}
