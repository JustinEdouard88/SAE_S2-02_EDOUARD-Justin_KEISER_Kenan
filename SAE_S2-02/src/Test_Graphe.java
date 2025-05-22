import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Graphe {
    @Test
    public void Test01_AjouterArc() {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("a","b",2);
        assertEquals(0,gl.getIndice("a"),"Le noeud a devrait etre en 1; Noeud a : " + gl.getIndice("a"));
        assertEquals(1,gl.getIndice("b"),"Le noeud b devrait etre en 1; Noeud b : " + gl.getIndice("b"));
    }
}
