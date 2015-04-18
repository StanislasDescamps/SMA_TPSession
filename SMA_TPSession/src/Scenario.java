import java.util.ArrayList;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */

public class Scenario {
    private String            depart;
    private String            arrivee;
    private ArrayList<Balise> balises;

    public Scenario(String depart, String arrivee) {
        balises = new ArrayList<>();

        for (Balise b : Environnement.balises)
            if (b.getNom().contains(depart) && b.getNom().contains(arrivee))
                balises.add(b);
    }
}

