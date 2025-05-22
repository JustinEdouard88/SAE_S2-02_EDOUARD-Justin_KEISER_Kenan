import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{

    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    /**
     * Méthode qui prend en paramètre une chaîne de caractère correspondant à un noeud
     * et retourne sa place dans la liste des noeuds
     * @param n de type String
     * @return de type int
     */
    public int getIndice(String n) {
        int indice = 0;
        for (int i = 0; i < noeuds.size(); i++) {
            if (noeuds.get(i).equals(n)) {
                indice = i;
            }
        }
        return indice;
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
        }
        if(!noeuds.contains(destination)) {
            noeuds.add(destination);
        }
        Arc newArc = new Arc(destination, (int)cout);
        adjacence.get(getIndice(depart)).getArcs().add(newArc);
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
