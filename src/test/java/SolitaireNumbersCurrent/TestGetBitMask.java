package SolitaireNumbersCurrent;

import org.example.SolitaireNumbersCurrent.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestGetBitMask {
    @Test
    void TestGetBitmask() {
        Solution s = new Solution();
        Assertions.assertEquals("[0]", Arrays.toString(s.getBitmask(
                1
        )));
    }
}
