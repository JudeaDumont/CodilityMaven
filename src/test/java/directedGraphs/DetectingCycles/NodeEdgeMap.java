package directedGraphs.DetectingCycles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NodeEdgeMap {

    private Map<Node, LinkedList<Edge<Node, Node>>> map;

    public NodeEdgeMap() {
        map = new HashMap<>();
    }

    public void put(Node node, Edge<Node, Node> edge) {
        map.computeIfAbsent(node, k -> new LinkedList<>()).add(edge);
    }

    public LinkedList<Edge<Node, Node>> get(Node node) {
        return map.get(node);
    }

    public int getSize(){
        return map.size();
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