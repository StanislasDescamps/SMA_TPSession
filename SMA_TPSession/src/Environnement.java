import java.util.ArrayList;
import java.util.Random;

public class Environnement {
    public static final ArrayList<Aeroport> aeroports = new ArrayList<>();
    public static final ArrayList<Avion>    avions    = new ArrayList<>();
    public static final ArrayList<Balise>   balises   = new ArrayList<>();
    public static final ArrayList<Scenario> scenarios = new ArrayList<>();

    private boolean isRunning            = false;
    private int     secondsBeforeRefresh = 1;

    public Environnement() {
        remplirAeroports();
        remplirBalises();
        remplirAvions();
        remplirScenarios();
    }

    public void run() {
        long lastTime, currentTime;
        isRunning = true;
        Random rand = new Random();

        while (isRunning) {
            lastTime = System.currentTimeMillis();

            // Logic //////////////////////////////////////////////////////////////
            System.out.println("/////////////////////////////////////////////////////////////////////////////");
            // Cree un aleas aleatoire sur une balise, ou pas
            if (rand.nextInt(2) == 1) {
                int aleasIndex = rand.nextInt(Balise.Aleas.values().length - 1);
                int aleasDuree = rand.nextInt(4 - 2) + 1;
                int baliseIndex = rand.nextInt(balises.size());

                if (balises.get(baliseIndex).getAlea() == Balise.Aleas.RAS)
                    balises.get(baliseIndex).changeAlea(aleasIndex, aleasDuree);
            }

            // Traitement aeroports
            // Tri des avions a l'arrivee (carburant + etat)
            MoteurInference.prioriteArrivee();

            // Atterrissage d'un avion et placement dans liste de decollage
            for (Aeroport aeroport : aeroports) {
                if (!aeroport.getEnAttenteAtterissage().isEmpty()) {
                    aeroport.getEnAttenteAtterissage().get(0).setScenario(
                            new Scenario(
                                    aeroport.getIATACode(),
                                    Aeroport.nextDestination(aeroport.getIATACode())
                            ));
                    aeroport.getEnAttenteDecollage().add(aeroport.getEnAttenteAtterissage().get(0));
                    aeroport.getEnAttenteAtterissage().remove(0);
// System.out.println(aeroport.getEnAttenteDecollage().get(0).getNomAgent() + " est bien arriv� � " + aeroport.getNomAgent() + ". Il repartira bientot pour " + nextDestination);
                }
            }

            // Bouge avions
            for (Aeroport aeroport : aeroports)
                if (!aeroport.getEnAttenteDecollage().isEmpty()) {
                    aeroport.getEnAttenteDecollage().get(0).setEtat(Avion.Etat.NOMINAL);
                    System.out.println("[" + aeroport.getEnAttenteDecollage().get(0).getNomAgent() + "] "
                                       + aeroport.getEnAttenteDecollage().get(0).getScenario().getDepart()
                                       + "-"
                                       + aeroport.getEnAttenteDecollage().get(0).getScenario().getArrivee() +
                                       " pret a partir."
                                      );
                    aeroport.getEnAttenteDecollage().remove(0);
                }

            for (Avion avion : avions) {
                avion.bouge();
            }

            // Logic end //////////////////////////////////////////////////////////

            currentTime = System.currentTimeMillis();
            if (currentTime < lastTime + secondsBeforeRefresh * 1000)
                try {
                    Thread.sleep(lastTime + secondsBeforeRefresh * 1000 - currentTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    private void remplirAeroports() {
        //Remplissage de la liste des aéroports
        aeroports.add(new Aeroport("Paris", "ORY"));
        aeroports.add(new Aeroport("Lille", "LIL"));
        aeroports.add(new Aeroport("Bordeaux", "BOD"));
        aeroports.add(new Aeroport("Lyon", "LYS"));
        aeroports.add(new Aeroport("Nice", "NCE"));
    }

    private void remplirBalises() {
        //Remplissage de la liste des balises
        balises.add(new Balise("LIL-ORY-01"));
        balises.add(new Balise("LIL-ORY-02"));

        balises.add(new Balise("LIL-BOD-01"));
        balises.add(new Balise("LIL-BOD-02"));
        balises.add(new Balise("LIL-BOD-03"));
        balises.add(new Balise("LIL-BOD-04"));
        balises.add(new Balise("LIL-BOD-05"));
        balises.add(new Balise("LIL-BOD-06"));
        balises.add(new Balise("LIL-BOD-07"));

        balises.add(new Balise("LIL-NCE-01"));
        balises.add(new Balise("LIL-NCE-02"));
        balises.add(new Balise("LIL-NCE-03"));
        balises.add(new Balise("LIL-NCE-04"));
        balises.add(new Balise("LIL-NCE-05"));
        balises.add(new Balise("LIL-NCE-06"));
        balises.add(new Balise("LIL-NCE-07"));


        balises.add(new Balise("LIL-LYS-01"));
        balises.add(new Balise("LIL-LYS-02"));
        balises.add(new Balise("LIL-LYS-03"));
        balises.add(new Balise("LIL-LYS-04"));
        balises.add(new Balise("LIL-LYS-05"));

        balises.add(new Balise("LYS-NCE-01"));
        balises.add(new Balise("LYS-NCE-02"));
        balises.add(new Balise("LYS-NCE-03"));
        balises.add(new Balise("LYS-NCE-04"));

        balises.add(new Balise("ORY-NCE-01"));
        balises.add(new Balise("ORY-NCE-02"));
        balises.add(new Balise("ORY-NCE-03"));
        balises.add(new Balise("ORY-NCE-04"));
        balises.add(new Balise("ORY-NCE-05"));

        balises.add(new Balise("ORY-LYS-01"));
        balises.add(new Balise("ORY-LYS-02"));
        balises.add(new Balise("ORY-LYS-03"));

        balises.add(new Balise("ORY-BOD-01"));
        balises.add(new Balise("ORY-BOD-02"));
        balises.add(new Balise("ORY-BOD-03"));
        balises.add(new Balise("ORY-BOD-04"));

        balises.add(new Balise("BOD-NCE-01"));
        balises.add(new Balise("BOD-NCE-02"));
        balises.add(new Balise("BOD-NCE-03"));
        balises.add(new Balise("BOD-NCE-04"));
        balises.add(new Balise("BOD-NCE-05"));

        balises.add(new Balise("BOD-LYS-01"));
        balises.add(new Balise("BOD-LYS-02"));
        balises.add(new Balise("BOD-LYS-03"));
        balises.add(new Balise("BOD-LYS-04"));
        balises.add(new Balise("BOD-LYS-05"));
        balises.add(new Balise("BOD-LYS-06"));
        balises.add(new Balise("BOD-LYS-07"));
    }

    private void remplirAvions() {
        //Remplissage de la liste des avions
        avions.add(new Avion("AF 101", new Scenario("ORY", "LIL")));
        avions.add(new Avion("AF 202", new Scenario("LYS", "LIL")));
        avions.add(new Avion("AF 103", new Scenario("LIL", "LYS")));
        avions.add(new Avion("AF 880", new Scenario("BOD", "NCE")));
        avions.add(new Avion("FR 325", new Scenario("NCE", "ORY")));
        avions.add(new Avion("FR 001", new Scenario("ORY", "BOD")));
        avions.add(new Avion("FR 999", new Scenario("NCE", "LYS")));
        avions.add(new Avion("FR 020", new Scenario("BOD", "LIL")));
        avions.add(new Avion("FR 330", new Scenario("ORY", "NCE")));
    }

    private void remplirScenarios() {
        scenarios.add(new Scenario("LIL", "LYS"));
        scenarios.add(new Scenario("LIL", "ORY"));
        scenarios.add(new Scenario("LIL", "BOD"));
        scenarios.add(new Scenario("LIL", "NCE"));
        scenarios.add(new Scenario("BOD", "LIL"));
        scenarios.add(new Scenario("BOD", "ORY"));
        scenarios.add(new Scenario("BOD", "LYS"));
        scenarios.add(new Scenario("BOD", "NCE"));
        scenarios.add(new Scenario("ORY", "BOD"));
        scenarios.add(new Scenario("ORY", "LIL"));
        scenarios.add(new Scenario("ORY", "LYS"));
        scenarios.add(new Scenario("ORY", "NCE"));
        scenarios.add(new Scenario("LYS", "LIL"));
        scenarios.add(new Scenario("LYS", "ORY"));
        scenarios.add(new Scenario("LYS", "NCE"));
        scenarios.add(new Scenario("LYS", "BOD"));
        scenarios.add(new Scenario("NCE", "LYS"));
        scenarios.add(new Scenario("NCE", "ORY"));
        scenarios.add(new Scenario("NCE", "BOD"));
        scenarios.add(new Scenario("NCE", "LIL"));
    }
}
