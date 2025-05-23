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
     *         L[depart] ← 0
     *         parent[depart] ← ""
     *         modifie ← vrai
     *         tant que modifie = vrai faire
     *             modifie ← faux
     *             pour chaque X dans G faire
     *                 voisins ← voisins de X dans G
     *                 pour chaque N dans voisins faire
     *                     coutArc ← coût de l'arc de X à N dans G
     *                     nouvelleValeur ← L[X] + coutArc
     *                     si nouvelleValeur < L[N] alors
     *                         L[N] ← nouvelleValeur
     *                         parent[N] ← X
     *                         modifie ← vrai
     *                     fsi
     *                 fpour
     *             fpour
     *         ftant
     *     fin
     */

    public Valeurs resoudre(Graphe g, String depart) {

    }


}
