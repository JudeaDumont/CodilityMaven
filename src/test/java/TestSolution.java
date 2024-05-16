import com.google.gson.Gson;
import org.example.SolitaireNumbers;
import org.example.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TestSolution {
    @Test
    void solution1041() {
        Assertions.assertEquals(5, Solution.solution(1041));
    }

    @Test
    void solataireNumbers() {
        Assertions.assertEquals(8, SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0}));
    }

    @Test
    void solataireNumbersX() {
        Assertions.assertEquals(8, SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7}));
    }

    @Test
    void solataireNumbersX1() {
        Assertions.assertEquals(8, SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7, -14}));
    }

    @Test
    void solataireNumbersX2() {
        Assertions.assertEquals(8, SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7, -14, -80}));
    }

    @Test
    void solataireNumbersX3() {
        Assertions.assertEquals(8, SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7, -14, -80, 1}));
    }

    @Test
    void solataireNumbersX4() {
        Gson gson = new Gson();
        String result = gson.toJson(SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7, -14, -80, 1, 12}));
        Assertions.assertEquals(
                "[[1,1,1,1,1,1,1,1],[2,1,1,1,1,1,1],[1,2,1,1,1,1,1],[1,1,2,1,1,1,1],[1,1,1,2,1,1,1],[1,1,1,1,2,1,1],[1,1,1,1,1,2,1],[1,1,1,1,1,1,2],[3,1,1,1,1,1],[2,2,1,1,1,1],[2,1,2,1,1,1],[2,1,1,2,1,1],[2,1,1,1,2,1],[2,1,1,1,1,2],[1,3,1,1,1,1],[1,2,2,1,1,1],[1,2,1,2,1,1],[1,2,1,1,2,1],[1,2,1,1,1,2],[1,1,3,1,1,1],[1,1,2,2,1,1],[1,1,2,1,2,1],[1,1,2,1,1,2],[1,1,1,3,1,1],[1,1,1,2,2,1],[1,1,1,2,1,2],[1,1,1,1,3,1],[1,1,1,1,2,2],[1,1,1,1,1,3],[4,1,1,1,1],[3,2,1,1,1],[3,1,2,1,1],[3,1,1,2,1],[3,1,1,1,2],[2,3,1,1,1],[2,2,2,1,1],[2,2,1,2,1],[2,2,1,1,2],[2,1,3,1,1],[2,1,2,2,1],[2,1,2,1,2],[2,1,1,3,1],[2,1,1,2,2],[2,1,1,1,3],[1,4,1,1,1],[1,3,2,1,1],[1,3,1,2,1],[1,3,1,1,2],[1,2,3,1,1],[1,2,2,2,1],[1,2,2,1,2],[1,2,1,3,1],[1,2,1,2,2],[1,2,1,1,3],[1,1,4,1,1],[1,1,3,2,1],[1,1,3,1,2],[1,1,2,3,1],[1,1,2,2,2],[1,1,2,1,3],[1,1,1,4,1],[1,1,1,3,2],[1,1,1,2,3],[1,1,1,1,4],[5,1,1,1],[4,2,1,1],[4,1,2,1],[4,1,1,2],[3,3,1,1],[3,2,2,1],[3,2,1,2],[3,1,3,1],[3,1,2,2],[3,1,1,3],[2,4,1,1],[2,3,2,1],[2,3,1,2],[2,2,3,1],[2,2,2,2],[2,2,1,3],[2,1,4,1],[2,1,3,2],[2,1,2,3],[2,1,1,4],[1,5,1,1],[1,4,2,1],[1,4,1,2],[1,3,3,1],[1,3,2,2],[1,3,1,3],[1,2,4,1],[1,2,3,2],[1,2,2,3],[1,2,1,4],[1,1,5,1],[1,1,4,2],[1,1,3,3],[1,1,2,4],[1,1,1,5],[6,1,1],[5,2,1],[5,1,2],[4,3,1],[4,2,2],[4,1,3],[3,4,1],[3,3,2],[3,2,3],[3,1,4],[2,5,1],[2,4,2],[2,3,3],[2,2,4],[2,1,5],[1,6,1],[1,5,2],[1,4,3],[1,3,4],[1,2,5],[1,1,6],[6,2],[5,3],[4,4],[3,5],[2,6]]"
                , result);
    }

    @Test
    void solataireNumbers0() {
        Assertions.assertEquals(8, SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 9, -1, -2}));
    }

    @Test
    void solataireNumbers2() {
        Assertions.assertEquals(9, SolitaireNumbers.solitaireNumbers(new int[]{1, -1, 1, -2, 0, 9, -1, -2}));
    }

    @Test
    void solataireNumbers3() {
        Assertions.assertEquals(15, SolitaireNumbers.solitaireNumbers(new int[]{1, -1, 1, -2, 0, 9, -1, 4}));
    }

    @Test
    void solataireNumbers4() {
        Assertions.assertEquals(10, SolitaireNumbers.solitaireNumbers(new int[]{-5, 1, -1, 1, -2, 0, 9, -1, 4}));
    }

    @Test
    void solataireNumbers5() {
        Assertions.assertEquals(10, SolitaireNumbers.solitaireNumbers(new int[]{-5, -1, -1, 1, -2, 0, -9, -1, -4}));
    }

    @Test
    void solataireNumbersHuge() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(27);
        for (int i = 0; i < 500; i++) {
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