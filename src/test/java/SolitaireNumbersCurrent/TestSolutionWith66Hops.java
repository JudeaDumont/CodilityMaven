package SolitaireNumbersCurrent;

import org.example.SolitaireNumbersCurrent.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.example.old.OldSolitaireNumbers2.getPositiveBitMap;

public class TestSolutionWith66Hops {

    @Test
    void TestSolutionWith66Hops() {
        Solution s = new Solution();
        int[] a = new int[66];
        Arrays.fill(a, -2);
        s.solution(a);
    }
}
