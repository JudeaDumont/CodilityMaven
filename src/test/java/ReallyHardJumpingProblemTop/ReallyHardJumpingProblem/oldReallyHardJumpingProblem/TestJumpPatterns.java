package ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.oldReallyHardJumpingProblem;

import ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.oldReallyHardJumpingProblem.oldReallyHardJumpingProblemCode.OldSolitaireNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestJumpPatterns {

    @Test
    void solataireNumbers() {
        Assertions.assertEquals(1, OldSolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0}));
    }

    @Test
    void solataireNumbersX3() {
        Assertions.assertEquals(9, OldSolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7, -14, -80, 1}));
    }
    @Test
    void solataireNumbersX4() {
        Assertions.assertEquals(21, OldSolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7, -14, -80, 1, 12}));
    }

    @Test
    void solataireNumbersX5() {
        Assertions.assertEquals(-15, OldSolitaireNumbers.solitaireNumbers(new int[]{-1, -2, -1, -7, -14, -80, -2, -2, -1, -12}));
    }

    @Test
    void solataireNumbersX6() {
        Assertions.assertEquals(-15, OldSolitaireNumbers.solitaireNumbers(new int[]{-1, -2, -1, -7, -14, -80, -2, -2, -1, -12}));
    }

    @Test
    void solataireNumbersHuge() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(27);
        for (int i = 0; i < 3; i++) {
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(0);
        }
        Assertions.assertEquals(27, OldSolitaireNumbers.solitaireNumbers(
                arrayList.stream().mapToInt(i -> i).toArray()
        ));
    }

    @Test
    void solataireNumbersHuge10X() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(27);
        for (int i = 0; i < 30; i++) {
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(0);
        }
        Assertions.assertEquals(27, OldSolitaireNumbers.solitaireNumbers(
                arrayList.stream().mapToInt(i -> i).toArray()
        ));
    }
}
