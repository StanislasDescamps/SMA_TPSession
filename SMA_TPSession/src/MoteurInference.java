import java.util.ArrayList;
import java.util.Random;

public class MoteurInference {
	private static Random rand = new Random();

	public static void Priorite() {

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
	
}
