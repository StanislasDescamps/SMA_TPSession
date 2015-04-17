/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Balise {
    private enum Aleas {RAS, ORAGE, CRASH, TURBULENCES, ATTERISSAGEFORCE}

    private String nom;
    private Aleas alea;
    
    public Balise(String nomBalise, Aleas statut){
    	this.nom=nomBalise;
    	this.alea=statut;
    }
}
