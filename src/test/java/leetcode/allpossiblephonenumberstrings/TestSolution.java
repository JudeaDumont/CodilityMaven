package leetcode.allpossiblephonenumberstrings;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TestSolution {
    @Test
    void testSolution() {
        Solution solution = new Solution();
        List<String> solution1 = solution.letterCombinations("234");
    }

    @Test
    void testSolution2() {
        Solution solution = new Solution();
        List<String> solution1 = solution.letterCombinations("2");
    }

    @Test
    void testSolution3() {
        Solution solution = new Solution();
        List<String> solution1 = solution.letterCombinations("");
    }
}
