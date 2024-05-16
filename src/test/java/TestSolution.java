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
}