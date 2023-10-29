package GraphStructure;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class GraphShearch {


    public static void breadthSearch(Vertex startVertex, Vertex endVertex, ArrayList<Vertex> visited) {

        Queue visitQueue = new Queue();
        boolean init = true;
        visitQueue.enqueue(startVertex);

        while (!visitQueue.isEmpty()) {
            if (init) {
                System.out.print("Inicia em: ");
            }
            if (!init) {
                System.out.print("verifica --> ");
            }

            Vertex current = visitQueue.dequeue();

            System.out.println(current.getData());

            for (Edge e : current.getEdges()) {

                Vertex neighbor = e.getEndVertex();

                if (neighbor == endVertex) {
                    System.out.print("Em "+current.getData() +" encontra o destino de busca --> ");
                    System.out.print(neighbor.getData());
                    return;
                }

                if (!visited.contains(neighbor)) {

                    System.out.println("encontra " + neighbor.getData() + " e guarda  na fila  ");
                    visited.add(neighbor);
                    visitQueue.enqueue(neighbor);

                }
                init = false;
            }
        }

    }

    public static Dictionary[] heuristicDictionary(Graph graph, Vertex starVertex) {

        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<QueueObject>();

        queue.add(new QueueObject(starVertex, 0));

        for (Vertex vertex : graph.getVertices()) {

            if (vertex != starVertex) {
                distances.put(vertex.getData(), Integer.MAX_VALUE);
            }
            previous.put(vertex.getData(), new Vertex("NULL"));
        }

        distances.put(starVertex.getData(), 0);

        while (queue.size() != 0) {

            Vertex current = queue.poll().vertex;

            for (Edge e : current.getEdges()) {
                Integer alternative = distances.get(current.getData()) + e.getWeight();
                String neighbotValue = e.getEndVertex().getData();

                if (alternative < distances.get(neighbotValue)) {
                    distances.put(neighbotValue, alternative);
                    previous.put(neighbotValue, current);
                    queue.add(new QueueObject(e.getEndVertex(), distances.get(neighbotValue)));
                }
            }
        }
        return new Dictionary[]{distances, previous};
    }

    private static void heuristicResultPrinter(Dictionary[] dictionaries) {

        System.out.println("Distances:\n");

        for (Enumeration keys = dictionaries[0].keys(); keys.hasMoreElements(); ) {
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ":" + dictionaries[0].get(nextKey));
        }

        System.out.println("\nPrevious\n");

        for (Enumeration keys = dictionaries[1].keys(); keys.hasMoreElements(); ) {

            String nextKey = keys.nextElement().toString();

            Vertex nextVertex = (Vertex) dictionaries[1].get(nextKey);

            System.out.println(nextKey + ": " + nextVertex.getData());
        }

    }

    public static void shortestPathBetween(Graph graph, Vertex startVertex, Vertex targetVertex) {

        Dictionary[] dictionaries = heuristicDictionary(graph, startVertex);

        Dictionary distances = dictionaries[0];
        Dictionary previous = dictionaries[1];

        Integer distance = (Integer) distances.get(targetVertex.getData());

        System.out.println("O caminho mais curto entre " + startVertex.getData() + " e " + targetVertex.getData() + " tem distancia de: " + distance);

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex vertex = targetVertex;

        while (vertex.getData() != "NULL") {
            path.add(0, vertex);
            vertex = (Vertex) previous.get(vertex.getData());
        }

        System.out.println("Menor caminho: ");

        int i = 0;
        for (Vertex pathVertex : path) {

            if (i == path.size() - 1) {
                System.out.print(pathVertex.getData());
            } else {

                System.out.print(pathVertex.getData() + " --> ");
                i++;
            }
        }
    }

    public static boolean depthShearch(Vertex startVertex, Vertex targetVertex, ArrayList<Vertex> visited, boolean finded) {

        for (Edge e : startVertex.getEdges()) {

            Vertex neighbor = e.getEndVertex();

            if (neighbor == targetVertex && !finded) {
                System.out.print("\n"+startVertex.getData() + " encontra --> " + neighbor.getData());
                return true;
            }

            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                System.out.print(startVertex.getData() + " --> " + neighbor.getData() +"\n");
                finded = GraphShearch.depthShearch(neighbor, targetVertex, visited, finded);
            }

            if (finded){
                break;
            }
        }
        return finded;
    }
}
