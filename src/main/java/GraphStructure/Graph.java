package GraphStructure;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public Vertex addVertex(String data){
        if (this.getVertexByValue(data) == null){
            Vertex newVertex = new Vertex(data);
            this.vertices.add(newVertex);
            return newVertex;
        }

        System.out.println("Pessoa ja cadastrada");
        return null;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight){

        if(!this.isWeighted) {
            weight = null;
        }

       for (int i = 0; i < vertex1.getEdges().size() ; i++){

           if (vertex1.getEdges().get(i).getEndVertex().equals(vertex2)){
               System.out.println("Conexão ja existente");
               return;
           }

       }

        vertex1.addEdge(vertex2, weight);

        if (!this.isDirected){
            vertex2.addEdge(vertex1, weight);
        }

    }

    public void removeEdge(Vertex vertex1, Vertex vertex2){

        vertex1.removeEdge(vertex2);

        if (!this.isDirected){
            vertex2.removeEdge(vertex1);
        }

    }

    public void updateEdge(Vertex vertex1, Vertex vertex2, Integer weight){

        if (!this.isWeighted){
            weight = null;
        }

        boolean upated = vertex1.updateEdge(vertex2, weight);

        if(!this.isDirected && upated ){
            vertex2.updateEdge(vertex1, weight);
        }

    }
    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public boolean isWeighted() {
        return this.isWeighted;
    }


    public void print(){
        for (Vertex v : this.vertices){
            v.printAllEdges(isWeighted);
        }
    }

    public Vertex getVertexByValue(String value){

        for (Vertex v : this.vertices){
            if(v.getData().equals(value)){
                return v;
            }
        }
        return null;
    }
}
