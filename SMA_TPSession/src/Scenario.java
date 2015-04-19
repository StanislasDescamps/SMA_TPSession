import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */

public class Scenario {
    private String            depart;
    private String            arrivee;
    private ArrayList<Balise> balises;
    private ArrayList<Balise> balisesPassees;

    public Scenario(String depart, String arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
        balises = new ArrayList<>();

        for (Balise b : Environnement.balises)
            if (b.getNom().contains(depart) && b.getNom().contains(arrivee)) {
                balises.add(b);
            }

        if (balises.get(0).getNom().split("-")[0].equals(arrivee)) {
            inverserListeBalises();
        }
    }

    public void nouvelleBalise() {
        balisesPassees.add(balises.get(0));
        balises.remove(0);
    }

    public Balise getBaliseActuelle() {
        return balises.get(0);
    }

    private void inverserListeBalises() {
        Collections.reverse(balises);
    }

    public void demiTour() {
        balises = new ArrayList<>(balisesPassees);
        inverserListeBalises();
        balisesPassees = new ArrayList<>();
    }

    public ArrayList<Balise> getBalises() {
        return balises;
    }

    public ArrayList<Balise> getBalisesPassees() {
        return balisesPassees;
    }
}

