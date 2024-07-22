package ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.oldReallyHardJumpingProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.oldReallyHardJumpingProblem.oldReallyHardJumpingProblemCode.OldSolitaireNumbers2.*;

public class TestSolitaireNumbers {
    @Test
    void TestGetBitMap() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Assertions.assertEquals("111", getPositiveBitMap(
                new int[]{1, -2, 0})
        );
    }

    @Test
    void TestGetJumps() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Assertions.assertEquals(-1, getAllJumps("111",
                new int[]{1, -2, 0})
        );
    }

    @Test
    void TestGetInbetweenDigits() {
        Assertions.assertEquals("1", getInbetweenDigits("111"));
    }

    @Test
    void TestIsConformentPattern() {
        Assertions.assertEquals(true, isConformentPattern("1000001"));
    }

    @Test
    void TestIsConformentPatternFalse() {
        Assertions.assertEquals(false, isConformentPattern("10000001"));
    }

    @Test
    void TestSolitaireNumbers3() {
        Assertions.assertEquals(1, solitaireNumbers(new int[]{1, -2, 0}));
    }

    @Test
    void TestSolitaireNumbers8() {
        Assertions.assertEquals(21, solitaireNumbers(new int[]{1, -2, 0, 7, -14, -80, 1, 12}));
    }

    @Test
    void solataireNumbersX10() {
        Assertions.assertEquals(-15, solitaireNumbers(new int[]{-1, -2, -1, -7, -14, -80, -2, -2, -1, -12}));
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
        Assertions.assertEquals(27, solitaireNumbers(
                arrayList.stream().mapToInt(i -> i).toArray()
        ));
    }

    @Test
    void TestGetBinaryString() {
        Assertions.assertEquals("00000001", getBinaryString(1, 8));
    }

    @Test
    void TestGetBinaryString2() {
        Assertions.assertEquals("00000001", getBinaryString(1, 8));
    }


    @Disabled
    @Test
    void solataireNumbersHuge7X() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(27);
        for (int i = 0; i < 5; i++) {
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(-1);
            arrayList.add(0);
        }
        Assertions.assertEquals(27, solitaireNumbers(
                arrayList.stream().mapToInt(i -> i).toArray()
        ));
    }

}
