
public class Avion extends Agent {
    public enum Etat {NOMINAL, AVARIE, ATTENTE}

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

    public Avion(String nomAgent, Scenario scenario) {
        super(nomAgent);
        this.carburant = 10;
        this.scenario = scenario;
        this.etat = Etat.ATTENTE;
        for (Aeroport aeroport : Environnement.aeroports) {
            if (aeroport.getIATACode().equals(this.scenario.getDepart()))
                aeroport.getEnAttenteDecollage().add(this);
        }
    }

    public void bouge() {
        if (etat != Etat.ATTENTE) {
            if (scenario.nouvelleBalise()) {
                if (scenario.getBaliseActuelle().getAlea() != Balise.Aleas.RAS)
                    MoteurInference.gestionAleasAvion(this, scenario.getBaliseActuelle().getAlea());
                carburant -= 1;
                scenario.getProchainesBalises().remove(0);
            } else {
                for (Aeroport aeroport : Environnement.aeroports)
                    if (aeroport.getIATACode().equals(scenario.getArrivee())) {
                        aeroport.getEnAttenteAtterissage().add(this);
                        this.etat = Etat.ATTENTE;
                        System.out.println("L'avion ["+ nomAgent +"] "+ scenario.getDepart() +"-"+ scenario.getArrivee() +" est en attente pour atterir.");
                        break;
                    }
            }
        }
    }

    public void demiTour() {
        scenario.demiTour();
        System.out.println("L'avion ["+ nomAgent +"] "+ scenario.getDepart() +"-"+ scenario.getArrivee() +" fait demi-tour.");
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
