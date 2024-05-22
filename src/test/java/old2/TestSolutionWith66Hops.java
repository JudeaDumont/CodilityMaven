package old2;

import org.example.old2.Old2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestSolutionWith66Hops {

    @Test
    void TestSolutionWith66Hops() {
        Old2 s = new Old2();
        int[] a = new int[66];
        Arrays.fill(a, -2);
        s.solution(a);
    }
}
