public class MainDijkstra {
    public static void main(String[] args) {
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("a","b",12);
        gl.ajouterArc("a","d",87);
        gl.ajouterArc("b","e",11);
        gl.ajouterArc("c","a",19);
        gl.ajouterArc("d","b",23);
        gl.ajouterArc("d","c",10);
        gl.ajouterArc("e","d",43);

        Djikstra Dj = new Djikstra();
        System.out.println(Dj.resoudre(gl,"a"));
    }
}
