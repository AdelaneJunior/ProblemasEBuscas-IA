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

    public static void main(String[] args) {

        Graph graph = new Graph(true, false);

        Vertex pessoa1 = graph.addVertex("Sara");
        Vertex pessoa2 = graph.addVertex("Adelane");
        Vertex pessoa3 = graph.addVertex("Rafa");
        Vertex pessoa4 = graph.addVertex("Silas");
        Vertex pessoa5 = graph.addVertex("Felipe");


        graph.addEdge(pessoa1, pessoa2, 100);
        graph.addEdge(pessoa2, pessoa3, 20);
        graph.addEdge(pessoa3, pessoa4, 20);
        graph.addEdge(pessoa1, pessoa5, 21);

  //      graph.print();
//
//        System.out.println("0 : "+graph.getVertices().get(0).getData() );
//        System.out.println("1 : "+graph.getVertices().get(1).getData() );
//        System.out.println("2 : "+graph.getVertices().get(2).getData() );
//        System.out.println("3 : "+graph.getVertices().get(3).getData() );
//        System.out.println("4 : "+graph.getVertices().get(4).getData() );

        ArrayList<Vertex> visted = new ArrayList<Vertex>();
        visted.add(graph.getVertices().get(1));

//        GraphShearch.depthShearch(graph.getVertices().get(1),graph.getVertices().get(3), visted, graph.getVertices().get(1).getData());
        GraphShearch.heuristicResultPrinter(GraphShearch.heuristicDictionary(graph, pessoa1));
        GraphShearch.shortestPathBetween(graph, pessoa1, pessoa5);
    }
}
