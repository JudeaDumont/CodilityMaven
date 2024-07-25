package directedGraphs.DetectingCycles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleDetecter {
    private final Set<Node> visitedNodes = new HashSet<>();
    private final Set<Edge<Node, Node>> visitedEdges = new HashSet<>();
    private final NodeEdgeMap cyclicNodes = new NodeEdgeMap();

    public NodeEdgeMap determineCycles(List<Node> nodes) {
        for (Node node : nodes) {
            traverse(node);
        }
        return cyclicNodes;
    }

    private void traverse(Node node) {
        if (node.getLinks()!=null) {
            for (Node link : node.getLinks()) {
                Edge<Node, Node> edge = new Edge<>(node, link);
                if (visitedNodes.contains(link) && !visitedEdges.contains(edge)) {
                    //cycle
                    cyclicNodes.put(link, edge);
                } else {
                    visitedNodes.add(node);
                    visitedEdges.add(edge);
                    traverse(link);
                }
            }
        }
        else {
            visitedNodes.add(node);
            visitedEdges.add(new Edge<>(node, null));
        }
    }


    private boolean allVisited(List<Node> links) {
        return links == null || visitedNodes.containsAll(links);
    }
}
