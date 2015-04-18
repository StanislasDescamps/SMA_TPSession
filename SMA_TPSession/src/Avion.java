/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Avion extends Agent {
    public enum Etat {NOMINAL, AVARIE}

    private int      carburant;
    private Scenario scenario;
    private Etat     etat;
    private int      nbMouvements;

    public Avion(String nomAgent) {
        super(nomAgent);
        this.carburant = 0;
        this.etat = Etat.NOMINAL;
        nbMouvements = 0;
    }

    public Avion(String nomAgent, int fuel, Scenario scene, Etat etat) {
        super(nomAgent);
        this.carburant = fuel;
        this.scenario = scene;
        this.etat = etat;
        nbMouvements = 0;
    }

    public void bouge() {
        scenario.nouvelleBalise();

        if (scenario.getBaliseActuelle().getAlea() != Balise.Aleas.RAS)
            MoteurInference.gestionAleasAvion(scenario.getBaliseActuelle().getAlea());

        nbMouvements += 1;
        carburant -= 1;
    }
    
    public int getCarburant() {
		return carburant;
	}

	public void setCarburant(int carburant) {
		this.carburant = carburant;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}
}
