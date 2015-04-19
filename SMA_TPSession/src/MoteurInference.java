import java.util.ArrayList;
import java.util.Random;

public class MoteurInference {
    private static Random rand = new Random();

    public static void prioriteArrivee() {

        for (Aeroport aeroport : Environnement.aeroports) {
            ArrayList<Avion> listeOrdonnee = new ArrayList<>();
            if (!aeroport.getEnAttenteAtterissage().isEmpty()) {
                if (aeroport.getEnAttenteAtterissage().size() > 1) {
                    //Priorite 1:Avarie
                    for (Avion avion : aeroport.getEnAttenteAtterissage()) {
                        if (avion.getEtat() == Avion.Etat.AVARIE) {
                            listeOrdonnee.add(avion);
                            aeroport.getEnAttenteAtterissage().remove(avion);
                        }
                    }
                    trieParCarburant(listeOrdonnee);

                    //Priorite 2: niveau de carburant
                    for (Avion avion : trieParCarburant(aeroport.getEnAttenteAtterissage())) {
                        listeOrdonnee.add(avion);
                    }

                    //Attribution de la nouvelle liste a la liste d'avion en attente a l'atterissage
                    aeroport.setEnAttenteAtterissage(listeOrdonnee);
                }
            }
        }
    }

    private static ArrayList<Avion> trieParCarburant(ArrayList<Avion> avions) {
        ArrayList<Avion> listeOrdonnee = new ArrayList<>();
        while (!avions.isEmpty()) {
            int carburantMini = 99;
            Avion avionCarbuMini = new Avion("");

            for (Avion avion : avions) {
                if (avion.getCarburant() < carburantMini) {
                    carburantMini = avion.getCarburant();
                    avionCarbuMini = avion;
                }
            }

            listeOrdonnee.add(avionCarbuMini);
            avions.remove(avionCarbuMini);
        }
        return listeOrdonnee;
    }

    public static void gestionAleasAvion(Avion avion, Balise.Aleas alea) {
        System.out.println("Alea sur la balise " + avion.getScenario().getBaliseActuelle().getNom() + ". Type: " + alea.toString());
        switch (alea) {
            case ORAGE:
                if(avion.getScenario().getBalisesPassees().size() <= avion.getCarburant())
                    avion.demiTour();
                else if (rand.nextInt(1) == 1) {// Touche par l'orage
                    avion.setEtat(Avion.Etat.AVARIE);
                    System.out.println("L'avion est touche par l'orage");
                }
                break;
            case CRASH:
                System.out.println("L'avion [" + avion.getNomAgent() + "] " + avion.getScenario().getDepart() + "-" + avion.getScenario().getArrivee() + " s'est ecrase :(");
                Environnement.aeroports.get(rand.nextInt(Environnement.aeroports.size())).getEnAttenteAtterissage().add(avion);
                break;
            case TURBULENCES:
                System.out.println("L'avion ["+ avion.getNomAgent() +"] "+ avion.getScenario().getDepart() +"-"+ avion.getScenario().getArrivee() +" est dans une zone de turbulences");
                avion.diminueCarburant(1);
                break;
            case ATTERISSAGEFORCE:
                System.out.println("L'avion ["+ avion.getNomAgent() +"] "+ avion.getScenario().getDepart() +"-"+ avion.getScenario().getArrivee() +" a une avarie et doit atterrir vite!");
                avion.setEtat(Avion.Etat.AVARIE);
                break;
            default:
                break;
        }
    }
}
