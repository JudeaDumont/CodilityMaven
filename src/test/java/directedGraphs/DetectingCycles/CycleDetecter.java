package directedGraphs.DetectingCycles;

import directedGraphs.DetectingCycles.RandomAccessSet.RandomAccessMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CycleDetecter {

    private final RandomAccessMap<Integer, HashSet<Node>> cyclicPaths = new RandomAccessMap<>();

    public RandomAccessMap<Integer, HashSet<Node>> determineCycles(List<Node> nodes) {
        for (Node node : nodes) {
            traverse(node);
        }
        return cyclicPaths;
    }

    private void traverse(Node node) {
        traverse(null, node, new HashSet<>());
    }

    private void traverse(Node from,
                          Node node,
                          HashSet<Node> path) {
        //Node is not in the graph, add it
        if (!path.contains(node)) {
            path.add(node);
            if (node.getLinks() != null) {
                //Node has links, traverse
                for (Node link : node.getLinks()) {
                    traverse(node, link, new HashSet<>(path));
                }
            }
        } else {
            //Node is in the path already
            if (!path.contains(from)) {
                //If the node from is not in the graph we connect from to the node
                path.add(from);
            } else {
                //Else we cycle
                cyclicPaths.put(path.hashCode(), path);
            }
        }
    }
}
