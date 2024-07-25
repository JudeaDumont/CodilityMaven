package directedGraphs.DetectingCycles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CycleDetecterTest {
    @Test
    void detectNoCycle() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node b = new Node(null);
        Node c = new Node(null);
        Node a = new Node(List.of(b, c));

        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a, b, c)).getSize(), 0);
    }

    @Test
    void detectCycle() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c = new Node(null);
        Node b = new Node(List.of(c));
        Node a = new Node(List.of(b, c));

        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a, b, c)).getSize(), 1);
    }
}