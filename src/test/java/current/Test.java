package current;

import org.example.current.Solution;
import org.example.old.OldSolitaireNumbers;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class Test {
    @org.junit.jupiter.api.Test
    void solataireNumbers() {
        Solution s = new Solution();
        Assertions.assertEquals(6, s.solution(new int[]{1, 2, 3}));

        Assertions.assertEquals(2, s.solution(new int[]{1, -2, -2, -2, -2, -2, 1}));

        Assertions.assertEquals(3, s.solution(new int[]{1, -2, -2, -2, -2, -2, 1, -2, -2, -2, -2, -2, 1}));
    }

}