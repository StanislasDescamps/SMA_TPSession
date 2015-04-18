/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Avion extends Agent {
    private enum Etat {NOMINAL, AVARIE}

    private int carburant;
    private Scenario scenario;
    private Etat etat;
    
    public Avion(String nomAgent){
    	super(nomAgent);
    	this.carburant=0;
    	//RandomScene();
    	this.etat=Etat.NOMINAL;
    }
    
    public Avion(String nomAgent, int fuel, Scenario scene, Etat etat){
    	super(nomAgent);
    	this.carburant=fuel;
    	this.scenario=scene;
    	this.etat=etat;
    }
}
