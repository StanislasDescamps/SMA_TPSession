/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Avion extends Agent {
    private enum Etat {NOMINAL,AVARIE}

    private String callsign;
    private int carburant;
    private Scenario scenario;
    private Etat etat;
    
    public Avion(String nomAgent, String idAvion, int fuel, Scenario scene, Etat etat){
    	super(nomAgent);
    	this.callsign=idAvion;
    	this.carburant=fuel;
    	this.scenario=scene;
    	this.etat=etat;
    }
}
