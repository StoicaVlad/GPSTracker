/** Represents a Bicycle, extending the Autovehicul class.
 * @author Vlad Stoica
 */
public class Bicicleta extends  Autovehicul {

    /** Creates a Bicicleta, with a specific cost,type and weight(gabarit).
     */
    Bicicleta() {
        super.tip = "Moped";
        super.gabarit = 1;
        super.cost = 1;
    }
}
