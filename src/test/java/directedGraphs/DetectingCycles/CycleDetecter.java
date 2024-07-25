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
        if (Objects.equals(node.getId(), "e")) {
            int stop = 0;
        }
        if (!visitedNodes.containsKey(node)) {
            visitedNodes.put(node, null);
            visitedEdges.add(new Edge<>(null, node).hashCode());
            if (node.getLinks() != null) {
                for (Node link : node.getLinks()) {
                    if (visitedNodes.containsKey(link)) {
                        // node outside the graph is now pointing to something in the graph
                        visitedEdges.add(new Edge<>(node, link).hashCode());
                        visitedEdges.remove(new Edge<>(null, link).hashCode());
                    }
                }
            }
        }
        if (node.getLinks() != null) {
            for (Node link : node.getLinks()) {
                Edge<Node, Node> edge = new Edge<>(node, link);
                int edgeHashCode = edge.hashCode();

                if (!visitedNodes.containsKey(link)
                        //|| visitedNodes.get(link) == null
                ) {
                    //new link // or node was visited but now has a node linking to it
                    visitedNodes.put(link, node);
                    visitedEdges.add(edgeHashCode);
                    traverse(link);
                } else if (!visitedEdges.contains(edgeHashCode)) {
                    // same linked node but different edge == cycle
                    if (!cyclicNodes.containsKey(link)) {
                        cyclicNodes.put(link, new Edge<>(visitedNodes.get(link), link));
                    }
                    cyclicNodes.put(link, edge);
                    visitedEdges.add(edgeHashCode);
                } else {
                    // skip, this path has already been visited by a previous traversal
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
