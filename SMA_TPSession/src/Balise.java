/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Balise {
    private enum Aleas {RAS, ORAGE, CRASH, TURBULENCES, ATTERISSAGEFORCE}

    private String nom;
    private Aleas alea;

    public Balise(String nom) {
        this.nom = nom;
        this.alea = Aleas.RAS;
    }

    public Balise(String nom, Aleas statut) {
        this.nom = nom;
        this.alea = statut;
    }
}
