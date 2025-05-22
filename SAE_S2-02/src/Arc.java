public class Arc {
    private int c;
    private String d;

    /**
     *
     * @param String dest
     * @param int cout
     */
    public Arc(String dest, int cout){
        this.c = cout;
        this.d = dest;
    }

    /**
     *
     * @return int
     */
    public int getC() {
        return c;
    }

    /**
     *
     * @return int
     */
    public String getD() {
        return d;
    }
}
