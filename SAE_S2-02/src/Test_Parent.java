import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Parent {
    @Test
    public void test_TrouverParent(){
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("a","b",12);
        gl.ajouterArc("a","d",87);
        gl.ajouterArc("b","e",11);
        gl.ajouterArc("c","a",19);
        gl.ajouterArc("d","b",23);
        gl.ajouterArc("d","c",10);
        gl.ajouterArc("e","d",43);

        BellmanFord bf = new BellmanFord();
        assertEquals("d",bf.resoudre(gl,"a").getParent("c"),"Le parent de c devrait etre d");

    }
}
