/** Represents a Camion, which extends Autovehicul class.
 * @author Vlad Stoica
 */
public class Camion extends Autovehicul {

    /** Creates a Camion, with a specific cost,type and weight(gabarit).
     */
    Camion() {
        super.tip = "Autoutilitar";
        super.cost = 6;
        super.gabarit = 3;
    }
}
