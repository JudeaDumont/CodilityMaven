package current;

import org.example.current.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNeedsNegativeRun {
    @Test
    void testNeedsNegativeRun(){

        Solution s = new Solution();
        boolean actual = s.needsNegativeRun(new boolean[]{true, false, false, false, false, false, false, true});

        Assertions.assertTrue(actual);
    }
    @Test
    void testNeedsNegativeRun2(){

        Solution s = new Solution();
        boolean actual = s.needsNegativeRun(new boolean[]{true, false, false, false, false, false, true});

        Assertions.assertFalse(actual);
    }
}
