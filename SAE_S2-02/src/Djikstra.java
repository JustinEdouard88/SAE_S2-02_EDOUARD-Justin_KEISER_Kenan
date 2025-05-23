/*
Entrées :
G un graphe orienté avec une pondération positive des arcs
(coût ou poids)
A un sommet (départ) de G
Début
Q <- {} // utilisation d'une liste de noeuds à traiter
Pour chaque sommet v de G faire
v.valeur <- Infini
v.parent <- Indéfini
Q <- Q U {v} // ajouter le sommet v à la liste Q
Fin Pour
A.valeur <- 0
Tant que Q est un ensemble non vide faire
u <- un sommet de Q telle que u.valeur est minimal
// enlever le sommet u de la liste Q
Q <- Q \ {u}
Pour chaque sommet v de Q tel que l'arc (u,v) existe faire
d <- u.valeur + poids(u,v)
Si d < v.valeur
// le chemin est plus interessant
Alors v.valeur <- d
v.parent <- u
Fin Si
Fin Pour
Fin Tant que
Fin
*/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Djikstra {
    public static Valeurs resoudre(Graphe g, String depart) {
        Valeurs v = new Valeurs();
        Set<String> Q = new HashSet<>(g.listeNoeud());
        for (String noeud : Q) {
            v.setValeur(noeud, Double.POSITIVE_INFINITY);
            v.setParent(noeud, null);
        }
        v.setValeur(depart, 0.0);

        while (!Q.isEmpty()) {
            String u = null;
            double min = Double.POSITIVE_INFINITY;

            for (String s : Q) {
                if (v.getValeur(s) < min) {
                    min = v.getValeur(s);
                    u = s;
                }
            }

            if (u == null) break;
            Q.remove(u);
            for (Arc arc : g.suivants(u)) {
                String voisin = arc.getD();
                int cout = arc.getC();

                if (Q.contains(voisin)) {
                    double d = v.getValeur(u) + cout;
                    if (d < v.getValeur(voisin)) {
                        v.setValeur(voisin, d);
                        v.setParent(voisin, u);
                    }
                }
            }
        }

        return v;
    }
}
