import java.util.Random;

public class MoteurInference {
	
	public static void Priorite(){
		
		for(Aeroport aero :Environnement.aeroports){
			ArrayList<Avion> nouvelleListe=new ArrayList<>();
			if(aero.getEnAttenteAtterissage().size()!=0){
				if(aero.getEnAttenteAtterissage().size()>1){
					while(aero.getEnAttenteAtterissage()!=null){
						
						//Priorite 1:Avarie
						for(Avion avion: aero.getEnAttenteAtterissage()){
							if(avion.getEtat()==Avion.Etat.AVARIE){
								nouvelleListe.add(avion);
								aero.getEnAttenteAtterissage().remove(avion);
							}	
						}
						//Priorite 2: niveau de carburant
						Avion tampon=aero.getEnAttenteAtterissage().get(0);
						while(aero.getEnAttenteAtterissage()!=null){
							for (Avion avion:aero.getEnAttenteAtterissage()) {
								// Teste si le niveau de carburant dans le tampon est bien le plus faible
								if (avion.getCarburant() < tampon.getCarburant()) {
									// si non on change le tampon pour qu'il devienne le plus faible et sois prioritaire
									tampon=avion;
								}
							}
							//A la fin de la boucle l'avion avec le carburant le plus faible est ajouter � la nouvelle liste puis supprimer de la liste des attentes atterissage
							nouvelleListe.add(tampon);
							aero.getEnAttenteAtterissage().remove(tampon);
						}	
						
					}
					//Attribution de la nouvelle liste a la liste d'avion en attente a l'atterissage
					aero.setEnAttenteAtterissage(nouvelleListe);	
				}
				//Le premier atteri pret � decoller
				aero.getEnAttenteDecollage().add(aero.getEnAttenteAtterissage().get(0));
				
				//Suppression de ce meme avion de la liste des atterissages
				aero.getEnAttenteAtterissage().remove(aero.getEnAttenteAtterissage().get(0));
				
				//Choix du nouvel itin�raire pour l'avion
				Avion avionAuDepart=aero.getEnAttenteAtterissage().get(0);
				String nextDestination=Aeroport.nextDestination(aero.getNomAgent());
				avionAuDepart.setScenario(new Scenario(aero.getNomAgent(),nextDestination));
				
				System.out.println(avionAuDepart.getNomAgent()+" est bien arriv� � "+aero.getNomAgent()+". Il repartira bientot pour "+ nextDestination);
			}
		}
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
