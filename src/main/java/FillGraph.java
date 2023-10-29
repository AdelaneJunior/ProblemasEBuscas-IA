import GraphStructure.Graph;
import GraphStructure.Vertex;
import lombok.Getter;

@Getter
public class FillGraph {

    private Graph graph;
    public FillGraph() {

        graph = new Graph(true, false);

        Vertex joao = graph.addVertex("João");
        Vertex pedro = graph.addVertex("Pedro");
        Vertex rafael = graph.addVertex("Rafael");
        Vertex samara = graph.addVertex("Samara");
        Vertex felipe = graph.addVertex("Felipe");
        Vertex maria = graph.addVertex("Maria");
        Vertex livia = graph.addVertex("Livia");
        Vertex patricia = graph.addVertex("Patricia");
        Vertex amanda = graph.addVertex("Amanda");
        Vertex rafaela = graph.addVertex("Rafaela");


        graph.addEdge(joao, samara, 1);
        graph.addEdge(joao, felipe, 10);
        graph.addEdge(felipe, livia, 8);
        graph.addEdge(livia, rafaela, 20);
        graph.addEdge(rafaela, patricia, 9);
        graph.addEdge(amanda, maria, 15);
        graph.addEdge(amanda, joao, 15);
        graph.addEdge(pedro, rafael, 5);
        graph.addEdge(felipe, rafaela, 20);
        graph.addEdge(rafaela, pedro, 18);

        graph.print();

    }
}
