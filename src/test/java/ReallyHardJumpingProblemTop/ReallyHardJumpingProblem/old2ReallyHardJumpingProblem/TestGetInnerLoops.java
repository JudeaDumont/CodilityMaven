package ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.old2ReallyHardJumpingProblem;

import ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.old2ReallyHardJumpingProblem.old2ReallyHardJumpingProblemCode.Old2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestGetInnerLoops {
    @Test
    void TestGetBitmask() {
        Old2 s = new Old2();
        long[] innerLoops = s.getInnerLoops(
                3, 2
        );
        Assertions.assertEquals(
                "111111111111111111111111111111111111111111111111111111111111111",
                Long.toBinaryString(innerLoops[0]));
        Assertions.assertEquals(
                "111",
                Long.toBinaryString(innerLoops[1]));
        Assertions.assertEquals("[9223372036854775807, 7]", Arrays.toString(innerLoops));
    }
}
