import java.util.ArrayList;
import java.util.List;

public class Arcs {
    private List<Arc> arcs;

    /*Constructeur de classe qui instancie une liste vide
     */
    public Arcs() {
        this.arcs = new ArrayList<>();
    }

    /*Méthode qui ajoute un Arc a à la liste actuelle
    @param a de type Arc
     */
    public void ajouterArc(Arc a) {
        this.arcs.add(a);
    }

    /*Méthode getter qui retourne l'entiereté de la liste arcs
     */
    public List<Arc> getArcs() {
        return this.arcs;
    }
}
