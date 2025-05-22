import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Graphe {
    @Test
    public void Test01_AjouterArc() {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("a","b",2);
        assertEquals(0,gl.getIndice("a"),"Le noeud a devrait etre en 0; Noeud a : " + gl.getIndice("a"));
        assertEquals(1,gl.getIndice("b"),"Le noeud b devrait etre en 1; Noeud b : " + gl.getIndice("b"));
        assertEquals(2,gl.suivants("a").get(0).getC(),"Le cout devrait etre de 2; cout pour aller a b : " + gl.suivants("a").get(0).getC());
    }
    @Test
    public void Test02_AjouterPlusieurArc() {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("a","b",2);
        gl.ajouterArc("a","d",5);
        gl.ajouterArc("d","a",3);
        assertEquals(0,gl.getIndice("a"),"Le noeud a devrait etre en 0; Noeud a : " + gl.getIndice("a"));
        assertEquals(1,gl.getIndice("b"),"Le noeud b devrait etre en 1; Noeud b : " + gl.getIndice("b"));
        assertEquals(2,gl.getIndice("d"),"Le noeud c devrait etre en 2; Noeud c : " + gl.getIndice("d"));
        assertEquals(2,gl.suivants("a").get(0).getC(),"Le cout devrait etre de 2; cout pour aller à b : " + gl.suivants("a").get(0).getC());
        assertEquals(5,gl.suivants("a").get(1).getC(),"Le cout devrait etre de 5; cout pour aller à c : " + gl.suivants("a").get(1).getC());
        assertEquals(3,gl.suivants("d").get(0).getC(),"Le cout devrait etre de 3; cout pour aller à a : " + gl.suivants("d").get(0).getC());
    }
}
