//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //2eme Partie
        GrapheListe gl = new GrapheListe();
        gl.ajouterArc("a","b",12);
        gl.ajouterArc("a","d",87);
        gl.ajouterArc("b","e",11);
        gl.ajouterArc("c","a",19);
        gl.ajouterArc("d","b",23);
        gl.ajouterArc("d","c",10);
        gl.ajouterArc("e","d",43);
        System.out.println(gl);

        //3eme Partie
        BellmanFord bf = new BellmanFord();
        long start = System.currentTimeMillis();
        System.out.println(bf.resoudre(gl,"a"));
        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("Temps d'exécution : " + duration + " ms");

        //4eme Partie
        Djikstra dj = new Djikstra();
        long start2 = System.currentTimeMillis();
        System.out.println(dj.resoudre(gl,"a"));
        long end2 = System.currentTimeMillis();
        long duration2 = end2 - start2;

        System.out.println("Temps d'exécution : " + duration2 + " ms");
    }
}