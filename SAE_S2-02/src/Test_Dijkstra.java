import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Dijkstra {
    @Test
    public void test_Dijkstra() throws IOException {
        GrapheListe gl = new GrapheListe("Graphe/g1.txt");
        gl.ajouterArc("a","b",12.0, null);
        gl.ajouterArc("a","d",87.0, null);
        gl.ajouterArc("b","e",11.0, null);
        gl.ajouterArc("c","a",19.0, null);
        gl.ajouterArc("d","b",23.0, null);
        gl.ajouterArc("d","c",10.0, null);
        gl.ajouterArc("e","d",43.0, null);

        Djikstra Dj = new Djikstra();
        assertEquals("d", Dj.resoudre(gl,"a").getParent("c"),"Le parent de c devrait etre d");
    }
}
