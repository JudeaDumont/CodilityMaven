package ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.old2ReallyHardJumpingProblem;

import ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.old2ReallyHardJumpingProblem.old2ReallyHardJumpingProblemCode.Old2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestSolutionWith66Hops {

    @Disabled
    @Test
    void TestSolutionWith66Hops() {
        Old2 s = new Old2();
        int[] a = new int[66];
        Arrays.fill(a, -2);
        s.solution(a);
    }
}
