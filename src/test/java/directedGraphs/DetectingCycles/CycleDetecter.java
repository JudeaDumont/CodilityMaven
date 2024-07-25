package directedGraphs.DetectingCycles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleDetecter {
    private Map<Node, Node> visitedEdges = new HashMap<>();
    private NodeEdgeMap cyclicNodes = new NodeEdgeMap();

    public NodeEdgeMap determineCycles(List<Node> nodes) {
        for (Node node : nodes) {
            traverse(node);
        }
        return cyclicNodes;
    }

    private void traverse(Node node) {
        if (node.getLinks()!=null) {
            for (Node link : node.getLinks()) {
                if (visitedEdges.containsKey(link)) {
                    //cycle
                    cyclicNodes.put(link, new Edge<>(node, link));
                } else {
                    visitedEdges.put(node, link);
                    traverse(link);
                }
            }
        }
        else {
            visitedEdges.put(node, null);
        }
    }


    private boolean allVisited(List<Node> links) {
        return links == null || visitedEdges.keySet().containsAll(links);
    }
}
