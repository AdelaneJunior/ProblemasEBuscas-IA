import GraphStructure.GraphShearch;
import GraphStructure.Vertex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static ArrayList<Vertex> visited;
    private static String name;
    private static Vertex startVertex;
    private static Vertex endVertex;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        FillGraph graph = new FillGraph();
        int shearchType = 0;

        while (shearchType != 9) {

            System.out.println("Selecione o tipo de busca que gostaria de realizar: ");
            System.out.println("1 - Busca por profundidade");
            System.out.println("2 - Busca por largura");
            System.out.println("3 - Busca por profundidade");
            System.out.println("9 - Sair");

            shearchType = scanner.nextInt();
            posShearch();
            switch (shearchType) {
                case 1 -> {
                    startVertex = getStartVertex(name, scanner, startVertex, graph);
                    endVertex = getTargetVertex(scanner, graph);
                    visited = new ArrayList<Vertex>();
                    visited.add(startVertex);
                    System.out.println("\n");
                    GraphShearch.depthShearch(startVertex, endVertex, visited, false);
                    posShearch();

                }
                case 2 -> {

                    startVertex = getStartVertex(name, scanner, startVertex, graph);
                    endVertex = getTargetVertex(scanner, graph);
                    visited = new ArrayList<Vertex>();
                    visited.add(startVertex);
                    System.out.println("\n");
                    GraphShearch.breadthSearch(startVertex, endVertex, visited);
                    posShearch();

                }
                case 3 -> {

                    startVertex = getStartVertex(name, scanner, startVertex, graph);
                    endVertex = getTargetVertex(scanner, graph);
                    visited = new ArrayList<Vertex>();
                    visited.add(startVertex);
                    System.out.println("\n");
                    GraphShearch.shortestPathBetween(graph.getGraph(), startVertex, endVertex);
                    posShearch();


                }
                case 9 -> {
                    System.out.println("Fim de execução");
                }
                default -> System.out.println("Opçao invalida");

            }
        }
    }

    private static Vertex getTargetVertex(Scanner scanner, FillGraph graph) {
        while (Objects.isNull(endVertex) || endVertex.getData().equals("")) {
            endVertex = new Vertex("");
            System.out.print("Digite o nome da pessoa final: ");
            System.out.flush();
            name = scanner.next();
            endVertex = graph.getGraph().getVertexByValue(name);

            if (Objects.isNull(endVertex)) {
                System.out.println("Pessoa não encontrada");
            }
        }
        return endVertex;
    }

    private static Vertex getStartVertex(String name, Scanner scanner, Vertex startVertex, FillGraph graph) {

        while (Objects.isNull(startVertex) || startVertex.getData().equals("")) {
            startVertex = new Vertex("");
            System.out.print("Digite o nome da pessoa de inicio: ");
            System.out.flush();
            name = scanner.next();
            System.out.flush();
            startVertex = graph.getGraph().getVertexByValue(name);

            if (Objects.isNull(startVertex)) {
                System.out.println("Pessoa não encontrada");
            }
        }
        return startVertex;
    }

    private static void posShearch() {
        System.out.println("\n=========================\n");
    }

}
