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

    /**
     * Méthode qui retourne un objet de type Valeurs correspondant aux principes du point fixe de BellmanFord
     * permettant de trouver les plus courts chemins entre un point de départ et tout les autres du graphe
     * @param g de type Graphe
     * @param depart de type String
     * @return de type Valeurs
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

    /**
     * Méthode qui retourne un objet de type Valeurs correspondant aux principes du point fixe de BellmanFord
     * permettant de trouver les plus courts chemins entre un point de départ et tout les autres du graphe
     * En plus cette Méthode rajoute une pénalité de 10 si on change de ligne
     * @param g de type Graphe
     * @param depart de type String
     * @return de type Valeurs
     */
    public Valeurs resoudre2(Graphe g, String depart) {
        Valeurs valeurs = new Valeurs();
        String derniereLigne = null;
        for(int x = 0; x<g.listeNoeud().size(); x++) {
            valeurs.setValeur(g.listeNoeud().get(x), Double.MAX_VALUE);
            valeurs.setParent(g.listeNoeud().get(x), "");
        }
        valeurs.setValeur(depart, 0);
        valeurs.setParent(depart, "");
        boolean modifie = true;
        while(modifie) {
            modifie = false;
            derniereLigne = g.suivants(g.listeNoeud().get(0)).get(0).getLigne();
            for(int x = 0; x<g.listeNoeud().size(); x++) {
                List<Arc> voisins = g.suivants(g.listeNoeud().get(x));
                for(int n = 0; n<voisins.size(); n++) {
                    double coutArc = voisins.get(n).getC();
                    double penalite = 10;
                    if (derniereLigne.equals(voisins.get(n).getLigne())) {
                        penalite = 0;
                    }
                    double nouvelleValeur = valeurs.getValeur(g.listeNoeud().get(x)) + coutArc + penalite;
                    if(nouvelleValeur < valeurs.getValeur(voisins.get(n).getD())) {
                        valeurs.setValeur(voisins.get(n).getD(), nouvelleValeur);
                        valeurs.setParent(voisins.get(n).getD(), g.listeNoeud().get(x));
                        derniereLigne = voisins.get(n).getLigne();
                        modifie = true;
                    }
                }
            }
        }
        return valeurs;
    }

}