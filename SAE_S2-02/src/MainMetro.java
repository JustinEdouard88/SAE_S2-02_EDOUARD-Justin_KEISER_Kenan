import java.util.List;

public class MainMetro {
    public static void main(String[] args) throws Exception {

        Graphe metro = LireReseau.lire("./Graphe/Reseau.txt");
        String[] departs = {"La Défense", "Gare du Nord", "Montparnasse Bienvenue", "Nation", "Châtelet"};
        String[] arrivees = {"Châtelet", "Gare de Lyon", "Saint-Lazare", "La Défense", "Gare du Nord"};

        BellmanFord bellman = new BellmanFord();
        Djikstra dijkstra = new Djikstra();

        for (int i = 0; i < departs.length; i++) {
            String depart = departs[i];
            String arrivee = arrivees[i];

            long debutBellman = System.currentTimeMillis();
            Valeurs resultats = bellman.resoudre(metro, depart);
            long tempsBellman = System.currentTimeMillis() - debutBellman;

            long debutDijkstra = System.currentTimeMillis();
            dijkstra.resoudre(metro, depart);
            long tempsDijkstra = System.currentTimeMillis() - debutDijkstra;


            List<String> chemin = resultats.calculerChemin(arrivee);
            System.out.println("(" + i + ")");
            System.out.println("Chemin de " + depart + " à " + arrivee + ":");
            for (String station : chemin) {
                System.out.println("- " + station);
            }
            System.out.println("Temps Bellman :" + tempsBellman);
            System.out.println("Temps Dijkstra :" + tempsDijkstra + "\n");
        }

        //Penalite

        System.out.println("Avec Penalite : \n");
        for (int i = 0; i < departs.length; i++) {
            String depart = departs[i];
            String arrivee = arrivees[i];

            long debutBellman = System.currentTimeMillis();
            Valeurs resultats = bellman.resoudre2(metro, depart);
            long tempsBellman = System.currentTimeMillis() - debutBellman;

            long debutDijkstra = System.currentTimeMillis();
            dijkstra.resoudre2(metro, depart);
            long tempsDijkstra = System.currentTimeMillis() - debutDijkstra;


            List<String> chemin = resultats.calculerChemin(arrivee);
            System.out.println("(" + i + ")");
            System.out.println("Chemin de " + depart + " à " + arrivee + ":");
            for (String station : chemin) {
                System.out.println("- " + station);
            }
            System.out.println("Temps Bellman :" + tempsBellman);
            System.out.println("Temps Dijkstra :" + tempsDijkstra + "\n");
        }
    }
}