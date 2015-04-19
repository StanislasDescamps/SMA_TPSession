import java.util.ArrayList;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
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
							//A la fin de la boucle l'avion avec le carburant le plus faible est ajouter à la nouvelle liste puis supprimer de la liste des attentes atterissage
							nouvelleListe.add(tampon);
							aero.getEnAttenteAtterissage().remove(tampon);
						}	
						
					}
					//Attribution de la nouvelle liste a la liste d'avion en attente a l'atterissage
					aero.setEnAttenteAtterissage(nouvelleListe);	
				}
				//Le premier atteri pret à decoller
				aero.getEnAttenteDecollage().add(aero.getEnAttenteAtterissage().get(0));
				
				//Suppression de ce meme avion de la liste des atterissages
				aero.getEnAttenteAtterissage().remove(aero.getEnAttenteAtterissage().get(0));
				
				//Choix du nouvel itinéraire pour l'avion
				Avion avionAuDepart=aero.getEnAttenteAtterissage().get(0);
				String nextDestination=Aeroport.nextDestination(aero.getNomAgent());
				avionAuDepart.setScenario(new Scenario(aero.getNomAgent(),nextDestination));
				
				System.out.println(avionAuDepart.getNomAgent()+" est bien arrivé à "+aero.getNomAgent()+". Il repartira bientot pour "+ nextDestination);
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
			// hypothèse : l'arraylist est trié
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				if (list.get(i).getCarburant() > list.get(i+1).getCarburant()) {
					// s'ils ne le sont pas, on échange leurs positions
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
