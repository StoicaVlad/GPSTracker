/** Represents an Autoturism, extending Autovehicul class.
 * @author Vlad Stoica
 */
public class Autoturism extends Autovehicul {

    /** Creates an Autoturism, with a specific cost,type and weight(gabarit).
     */
    Autoturism() {
        super.tip = "Autovehicul";
        super.cost = 4;
        super.gabarit = 2;
    }
}
