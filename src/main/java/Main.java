import GraphStructure.GraphShearch;
import GraphStructure.Vertex;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static ArrayList<Vertex> visited;
    private static String name;
    private static Vertex startVertex;
    private static Vertex endVertex;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        FillGraph graph = new FillGraph();
        ManualShearch manualShearch = new ManualShearch(graph.getGraph());
        int shearchType = 0;

        while (shearchType != 9) {

            System.out.println("Selecione o tipo de busca que gostaria de realizar: ");
            System.out.println("1 - Busca por profundidade");
            System.out.println("2 - Busca por largura");
            System.out.println("3 - Busca por heuristica");
            System.out.println("4 - Busca por algoritimo convencional Pedro até Samara");
            System.out.println("5 - Busca por algoritimo convencional Felipe até Pedro");
            System.out.println("6 - Busca por algoritimo convencional Amanda até Rafael");
            System.out.println("9 - Sair");

            shearchType = scanner.nextInt();
            posShearch();
            switch (shearchType) {
                case 1 -> {
                    System.out.println("=BUSCA POR PROFUNDIDADE=");
                    startVertex = getStartVertex(name, scanner, startVertex, graph);
                    endVertex = getTargetVertex(scanner, graph);
                    visited = new ArrayList<Vertex>();
                    visited.add(startVertex);
                    System.out.println("\n");
                    GraphShearch.depthShearch(startVertex, endVertex, visited, false);
                    posShearch();

                }
                case 2 -> {
                    System.out.println("=BUSCA POR LARGURA=");
                    startVertex = getStartVertex(name, scanner, startVertex, graph);
                    endVertex = getTargetVertex(scanner, graph);
                    visited = new ArrayList<Vertex>();
                    visited.add(startVertex);
                    System.out.println("\n");
                    GraphShearch.breadthSearch(startVertex, endVertex, visited);
                    posShearch();

                }
                case 3 -> {
                    System.out.println("=BUSCA POR HEURISTICA=");
                    startVertex = getStartVertex(name, scanner, startVertex, graph);
                    endVertex = getTargetVertex(scanner, graph);
                    visited = new ArrayList<Vertex>();
                    visited.add(startVertex);
                    System.out.println("\n");
                    GraphShearch.shortestPathBetween(graph.getGraph(), startVertex, endVertex);
                    posShearch();


                }
                case 4 ->{
                    System.out.println("=BUSCA PEDRO ATE SAMARA CONVENCIONAL=");
                    manualShearch.pedroToSamaraShearch();
                    posShearch();
                }
                case 5 ->{
                    System.out.println("=BUSCA FELIPE ATE PEDRO CONVENCIONAL=");
                    manualShearch.felipeToPedroShearch();
                    posShearch();
                }
                case 6 ->{
                    System.out.println("=BUSCA AMANDA ATE RAFAEL CONVENCIONAL=");
                    manualShearch.amandaToRafaelShearch();
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
            name = fixName(name);
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
            name = fixName(name);
            startVertex = graph.getGraph().getVertexByValue(name);

            if (Objects.isNull(startVertex)) {
                System.out.println("Pessoa não encontrada");
            }
        }
        return startVertex;
    }


    private static String fixName(String name){

        String ucFistChar = name.substring(0, 1).toUpperCase();
        String lcOthersChar = name.substring(1).toLowerCase();

        String fixedName = ucFistChar+lcOthersChar;
        System.out.println(fixedName);
        return fixedName;

    }
    private static void posShearch() {
        name = "";
        startVertex = new Vertex("");
        endVertex = new Vertex("");
        System.out.println("\n=========================\n");
    }

}
