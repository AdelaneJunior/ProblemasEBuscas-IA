import GraphStructure.Graph;
import GraphStructure.Vertex;

public class ManualShearch {

    private  Graph graph;
    public ManualShearch( Graph graph) {
        this.graph = graph;
    }

    public void pedroToSamaraShearch() {

        Vertex pedro = graph.getVertexByValue("Pedro");
        Vertex rafaela = new Vertex("");
        int i = 0;

        for(i = 0; i < pedro.getEdges().size(); i++){
            if (rafaela.getData().equals("Rafaela")) break;

            rafaela = pedro.getEdges().get(i).getEndVertex();

            System.out.println(pedro.getData() + " --> " + rafaela.getData());
        }

        Vertex livia = new Vertex("");

        for (i = 0; i < rafaela.getEdges().size(); i++){

            if (livia.getData().equals("Livia")) break;

            livia = rafaela.getEdges().get(i).getEndVertex();

            System.out.println(rafaela.getData() + " --> " + livia.getData());

        }

        Vertex felipe = new Vertex("");

        for (i = 0; i < livia.getEdges().size(); i++){

            if (felipe.getData().equals("Felipe")) break;

            felipe = livia.getEdges().get(i).getEndVertex();

            System.out.println(livia.getData() + " --> " + felipe.getData());

        }

        Vertex joao = new Vertex("");

        for (i = 0; i < felipe.getEdges().size(); i++){

            if (joao.getData().equals("João")) break;

            joao = felipe.getEdges().get(i).getEndVertex();
            System.out.println(felipe.getData() + " --> " + joao.getData());

        }

        Vertex samara = new Vertex("");

        for (i = 0; i < joao.getEdges().size(); i++){

            if (samara.getData().equals("Samara")) break;

            samara = joao.getEdges().get(i).getEndVertex();
            System.out.println(joao.getData() + " --> " + samara.getData());
        }

        System.out.println(samara.getData() + " encontrada");
    }

    public void felipeToPedroShearch() {

        Vertex felipe = graph.getVertexByValue("Felipe");

        Vertex livia = new Vertex("");
        int i = 0;

        for (i = 0; i < felipe.getEdges().size(); i++){

            if (livia.getData().equals("Livia")) break;

            livia = felipe.getEdges().get(i).getEndVertex();
            System.out.println(felipe.getData() + " --> " + livia.getData());

        }

        Vertex rafaela = new Vertex("");

        for (i = 0; i < livia.getEdges().size(); i++){

            if (rafaela.getData().equals("Rafaela")) break;

            rafaela = livia.getEdges().get(i).getEndVertex();

            System.out.println(livia.getData() + " --> " + rafaela.getData());

        }

        Vertex pedro = new Vertex("");

        for (i = 0; i < rafaela.getEdges().size(); i++){

            if (pedro.getData().equals("Pedro")) break;

            pedro = rafaela.getEdges().get(i).getEndVertex();

            System.out.println(rafaela.getData() + " --> " + pedro.getData());

        }

        System.out.println(pedro.getData() + " encontrado");
    }

    public void amandaToRafaelShearch(){

        Vertex amanda = graph.getVertexByValue("Amanda");

        Vertex joao = new Vertex("");
        int i = 0;

        for (i = 0; i < amanda.getEdges().size(); i++){

            if (joao.getData().equals("João")) break;

            joao = amanda.getEdges().get(i).getEndVertex();
            System.out.println(amanda.getData() + " --> " + joao.getData());

        }

        Vertex felipe = new Vertex("");

        for (i = 0; i < joao.getEdges().size(); i++){

            if (felipe.getData().equals("Felipe")) break;

            felipe = joao.getEdges().get(i).getEndVertex();
            System.out.println(joao.getData() + " --> " + felipe.getData());
        }

        Vertex rafaela = new Vertex("");

        for (i = 0; i < felipe.getEdges().size(); i++){

            if (rafaela.getData().equals("Rafaela")) break;

            rafaela = felipe.getEdges().get(i).getEndVertex();
            System.out.println(felipe.getData() + " --> " + rafaela.getData());
        }

        Vertex pedro = new Vertex("");

        for (i = 0; i < rafaela.getEdges().size(); i++){

            if (pedro.getData().equals("Pedro")) break;

            pedro = rafaela.getEdges().get(i).getEndVertex();
            System.out.println(rafaela.getData() + " --> " + pedro.getData());
        }

        Vertex rafael = new Vertex("");

        for (i = 0; i < pedro.getEdges().size(); i++){

            if (rafael.getData().equals("Rafael")) break;

            rafael = pedro.getEdges().get(i).getEndVertex();

            System.out.println(pedro.getData() + " --> " + rafael.getData());

        }

        System.out.println(rafael.getData() + " encontrado");
    }
}
