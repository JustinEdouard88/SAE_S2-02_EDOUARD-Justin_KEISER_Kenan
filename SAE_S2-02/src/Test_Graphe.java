import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_Graphe {
    @Test
    public void Test01_AjouterArc() {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("a","b",2);
        assertEquals(1,gl.getIndice("a"),"");
    }
}
