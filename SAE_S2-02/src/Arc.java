public class Arc {
    private double c;
    private String d;
    private String ligne;

    /**
     * Constructeur simple qui créer un Arc avec ça destination et son cout
     * @param dest
     * @param cout
     */
    public Arc(String dest, double cout) {
        this.c = cout;
        this.d = dest;
    }

    /**
     * Constructeur qui créer un Arc similaire au constructeur précédent en ajoutant un attribut ligne
     * qui est le numéro de la ligne de l'Arc pour le fichier de réseau de métro
     * @param dest
     * @param cout
     * @param ligne
     */
    public Arc(String dest, double cout, String ligne) {
        this.c = cout;
        this.d = dest;
        this.ligne = ligne;
    }

    /**
     * getter du cout
     * @return double
     */
    public double getC() {
        return c;
    }

    /**
     * getter de la detination
     * @return String
     */
    public String getD() {
        return d;
    }


    /**
     * getter de la ligne
     * @return
     */
    public String getLigne() {
        return ligne;
    }
}
