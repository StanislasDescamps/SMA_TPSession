import java.util.ArrayList;
import java.util.Random;

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

    //Choisit aleatoirement une nouvelle destination
    public static String nextDestination(String nomAeroport) {
        Random rand = new Random();

        String nextAeroport = nomAeroport;
        while (nextAeroport.equals(nomAeroport)) {
            nextAeroport = Environnement.aeroports.get(rand.nextInt(4)).getIATACode();
        }
        return nextAeroport;
    }

    public String getIATACode() {
        return IATACode;
    }

    public ArrayList<Avion> getEnAttenteAtterissage() {
        return enAttenteAtterissage;
    }

    public void setEnAttenteAtterissage(ArrayList<Avion> enAttenteAtterissage) {
        this.enAttenteAtterissage = enAttenteAtterissage;
    }

    public ArrayList<Avion> getEnAttenteDecollage() {
        return enAttenteDecollage;
    }
}
