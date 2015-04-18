import java.util.ArrayList;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Balise {
    public enum Aleas {RAS, ORAGE, CRASH, TURBULENCES, ATTERISSAGEFORCE}

    private String nom;
    private Aleas  alea;
    private int    duree;
    private ArrayList<Avion> listAvionPresent;

    public Balise(String nom) {
        this.nom = nom;
        this.alea = Aleas.RAS;
        this.duree = 0;
        this.listAvionPresent=new ArrayList<>();
    }

    public Balise(String nom, Aleas statut, int duree, ArrayList<Avion> avionPresents) {
        this.nom = nom;
        this.alea = statut;
        this.duree = duree;
        this.listAvionPresent=avionPresents;
    }

    public void changeAleas (int indexAleas, int duree) {
        this.alea = Aleas.values()[indexAleas];
        this.duree = duree;

    }

    public Aleas getAlea() {
        return alea;
    }

    public String getNom() {
        return nom;
    }
}
