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
    @Test
    void detectNoCycle2() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c2 = new Node(null);
        Node c1 = new Node(null);
        Node b2 = new Node(null);
        Node b1 = new Node(null);
        Node b = new Node(List.of(b1, b2));
        Node c = new Node(List.of(c1, c2));
        Node a = new Node(List.of(b, c));

        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a, b, c, c1, c2, b1, b2)).getSize(), 0);
    }
    @Test
    void detectCycle2() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c2 = new Node(null);
        Node c1 = new Node(null);
        Node b2 = new Node(null);
        Node b1 = new Node(List.of(c1));
        Node b = new Node(List.of(b1, b2));
        Node c = new Node(List.of(c1, c2));
        Node a = new Node(List.of(b, c));

        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a, b, c, c1, c2, b1, b2)).getSize(), 1);
    }
}