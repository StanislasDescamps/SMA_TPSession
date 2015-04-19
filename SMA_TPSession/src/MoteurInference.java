import java.util.ArrayList;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class MoteurInference {

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

    /*
    public static ArrayList<Avion> triAvionParCarbuantCroissant(ArrayList<Avion> list) {
		int longueur = list.size();
		Avion tampon;
		boolean permut;
		ArrayList<Avion> nouvelleListe = new ArrayList<>();
 
		do {
			// hypoth�se : l'arraylist est tri�
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				// Teste si 2 �l�ments successifs sont dans le bon ordre ou non
				if (list.get(i).getCarburant() > list.get(i+1).getCarburant()) {
					// s'ils ne le sont pas, on �change leurs positions
					tampon = list.get(i);
					list.remove(list.get(i));
					list.add(tampon);
					permut = true;
				}
			}
		} while (permut);
		return nouvelleListe;
	}*/

}
