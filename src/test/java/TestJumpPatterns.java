import com.google.gson.Gson;
import org.example.SolitaireNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestJumpPatterns {

    @Test
    void solataireNumbers() {
        Assertions.assertEquals(1, SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0}));
    }

    @Test
    void solataireNumbersX3() {
        Assertions.assertEquals(9, SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7, -14, -80, 1}));
    }
    @Test
    void solataireNumbersX4() {
        Assertions.assertEquals(21, SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7, -14, -80, 1, 12}));
    }

    @Test
    void solataireNumbersX5() {
        Assertions.assertEquals(-15, SolitaireNumbers.solitaireNumbers(new int[]{-1, -2, -1, -7, -14, -80, -2, -2, -1, -12}));
    }

    @Test
    void solataireNumbersX6() {
        Assertions.assertEquals(-15, SolitaireNumbers.solitaireNumbers(new int[]{-1, -2, -1, -7, -14, -80, -2, -2, -1, -12}));
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
        Assertions.assertEquals(27, SolitaireNumbers.solitaireNumbers(
                arrayList.stream().mapToInt(i -> i).toArray()
        ));
    }
}
