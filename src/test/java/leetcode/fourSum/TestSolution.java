package leetcode.fourSum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestSolution {
    @Test
    void testSolution() {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
    }

    @Test
    void testSolution2() {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        System.out.println(lists);
    }

    @Test
    void testSolution3() {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
        Assertions.assertEquals(lists.size(), 2);
    }

    //Between the below two tests is why my solution does not work.
    @Test
    void testSolution4() {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{-3,-1,0,2,4,5}, 2);
        Assertions.assertEquals(lists.size(), 1);
    }


    @Test
    void testSolution5() {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{-3,-1,0,2,4,5}, 1);
        Assertions.assertEquals(lists.size(), 1);
    }
}
