/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Avion extends Agent {
    private enum Etat {NOMINAL,AVARIE}

    private String callsign;
    private int carburant;
    private Scenario scenario;
    private Etat etat;
}
