/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Avion extends Agent {
    public enum Etat {NOMINAL, AVARIE}

    private int      carburant;
    private Scenario scenario;
    private Etat     etat;

    public Avion(String nomAgent) {
        super(nomAgent);
        this.carburant = 0;
        this.etat = Etat.NOMINAL;
    }

    public Avion(String nomAgent, int fuel, Scenario scene, Etat etat) {
        super(nomAgent);
        this.carburant = fuel;
        this.scenario = scene;
        this.etat = etat;
    }

    public void bouge() {
        scenario.nouvelleBalise();

        carburant -= 1;
    }

    public void demiTour() {
        scenario.demiTour();
    }

    public int getCarburant() {
        return carburant;
    }

    public void diminueCarburant(int diminution) {
        this.carburant -= diminution;
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
