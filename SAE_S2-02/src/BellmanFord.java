import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    /**
     * Algo Point Fixe
     *
     * fonction pointFixe(G : graphe, depart : chaîne) : rien
     *     début
     *         pour chaque X dans G faire
     *             L[X] ← +∞
     *             parent[X] ← ""
     *         fpour
     *
     *         L[depart] ← 0
     *         parent[depart] ← ""
     *
     *         modifie ← vrai
     *
     *         tant que modifie = vrai faire
     *             modifie ← faux
     *
     *             pour chaque X dans G faire
     *                 voisins ← voisins de X dans G
     *
     *                 pour chaque N dans voisins faire
     *                     coutArc ← coût de l'arc de X à N dans G
     *                     nouvelleValeur ← L[X] + coutArc
     *
     *                     si nouvelleValeur < L[N] alors
     *                         L[N] ← nouvelleValeur
     *                         parent[N] ← X
     *                         modifie ← vrai
     *                     fsi
     *                 fpour
     *             fpour
     *         ftant
     *     fin
     *
     * Lexique:
     * G: graphe orienté
     * X: chaîne
     * N: chaîne
     * depart: chaîne
     * L: table de réels (associée à chaque nœud)
     * parent: table de chaînes (associée à chaque nœud)
     * voisins: tableau de chaînes
     * nouvelleValeur: réel
     * coutArc: réel
     * modifie: booléen
     *
     */

    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();
        for(int x = 0; x<g.listeNoeud().size(); x++) {
            valeurs.setValeur(g.listeNoeud().get(x), Double.MAX_VALUE);
            valeurs.setParent(g.listeNoeud().get(x), "");
        }
        valeurs.setValeur(depart, 0);
        valeurs.setParent(depart, "");
        boolean modifie = true;
        while(modifie) {
            modifie = false;
            for(int x = 0; x<g.listeNoeud().size(); x++) {
                List<Arc> voisins = g.suivants(g.listeNoeud().get(x));
                for(int n = 0; n<voisins.size(); n++) {
                    double coutArc = voisins.get(n).getC();
                    double nouvelleValeur = valeurs.getValeur(g.listeNoeud().get(x)) + coutArc;
                    if(nouvelleValeur < valeurs.getValeur(voisins.get(n).getD())) {
                        valeurs.setValeur(voisins.get(n).getD(), nouvelleValeur);
                        valeurs.setParent(voisins.get(n).getD(), g.listeNoeud().get(x));
                        modifie = true;
                    }
                }
            }
        }
        return valeurs;
    }

}
