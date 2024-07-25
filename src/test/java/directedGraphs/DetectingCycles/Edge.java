package directedGraphs.DetectingCycles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge<T1, T2> {
    private T1 first;
    private T2 second;
    public Edge(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
}
