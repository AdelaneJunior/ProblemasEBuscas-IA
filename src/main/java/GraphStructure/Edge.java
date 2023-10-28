package GraphStructure;

import lombok.Getter;

@Getter
public class Edge {

    private Vertex startVertex;
    private Vertex endVertex;
    private Integer weight;

    public Edge(Vertex startVertex, Vertex endVertex, Integer weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
