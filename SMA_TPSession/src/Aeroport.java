import java.util.ArrayList;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Aeroport extends Agent {
    private String           IATACode;
    private ArrayList<Avion> enAttenteAtterissage;
    private ArrayList<Avion> enAttenteDecollage;

    public Aeroport(String nomAgent, String idAero) {
        super(nomAgent);
        this.IATACode = idAero;
        this.enAttenteAtterissage = new ArrayList<>();
        this.enAttenteDecollage = new ArrayList<>();

    }
}
