/** Represents a Node.
 * @author Vlad Stoica
 */

public class Nod {
    private String name;
    private int nr_paths;
    private Boolean visited = false;
    private Strada[] streets = new Strada[nr_paths];

    /** Creates a Node with number of current edges = 0
     * and without name.
     */
    Nod() {
        this.nr_paths = 0;
    }

    /** Creates a Node with number of current edges = 0.
     * @param name represents the name of the node (usually Pi
     *             i -> node index; ex: P0, P2)
     */
    Nod(String name) {
        this.name = name;
        this.nr_paths = 0;
    }

    /** Gets the index of this node.
     * @return returns an int representing the index.
     */
    public int getIndex() {
        return Integer.parseInt(name.substring(1));
    }

    /** Gets the number of streets for this node.
     * @return returns an int representing the number of edges.
     */
    public int getVecini() {
        return nr_paths;
    }

    /** Gets the 'x' street form the array.
     * @param x is the street's index.
     * @return a Street (Strada).
     */
    public Strada getStrada(int x) {
        return streets[x];
    }

    /** Gets the Streets array for this node.
     * @return the street array as a Strada[] type.
     */
    public Strada[] getVectorStrazi() {
        return streets;
    }

    /** Sets the Street array for this node.
     * @param s represents the streets array for this node.
     */
    public void setVectorStrazi(Strada[] s) {
        this.streets = s;
    }

    /** Gets the visited value for this node.
     * @return returns a boolean value, which shows if this node was
     * visited or not.
     */
    Boolean getVisited() {
        return this.visited;
    }

    /** Gets the name for this Node.
     * @return returns a String representing the name.
     */
    String getName() {
        return this.name;
    }

    /** Sets the visited value for this node.
     * @param valoare represents the value given to the boolean variable.
     */
    void setVisited(Boolean valoare) {
        this.visited = valoare;
    }

    /** Adds a new street to the Streets (Strada[] strazi) array,
     * representing an edge to another Node.
     * @param strazi is the current Streets array for this node.
     * @param add represents the street to be added.
     * @return returns a new array of streets with the old ones
     * and the new street.
     */
    public Strada[] AdaugaStrada(Strada[] strazi, Strada add) {

        Strada[] newstr = new Strada[nr_paths + 1];
        for(int i = 0; i < nr_paths; i++)
            newstr[i] = strazi[i];
        newstr[nr_paths] = add;
        this.nr_paths++;
        return newstr;
    }

}
