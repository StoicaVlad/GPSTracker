/** Represents a restriction.
 * Can be added to a street and increases it's cost.
 * @author Vlad Stoica
 */
public class Ambuteiaj {
    private String tip;
    private int cost;

    /** Creates a restriction.
     * @param tip The restriction's type.
     * @param cost The restriction's cost.
     */
    Ambuteiaj(String tip,int cost) {
        this.tip = tip;
        this.cost = cost;
    }

    /** Gets the restriction's type.
     * @return a string representig the type.
     */
    String getTip() {
        return this.tip;
    }

    /** Gets the restriction's cost.
     *
     * @return an int representing the cost.
     */
    int getCost() {
        return this.cost;
    }
}
