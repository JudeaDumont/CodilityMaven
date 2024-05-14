import com.google.gson.Gson;
import org.example.SolitaireNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestJumpPatterns {

    @Test
    void solataireNumbers() {

        Gson gson = new Gson();
        String json = gson.toJson(SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0}));
        Assertions.assertEquals("[[1,1],[2]]", json);
        Assertions.assertEquals(1, SolitaireNumbers.max);
    }

    @Test
    void solataireNumbersX3() {
        Gson gson = new Gson();
        String json = gson.toJson(SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7, -14, -80, 1}));

        Assertions.assertEquals(
                "[[1,1,1,1,1,1],[2,1,1,1,1],[1,2,1,1,1],[1,1,2,1,1],[1,1,1,2,1],[1,1,1,1,2],[3,1,1,1],[2,2,1,1],[2,1,2,1],[2,1,1,2],[1,3,1,1],[1,2,2,1],[1,2,1,2],[1,1,3,1],[1,1,2,2],[1,1,1,3],[4,1,1],[3,2,1],[3,1,2],[2,3,1],[2,2,2],[2,1,3],[1,4,1],[1,3,2],[1,2,3],[1,1,4],[5,1],[4,2],[3,3],[2,4],[1,5],[6]]"
                , json);
        Assertions.assertEquals(9, SolitaireNumbers.max);
    }
    @Test
    void solataireNumbersX4() {
        Gson gson = new Gson();
        String result = gson.toJson(SolitaireNumbers.solitaireNumbers(new int[]{1, -2, 0, 7, -14, -80, 1, 12}));
        Assertions.assertEquals(
                "[[1,1,1,1,1,1,1],[2,1,1,1,1,1],[1,2,1,1,1,1],[1,1,2,1,1,1],[1,1,1,2,1,1],[1,1,1,1,2,1],[1,1,1,1,1,2],[3,1,1,1,1],[2,2,1,1,1],[2,1,2,1,1],[2,1,1,2,1],[2,1,1,1,2],[1,3,1,1,1],[1,2,2,1,1],[1,2,1,2,1],[1,2,1,1,2],[1,1,3,1,1],[1,1,2,2,1],[1,1,2,1,2],[1,1,1,3,1],[1,1,1,2,2],[1,1,1,1,3],[4,1,1,1],[3,2,1,1],[3,1,2,1],[3,1,1,2],[2,3,1,1],[2,2,2,1],[2,2,1,2],[2,1,3,1],[2,1,2,2],[2,1,1,3],[1,4,1,1],[1,3,2,1],[1,3,1,2],[1,2,3,1],[1,2,2,2],[1,2,1,3],[1,1,4,1],[1,1,3,2],[1,1,2,3],[1,1,1,4],[5,1,1],[4,2,1],[4,1,2],[3,3,1],[3,2,2],[3,1,3],[2,4,1],[2,3,2],[2,2,3],[2,1,4],[1,5,1],[1,4,2],[1,3,3],[1,2,4],[1,1,5],[6,1],[5,2],[4,3],[3,4],[2,5],[1,6]]"
                , result);
        Assertions.assertEquals(21, SolitaireNumbers.max);
    }
}
