package directedGraphs.DetectingCycles;

import lombok.Getter;

import java.util.*;

public class CycleDetecter {
    private final Map<Node, Node> visitedNodes = new HashMap<>();
    private final Set<Integer> visitedEdges = new HashSet<>();
    private final NodeEdgeMap cyclicNodes = new NodeEdgeMap();
    @Getter
    private final Set<Node> leaves = new HashSet<>();

    public NodeEdgeMap determineCycles(List<Node> nodes) {
        for (Node node : nodes) {
            traverse(node);
        }
        return cyclicNodes;
    }

    private void traverse(Node node) {
        if (node.getLinks() != null) {
            for (Node link : node.getLinks()) {
                Edge<Node, Node> edge = new Edge<>(node, link);
                int edgeHashCode = edge.hashCode();
                if (visitedNodes.containsKey(link) && !visitedEdges.contains(edgeHashCode)) {
                    //cycle
                    if (!cyclicNodes.containsKey(link)) {
                        cyclicNodes.put(link, new Edge<>(visitedNodes.get(link), link));
                    }
                    cyclicNodes.put(link, edge);
                    visitedEdges.add(edgeHashCode);
                }
                else if(visitedNodes.containsKey(link) && visitedEdges.contains(edgeHashCode)){
                    //skip, this path has already been visited by a previous traversal
                    return;
                }
                else {
                    visitedNodes.put(link, node);
                    if (!visitedNodes.containsKey(node)) {
                        visitedNodes.put(node, null);
                        visitedEdges.add(new Edge<>(null, node).hashCode());
                    }
                    visitedEdges.add(edgeHashCode);
                    traverse(link);
                }
            }
        } else {
            leaves.add(node);
            visitedEdges.add(new Edge<>(node, null).hashCode());
        }
    }


    private boolean allVisited(List<Node> links) {
        return links == null || visitedNodes.keySet().containsAll(links);
    }
}
