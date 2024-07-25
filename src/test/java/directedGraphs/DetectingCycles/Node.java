package directedGraphs.DetectingCycles;

import lombok.Getter;

import java.util.List;

@Getter
public class Node {
    public Node(List<Node> links) {
        this.links = links;
    }

    private List<Node> links;
}
