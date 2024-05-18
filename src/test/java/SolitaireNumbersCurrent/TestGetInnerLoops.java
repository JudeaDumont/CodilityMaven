package SolitaireNumbersCurrent;

import org.example.SolitaireNumbersCurrent.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestGetInnerLoops {
    @Test
    void TestGetBitmask() {
        Solution s = new Solution();
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
