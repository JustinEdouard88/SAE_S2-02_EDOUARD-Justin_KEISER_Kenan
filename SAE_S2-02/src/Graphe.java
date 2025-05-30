import java.util.List;

public interface Graphe {
    /**
     * Méthode qui renvoie la liste des noeuds
     * @return de type List de String
     */
    public List<String> listeNoeud();

    /**
     * Méthode qui renvoie la liste des arcs adjacents au noeud u passé en paramètre
     * @param u de type String
     * @return de type List d'objet Arc
     */
    public List<Arc> suivants(String u);
}
