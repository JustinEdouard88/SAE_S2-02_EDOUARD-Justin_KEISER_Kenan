import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LireReseau {

    /**
     * Méthode qui permet de lire un fichier de réseau de métro soumis sous une forme particulière
     * cette Méthode à été réfléchie durant la SAE pour convenir au type de fichier de réseau de métro
     * soumis sous arche
     * Cette méthode transforme le fichier en 'graphe' utilisable
     * @param fichier de type String
     * @return Graphe
     * @throws Exception
     */
    public static Graphe lire(String fichier) throws Exception {
        GrapheListe graphe = new GrapheListe();
        ArrayList<String[]> stations = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("%% Stations:")) {
                break;
            }
        }
        while ((line = br.readLine()) != null) {
            if (line.startsWith("%% Connexions:")) {
                break;
            }
            if (!line.startsWith("%")) {
                String[] parts = line.split(":");
                if (parts.length >= 5) {
                    stations.add(new String[]{parts[0], parts[1]});
                }
            }
        }
        while ((line = br.readLine()) != null) {
            if (!line.startsWith("%")) {
                String[] parts = line.split(":");
                if (parts.length >= 4) {
                    String idDepart = parts[0];
                    String idArrivee = parts[1];
                    double cout = Double.parseDouble(parts[2]);
                    String ligne = parts[3];
                    String nomDepart = null;
                    String nomArrivee = null;
                    for (String[] station : stations) {
                        if (station[0].equals(idDepart)) {
                            nomDepart = station[1];
                        }
                    }
                    for (String[] station : stations) {
                        if (station[0].equals(idArrivee)) {
                            nomArrivee = station[1];
                        }
                    }
                    if (nomDepart != null && nomArrivee != null) {
                        graphe.ajouterArc(nomDepart, nomArrivee, cout, ligne);
                        graphe.ajouterArc(nomArrivee, nomDepart, cout, ligne);
                    }
                }
            }
        }
        br.close();
        return graphe;
    }
}