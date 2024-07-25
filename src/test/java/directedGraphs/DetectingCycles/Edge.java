package directedGraphs.DetectingCycles;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Edge<T1, T2> {
    private T1 first;
    private T2 second;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?, ?> edge = (Edge<?, ?>) o;
        return Objects.equals(first, edge.first) && Objects.equals(second, edge.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public Edge(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
}
