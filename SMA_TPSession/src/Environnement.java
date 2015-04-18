import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Environnement {
    public static ArrayList<Aeroport> aeroports;
    private ArrayList<Avion>    avions;
    private ArrayList<Balise>   balises;

    private       boolean isRunning            = false;
    private final int     secondsBeforeRefresh = 1;

    public Environnement() {

        //Création des listes
        aeroports = new ArrayList<Aeroport>();
        avions = new ArrayList<Avion>();
        balises = new ArrayList<Balise>();

        //Remplissage de la liste des aéroports
        aeroports.add(new Aeroport("Paris", "ORY"));
        aeroports.add(new Aeroport("Lille", "LIL"));
        aeroports.add(new Aeroport("Bordeaux", "BOD"));
        aeroports.add(new Aeroport("Lyon", "LYS"));
        aeroports.add(new Aeroport("Nice", "NCE"));

        //Remplissage de la liste des balises
        balises.add(new Balise("LIL-ORY-01"));
        balises.add(new Balise("LIL-ORY-02"));

        balises.add(new Balise("LIL-BOD-01"));
        balises.add(new Balise("LIL-BOD-02"));
        balises.add(new Balise("LIL-BOD-03"));
        balises.add(new Balise("LIL-BOD-04"));
        balises.add(new Balise("LIL-BOD-05"));
        balises.add(new Balise("LIL-BOD-06"));

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

        //Remplissage de la liste des avions
        avions.add(new Avion("AF 101"));
        avions.add(new Avion("AF 202"));
        avions.add(new Avion("AF 103"));
        avions.add(new Avion("AF 880"));
        avions.add(new Avion("FR 325"));
        avions.add(new Avion("FR 001"));
        avions.add(new Avion("FR 999"));
        avions.add(new Avion("FR 020"));
        avions.add(new Avion("FR 330"));
        
       // Aeroport.initiateListDestination();
        
    }

    public void run() {
        long lastTime, currentTime;
        isRunning = true;
        Random rand = new Random();

        while (isRunning) {
            lastTime = System.currentTimeMillis();

            // Logic //////////////////////////////////////////////////////////////

            // Cree un aleas aleatoire sur une balise, ou pas
//            if (rand.nextInt(1) == 1) {
//                int aleasIndex = rand.nextInt(Balise.Aleas.values().length - 1);
//                int aleasDuree = rand.nextInt(4 - 2) + 1;
//                int baliseIndex = rand.nextInt(balises.size() + 1);
//
//                if (balises.get(baliseIndex).getAlea() == Balise.Aleas.RAS)
//                    balises.get(baliseIndex).changeAleas(aleasIndex, aleasDuree);
//            }

            // Bouge avions
            

            // Traitement aeroports

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
}
