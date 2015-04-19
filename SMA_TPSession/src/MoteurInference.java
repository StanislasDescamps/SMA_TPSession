import java.util.Random;

public class MoteurInference {
    private static Random rand = new Random();

    public MoteurInference() {
    }

    public static void gestionAleasAvion(Avion avion, Balise.Aleas alea) {
        switch (alea) {
            case ORAGE:
                if(avion.getScenario().getBalisesPassees().size() <= avion.getCarburant())
                    avion.demiTour();
                else if (rand.nextInt(1) == 1) // Touche par l'orage
                    avion.setEtat(Avion.Etat.AVARIE);
                break;
            case CRASH:
                Environnement.avions.remove(avion);
                Environnement.avions.add(new Avion(avion.getNomAgent()));
                break;
            case TURBULENCES:
                avion.diminueCarburant(1);
                break;
            case ATTERISSAGEFORCE:
                avion.setEtat(Avion.Etat.AVARIE);
                break;
            default:
                break;
        }
    }
}
