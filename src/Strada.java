/** Represents a Street(edge between 2 Nodes).
 * Multiple streets can be added to a node.
 * @author Vlad Stoica
 */

public class Strada {
    private String name;
    private int cost;
    private int limita_gabarit;
    private int index_nd;
    private int nr_ambutiaje;
    private String nod_destinatie;
    private Ambuteiaj[] amb;

    /** Creates a street.
     * @param nume -> name of the street(usually the name of the
     *             start Node concatenated with the name of the
     *             destination Node; ex: P0P1, P2P5).
     * @param cost -> the cost of the street.
     * @param limita_gabarit -> maximum weight allowed on this street.
     * @param nd -> the index of the destination Node, as an integer.
     */
    Strada(String nume,int cost,int limita_gabarit,String nd) {
        this.nr_ambutiaje = 0;
        this.name = nume;
        this.cost = cost;
        this.limita_gabarit = limita_gabarit;
        this.nod_destinatie = nd;
        this.index_nd = Integer.parseInt(nd.substring(1));
    }

    /** This function creates a new array of restrictions(ambuteiaje)
     * with the size of the old one + 1, and adds a new restriction.
     * @param amb represents the old array of restrictions.
     * @param tip represents the type of the newly added restriction.
     * @param cost represents the cost of the newly added restriction.
     * @return returns a new array with the previous restrictions + the
     * new one.
     */
    public Ambuteiaj[] AdaugaAmbuteiaj(Ambuteiaj[] amb,String tip, int cost) {
        Ambuteiaj[] ambuteiaj_nou = new Ambuteiaj[nr_ambutiaje + 1];
        for(int i = 0; i < nr_ambutiaje; i++)
            ambuteiaj_nou[i] = amb[i];
        ambuteiaj_nou[nr_ambutiaje] = new Ambuteiaj(tip,cost);
        this.nr_ambutiaje ++;
        return ambuteiaj_nou;
    }

    /** Gets the number of restrictions for this street.
     * @return an int representing the no of restrictions.
     */
    int getNr_ambutiaje() {
        return this.nr_ambutiaje;
    }

    /** Gets the array of restrictions for this street, as a
     * street can have more restrictions.
     * @return an Ambuteiaj[] array.
     */
    public Ambuteiaj[] getAmb() {
        return this.amb;
    }

    /** Sets the array of restrictions for this street.
     * @param a is the new array.
     */
    public void setAmb(Ambuteiaj[] a) {
        this.amb = a;
    }

    /** Gets the 'x' restriction from the array.
     * @param x the index of restriction.
     * @return a restriction (Ambuteiaj).
     */
    public Ambuteiaj getAmbuteiaj(int x) {
        return this.amb[x];
    }

    /** Gets the maximum weight for this street.
     * @return an integer, the weight limit.
     */
    int getLimitaGabarit() {
        return this.limita_gabarit;
    }

    /** Gets the cost of this street.
     * @return returns an integer, representig the cost.
     */
    int getCost() {
        return this.cost;
    }

    /** Gets the index for the destination Node.
     * @return returns an int, representing the destination node's index.
     */
    int getIndexDestinatie() {
        return this.index_nd;
    }

    /** Gets the name of this street.
     * @return returns a String with the name.
     */
    String getNume() {
        return this.name;
    }
}
