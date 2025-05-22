import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{

    private ArrayList<String> noeuds = new ArrayList<String>();
    private ArrayList<Arcs> adjacence = new ArrayList<Arcs>();

    /**
     * Méthode qui prend en paramètre une chaîne de caractère correspondant à un noeud
     * et retourne sa place dans la liste des noeuds
     * @param n de type String
     * @return de type int
     */
    public int getIndice(String n) {
        return noeuds.indexOf(n);
    }

    /**
     * Méthode qui renvoie la liste des noeuds
     * @return de type List de String
     */
    public List<String> listeNoeud() {
        return noeuds;
    }

    /**
     * Méthode qui renvoie la liste des arcs adjacents au noeud u passé en paramètre
     * @param u de type String
     * @return de type List d'objet Arc
     */
    public List<Arc> suivants(String u) {
        return adjacence.get(getIndice(u)).getArcs();
    }

    /**
     * Méthode qui ajoute un nouvelle Arc à la liste des Arcs adjacents au noeud depart passé en paramètre
     * @param depart de type String
     * @param destination de type String
     * @param cout de type double
     */
    public void ajouterArc(String depart, String destination, double cout) {
        if (!noeuds.contains(depart)) {
            noeuds.add(depart);
            adjacence.add(new Arcs()); // Ajouter une liste vide pour le sommet
        }
        if (!noeuds.contains(destination)) {
            noeuds.add(destination);
            adjacence.add(new Arcs()); // Pareil pour la destination
        }

        Arc newArc = new Arc(destination, (int) cout);
        int indiceDepart = getIndice(depart);
        adjacence.get(indiceDepart).getArcs().add(newArc);
    }
    /**
     * Méthode qui renvoie chaque noeud associé à chaque liste de ces arcs adjacent
     * @return de type String
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < noeuds.size(); i++) {
            str = str + noeuds.get(i) + " -> ";
            for (int j = 0; j < adjacence.get(i).getArcs().size(); j++) {
                str = str + adjacence.get(i).getArcs().get(j).getD() + "(" + adjacence.get(i).getArcs().get(j).getC() + ") ";
            }
            str = str + "\n";
        }
        return str;
    }
}
