/** Represents a Motocicleta, which extends Autovehicul class.
 * @author Vlad Stoica
 */
public class Motocicleta extends Autovehicul {

    /** Creates a Motocicleta, with a specific cost,type and weight(gabarit).
     */
    Motocicleta() {
        super.tip = "Moped";
        super.gabarit = 1;
        super.cost = 2;
    }
}
