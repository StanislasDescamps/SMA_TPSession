import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */

public class Scenario {

    private String            depart;
    private String            arrivee;
    private ArrayList<Balise> prochainesBalises;
    private ArrayList<Balise> balisesPassees;
    private Balise            baliseActuelle;

    public Scenario(String depart, String arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.prochainesBalises = new ArrayList<>();
        this.balisesPassees = new ArrayList<>();
        this.baliseActuelle = new Balise(depart);

        for (Balise b : Environnement.balises)
            if (b.getNom().contains(depart) && b.getNom().contains(arrivee)) {
                prochainesBalises.add(b);
            }

        if (prochainesBalises.get(0).getNom().split("-")[0].equals(arrivee)) {
            inverserListeBalises();
        }
    }

    public boolean nouvelleBalise(String avion) {
        if (!prochainesBalises.isEmpty()) {
            System.out.println(avion+" : Changement de position de "+ baliseActuelle.getNom() +" a "+ prochainesBalises.get(0).getNom());
            if (baliseActuelle.getNom().matches("[A-Z]{3}-[A-Z]{3}-\\d{2}"))
                balisesPassees.add(baliseActuelle);

            baliseActuelle = prochainesBalises.get(0);

            return true;
        } else
            return false;
    }

    public Balise getBaliseActuelle() {
        return prochainesBalises.get(0);
    }

    private void inverserListeBalises() {
        Collections.reverse(prochainesBalises);
    }

    public void demiTour() {
        prochainesBalises = new ArrayList<>(balisesPassees);
        inverserListeBalises();
        balisesPassees = new ArrayList<>();
    }

    public ArrayList<Balise> getProchainesBalises() {
        return prochainesBalises;
    }

    public ArrayList<Balise> getBalisesPassees() {
        return balisesPassees;
    }

    public String getDepart() {
        return depart;
    }

    public String getArrivee() {
        return arrivee;
    }
}

