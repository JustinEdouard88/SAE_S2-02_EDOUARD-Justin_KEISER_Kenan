import java.io.IOException;

public class MainDijkstra {
    public static void main(String[] args) throws IOException {
        GrapheListe gl = new GrapheListe("Graphe/g1.txt");
        gl.ajouterArc("a","b",12);
        gl.ajouterArc("a","d",87);
        gl.ajouterArc("b","e",11);
        gl.ajouterArc("c","a",19);
        gl.ajouterArc("d","b",23);
        gl.ajouterArc("d","c",10);
        gl.ajouterArc("e","d",43);

        Djikstra Dj = new Djikstra();
        System.out.println(Dj.resoudre(gl,"a"));
    }
}
