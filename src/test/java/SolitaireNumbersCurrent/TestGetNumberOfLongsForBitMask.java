package SolitaireNumbersCurrent;

import org.example.SolitaireNumbersCurrent.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestGetNumberOfLongsForBitMask {
    @Test
    void TestGetNumberOfLongsForBitMask() {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.getNumberOfLongsForBitMask(
                new int[]{1, -2, 0}
        ));

        int[] sixtyThree = new int[63];
        Arrays.fill(sixtyThree, 1);
        Assertions.assertEquals(1, s.getNumberOfLongsForBitMask(
                sixtyThree
        ));

        int[] sixtyFour = new int[64];
        Arrays.fill(sixtyFour, 1);
        Assertions.assertEquals(2, s.getNumberOfLongsForBitMask(
                sixtyFour
        ));
    }
}
