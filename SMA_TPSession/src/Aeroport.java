import java.util.ArrayList;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Aeroport extends Agent {
    private String IATACode;
    private ArrayList<Avion> enAttente;

    public Aeroport(String nomAgent, String idAero, ArrayList<Avion> attente) {
        super(nomAgent);
        this.IATACode = idAero;
        this.enAttente = attente;
    }
}
