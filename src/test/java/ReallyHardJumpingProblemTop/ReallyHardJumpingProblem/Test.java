package ReallyHardJumpingProblemTop.ReallyHardJumpingProblem;

import ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.reallyhardjumpingproblemCode.Solution;
import org.junit.jupiter.api.Assertions;

public class Test {
    @org.junit.jupiter.api.Test
    void solataireNumbers() {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.solution(new int[]{1}));

        Assertions.assertEquals(3, s.solution(new int[]{1, 2}));

        Assertions.assertEquals(-1, s.solution(new int[]{1, -2}));

        Assertions.assertEquals(-3, s.solution(new int[]{-1, -2}));

        Assertions.assertEquals(6, s.solution(new int[]{1, 2, 3}));

        Assertions.assertEquals(2, s.solution(new int[]{1, -2, -2, -2, -2, -2, 1}));

        Assertions.assertEquals(3, s.solution(new int[]{1, -2, -2, -2, -2, -2, 1, -2, -2, -2, -2, -2, 1}));
    }

    @org.junit.jupiter.api.Test
    void solataireNumbersStageTwo() {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.solution(new int[]{1, -1, -3, -3, -3, -3, -3, -1, 2}));

        Assertions.assertEquals(2, s.solution(new int[]{1, -1, -3, -3, -1, -3, -3, -1, 2}));

        Assertions.assertEquals(2, s.solution(new int[]{1, -1, -1, -3, -3, -3, -3, -1, 2}));

        Assertions.assertEquals(2, s.solution(new int[]{1, -1, -3, -1, -3, -3, -3, -1, 2}));

        Assertions.assertEquals(2, s.solution(new int[]{1, -1, -3, -3, -3, -1, -3, -1, 2}));

        Assertions.assertEquals(2, s.solution(new int[]{1, -1, -3, -3, -3, -3, -1, -1, 2}));

        Assertions.assertEquals(2, s.solution(new int[]{2, -6, -5, -4, -3, -2, -1, 1}));
    }

    @org.junit.jupiter.api.Test
    void solataireNumbersStageThree() {
        Solution s = new Solution();
        Assertions.assertEquals(0, s.solution(new int[]{1, -1, -3, -3, -3, -3, -3, -3, -1, 2}));
        Assertions.assertEquals(1, s.solution(new int[]{1, -1, -1, -3, -3, -3, -3, -3, -1, 2}));
        Assertions.assertEquals(1, s.solution(new int[]{1, -1, -1, -3, -3, -3, -3, -1, -3, 2}));
        Assertions.assertEquals(2, s.solution(new int[]{1, -3, -3, -1, -3, -3, -3, -3, -3, 2}));
        Assertions.assertEquals(2, s.solution(new int[]{1, -3, -3, -3, -1, -3, -3, -3, -3, 2}));
        Assertions.assertEquals(2, s.solution(new int[]{1, -3, -3, -3, -3, -1, -3, -3, -3, 2}));
        Assertions.assertEquals(2, s.solution(new int[]{1, -3, -3, -3, -3, -3, -1, -3, -3, 2}));
        Assertions.assertEquals(0, s.solution(new int[]{1, -3, -3, -3, -3, -3, -3, -1, -3, 2}));
        Assertions.assertEquals(0, s.solution(new int[]{1, -1, -3, -3, -3, -3, -3, -3, -1, -3, 2}));
    }

    @org.junit.jupiter.api.Test
    void solataireNumbersStageFour() {
        Solution s = new Solution();
        Assertions.assertEquals(0, s.solution(new int[]{1, -3, -3, -3, -3, -3, -3, -3, -3, -3, 2}));
    }

    @org.junit.jupiter.api.Test
    void solataireNumbersStageFive() {
        Solution s = new Solution();
        Assertions.assertEquals(-5, s.solution(new int[]{-1, -1, -3, -3, -3, -3, -3, -1, -3, -3, -3, -2}));
        Assertions.assertEquals(-5, s.solution(new int[]{-1, -3, -1, -3, -3, -3, -3, -3, -1, -3, -3, -2}));
        Assertions.assertEquals(-5, s.solution(new int[]{-1, -3, -3, -1, -3, -3, -3, -3, -3, -1, -3, -2}));
        Assertions.assertEquals(-5, s.solution(new int[]{-1, -3, -3, -3, -1, -3, -3, -3, -3, -3, -1, -2}));
    }

    @org.junit.jupiter.api.Test
    void solataireNumbersStageSix() {
        Solution s = new Solution();
        Assertions.assertEquals(-6, s.solution(new int[]
                {-1, -1, -3, -3, -3, -3, -3, -1, -3, -3, -3, -3, -1, -3, -4, -2}
                //v00000v0000v00
        ));
    }
}
