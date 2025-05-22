import java.util.List;

public interface Graphe {
    /**
     *
     * @return List<String>
     */
    public List<String> listeNoeud();

    /**
     *
     * @param u
     * @return List<Arc>
     */
    public List<Arc> suivants(String u);
}
