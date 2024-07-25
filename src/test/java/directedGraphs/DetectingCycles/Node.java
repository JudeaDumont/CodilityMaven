package directedGraphs.DetectingCycles;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Node {
    public Node(List<Node> links) {
        this.links = links;
    }

    public Node(List<Node> links, String id) {
        this.links = links;
        this.id = id;
    }

    private List<Node> links;
    private String id;
}
