package ReallyHardJumpingProblemTop.ReallyHardJumpingProblem;

import ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.reallyhardjumpingproblemCode.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGetPositiveRun {
    @Test
    void testGetPositiveRun(){
        Solution s = new Solution();
        int currentRunTotal = 2;
        currentRunTotal = s.getPositiveRun(new int[]{1, -2, -2, -2, -2, -2, -2, 1}, currentRunTotal, new boolean[8]);

        Assertions.assertEquals(2, currentRunTotal);
    }
    @Test
    void testGetPositiveRun2(){
        Solution s = new Solution();
        int currentRunTotal = 2;
        currentRunTotal = s.getPositiveRun(new int[]{1, -2, -2, -2, 1, -2, -2, 1}, currentRunTotal, new boolean[8]);

        Assertions.assertEquals(3, currentRunTotal);
    }
}
