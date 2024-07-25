package directedGraphs.DetectingCycles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NodeEdgeMap {

    private final Map<Node, LinkedList<Edge<Node, Node>>> map;
    private int edgeCount;

    public NodeEdgeMap() {
        map = new HashMap<>();
        edgeCount = 0;
    }

    public void put(Node node, Edge<Node, Node> edge) {
        map.computeIfAbsent(node, k -> new LinkedList<>()).add(edge);
        edgeCount++;
    }

    public boolean containsKey(Node node) {
        return map.containsKey(node);
    }

    public LinkedList<Edge<Node, Node>> get(Node node) {
        return map.get(node);
    }

    public int getSize(){
        return edgeCount;
    }

    public static void main(String[] args) {
        NodeEdgeMap nodeEdgeMap = new NodeEdgeMap();

        Node nodeA = new Node(null);
        Node nodeB = new Node(null);
        Node nodeC = new Node(null);

        Edge<Node, Node> edge1 = new Edge<>(nodeA, nodeB);
        Edge<Node, Node> edge2 = new Edge<>(nodeA, nodeC);
        Edge<Node, Node> edge3 = new Edge<>(nodeB, nodeC);

        nodeEdgeMap.put(nodeA, edge1);
        nodeEdgeMap.put(nodeA, edge2);
        nodeEdgeMap.put(nodeB, edge3);

        System.out.println("Edges from node A: " + nodeEdgeMap.get(nodeA));
        System.out.println("Edges from node B: " + nodeEdgeMap.get(nodeB));
        System.out.println("Edges from node C: " + nodeEdgeMap.get(nodeC)); // Should be null or empty
    }
}