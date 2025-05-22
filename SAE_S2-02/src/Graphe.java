import java.util.List;

public interface Graphe {
    public List<String> listeNoeud();

    public List<Arc> suivants(String u);
}
