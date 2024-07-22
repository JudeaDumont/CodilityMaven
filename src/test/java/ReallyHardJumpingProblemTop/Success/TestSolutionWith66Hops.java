package ReallyHardJumpingProblemTop.Success;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestSolutionWith66Hops {

    @Test
    void TestSolutionWith66Hops() {
        SolutionX s = new SolutionX();
        int[] a = new int[66];
        Arrays.fill(a, -2);
        s.solution(a);
    }
}
