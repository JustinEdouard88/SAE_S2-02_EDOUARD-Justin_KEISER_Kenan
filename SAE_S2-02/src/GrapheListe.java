import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class GrapheListe implements Graphe{

    private ArrayList<String> noeuds = new ArrayList<String>();
    private ArrayList<Arcs> adjacence = new ArrayList<Arcs>();

    /**
     * Constructeur qui prend un nom de fichier en paramètre et
     * li les données du fichier pour en faire un graphe
     * @param nom de type String
     * @throws IOException
     */
    public GrapheListe(String nom) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nom));
        String line = br.readLine();
        while(line != null) {
            String[] split = line.split(" ");
            String from = split[0].toLowerCase();
            String to = split[1].toLowerCase();
            int cost = Integer.parseInt(split[2]);
            ajouterArc(from, to, cost, null);
            line = br.readLine();
        }
    }

    public GrapheListe() {
        this.noeuds = new ArrayList<String>();
        this.adjacence = new ArrayList<Arcs>();
    }

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
    public void ajouterArc(String depart, String destination, double cout, String ligne) {
        if (!noeuds.contains(depart)) {
            noeuds.add(depart);
            adjacence.add(new Arcs());
        }
        if (!noeuds.contains(destination)) {
            noeuds.add(destination);
            adjacence.add(new Arcs());
        }

        Arc newArc;
        if (ligne != null) {
            newArc = new Arc(destination, cout, ligne);
        } else {
            newArc = new Arc(destination, cout);
        }
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
