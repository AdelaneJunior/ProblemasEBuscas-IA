package GraphStructure;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Vertex {

    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String data) {
        this.data = data;
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Vertex endVertex, Integer weight) {
        edges.add(new Edge(this, endVertex, weight));
    }

    public void removeEdge(Vertex endVertex) {
        this.edges.removeIf(edge -> edge.getEndVertex().equals(endVertex));
    }

    public boolean updateEdge(Vertex endVertex, Integer weight){

        if (this.edges.size() == 0){
            System.out.println("Verticie não possui conexões");
            return false;
        }

        for (int i = 0; i < this.edges.size() ; i++){

            if (this.edges.get(i).getEndVertex().equals(endVertex)){

                this.edges.get(i).setWeight(weight);
                return true;
            }
        }

        System.out.println("Conexão inexistente para ser atualizada");
        return false;

    }
    public void printAllEdges(boolean showWeight) {

        StringBuilder stringBuilder = new StringBuilder();

        if (this.edges.size() == 0) {
            System.out.println(this.data + " --> ");
            return;
        }

        for (int i = 0; i < this.edges.size(); i++) {

            if (i == 0) {
                stringBuilder.append(this.edges.get(i).getStartVertex().data).append(" --> ");
            }

            stringBuilder.append(this.edges.get(i).getEndVertex().data);

            if (showWeight) {
                stringBuilder.append("(").append(this.edges.get(i).getWeight()).append(")");
            }

            if (i != this.edges.size() - 1) {
                stringBuilder.append(",");
            }

        }

        System.out.println(stringBuilder.toString());
    }
}
