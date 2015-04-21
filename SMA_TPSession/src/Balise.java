import java.util.ArrayList;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Balise {
    public enum Aleas {RAS, ORAGE, CRASH, TURBULENCES, ATTERISSAGEFORCE}

    private String           nom;
    private Aleas            alea;
    private int              duree;

    public Balise(String nom) {
        this.nom = nom;
        this.alea = Aleas.RAS;
        this.duree = 0;
    }

    public void changeAlea(int indexAlea, int duree) {
        this.alea = Aleas.values()[indexAlea];
        this.duree = duree;
    }

    public Aleas getAlea() {
        return alea;
    }

    public void setAlea(Aleas alea) {
        this.alea = alea;
    }

    public int getDureeAlea() {
        return duree;
    }

    public void diminueDureeAlea() {
        this.duree -= 1;
    }

    public String getNom() {
        return nom;
    }
}
