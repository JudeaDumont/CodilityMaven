package directedGraphs.DetectingCycles;

import directedGraphs.DetectingCycles.RandomAccessSet.RandomAccessMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class CycleDetecterTest {
    @Test
    void detectNoCycle() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node b = new Node(null);
        Node c = new Node(null);
        Node a = new Node(List.of(b, c));

        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a, b, c)).size(), 0);
    }

    @Test
    void detectNoCycle2() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c = new Node(null);
        Node b = new Node(List.of(c));
        Node a = new Node(List.of(b, c));

        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a, b, c)).size(), 0);
    }
    @Test
    void detectNoCycle3() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c2 = new Node(null);
        Node c1 = new Node(null);
        Node b2 = new Node(null);
        Node b1 = new Node(null);
        Node b = new Node(List.of(b1, b2));
        Node c = new Node(List.of(c1, c2));
        Node a = new Node(List.of(b, c));

        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a, b, c, c1, c2, b1, b2)).size(), 0);
    }
    @Test
    void detectNoCycle4() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c2 = new Node(null);
        Node c1 = new Node(null);
        Node b2 = new Node(null);
        Node b1 = new Node(List.of(c1));
        Node b = new Node(List.of(b1, b2));
        Node c = new Node(List.of(c1, c2));
        Node a = new Node(List.of(b, c));

        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a, b, c, c1, c2, b1, b2)).size(), 0);
    }
    @Test
    void detectNoCycle5() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c2 = new Node(null);
        Node c1 = new Node(null);
        Node b2 = new Node(List.of(c1));
        Node b1 = new Node(List.of(c1));
        Node b = new Node(List.of(b1, b2));
        Node c = new Node(List.of(c1, c2));
        Node a = new Node(List.of(b, c));

        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a, b, c, c1, c2, b1, b2)).size(), 0);
    }
    @Test
    void detectNoCycle6() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c2 = new Node(null);
        Node c1 = new Node(null);
        Node b2 = new Node(null);
        Node b1 = new Node(null);
        Node b = new Node(List.of(b1, b2, c1));
        Node c = new Node(List.of(c1, c2));
        Node a = new Node(List.of(b, c));

        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a, b, c, c1, c2, b1, b2)).size(), 0);
    }
    @Test void detectCycle() {
        CycleDetecter cycleDetecter = new CycleDetecter();
        Node a = new Node(null, "a");
        Node b = new Node(List.of(a), "b");
        a.setLinks(new LinkedList<>(List.of(b)));
        RandomAccessMap<Integer, HashSet<Node>> accessMap = cycleDetecter.determineCycles(List.of(a, b));
        Assertions.assertEquals(accessMap.size(), 1);
        Assertions.assertEquals(accessMap.at(0).size(), 2);
    }
    @Test void detectCycle2() {
        CycleDetecter cycleDetecter = new CycleDetecter();
        Node a = new Node(null, "a");
        Node b = new Node(List.of(a), "b");
        a.setLinks(new LinkedList<>(List.of(b)));
        Assertions.assertEquals(cycleDetecter.determineCycles(List.of(a)).size(), 1);
    }
    @Test
    void detectCycle3Edge() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c2 = new Node(null, "c2");
        Node c1 = new Node(null, "c1");
        Node b2 = new Node(null, "b2");
        Node b1 = new Node(null, "b1");
        Node b = new Node(List.of(b1, b2), "b");
        Node c = new Node(List.of(c1, c2), "c");
        Node a = new Node(List.of(b, c), "a");
        b1.setLinks(new LinkedList<>(List.of(a)));

        RandomAccessMap<Integer, HashSet<Node>> accessMap = cycleDetecter.determineCycles(List.of(a, b, c, c1, c2, b1, b2));
        Assertions.assertEquals(accessMap.size(), 1);
        Assertions.assertEquals(accessMap.at(0).size(), 3);
    }
    @Test
    void detectCycle6() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c2 = new Node(null, "c2");
        Node c1 = new Node(null, "c1");
        Node b2 = new Node(null, "b2");
        Node b1 = new Node(null, "b1");
        Node b = new Node(List.of(b1, b2), "b");
        Node c = new Node(List.of(c1, c2), "c");
        Node a = new Node(List.of(b, c), "a");
        b1.setLinks(new LinkedList<>(List.of(a)));
        b2.setLinks(new LinkedList<>(List.of(c2)));


        RandomAccessMap<Integer, HashSet<Node>> accessMap = cycleDetecter.determineCycles(List.of(a, b, c, c1, c2, b1, b2));
        Assertions.assertEquals(accessMap.size(), 1);
        Assertions.assertEquals(accessMap.at(0).size(), 3);
    }
    @Test
    void externalNodePointsToINternalNode() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c2 = new Node(null, "c2");
        Node c1 = new Node(null, "c1");
        Node b2 = new Node(null, "b2");
        Node b1 = new Node(null, "b1");
        Node b = new Node(List.of(b1, b2), "b");
        Node c = new Node(List.of(c1, c2), "c");
        Node a = new Node(List.of(b, c), "a");
        Node d = new Node(List.of(a), "d");

        RandomAccessMap<Integer, HashSet<Node>> accessMap = cycleDetecter.determineCycles(List.of(a, b, c, c1, c2, b1, b2, d));
        Assertions.assertEquals(accessMap.size(), 0);
    }
    @Test
    void joinGraphs() {
        CycleDetecter cycleDetecter = new CycleDetecter();

        Node c2 = new Node(null, "c2");
        Node c1 = new Node(null, "c1");
        Node b2 = new Node(null, "b2");
        Node b1 = new Node(null, "b1");
        Node b = new Node(List.of(b1, b2), "b");
        Node c = new Node(List.of(c1, c2), "c");
        Node a = new Node(List.of(b, c), "a");
        Node d = new Node(List.of(a), "d");
        Node e = new Node(List.of(d), "e");

        RandomAccessMap<Integer, HashSet<Node>> accessMap = cycleDetecter.determineCycles(List.of(a, b, c, c1, c2, b1, b2, e, d));
        Assertions.assertEquals(accessMap.size(), 0);
    }
}