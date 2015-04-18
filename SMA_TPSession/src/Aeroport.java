import java.util.ArrayList;
import java.util.Random;

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
    
    //Choisit aleatoirement une nouvelle destination
    public String nextDestination(String nomAeroport){
    	Random rand=new Random();
    	
    	String nextAeroport=nomAeroport;	
    	while(nextAeroport.equals(nomAeroport)){
    		nextAeroport=Environnement.aeroports.get(rand.nextInt(4)).getNomAgent();
    	}
    	return nextAeroport;
    }
    
    public String getIATACode() {
		return IATACode;
	}

	public void setIATACode(String iATACode) {
		IATACode = iATACode;
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

	public void setEnAttenteDecollage(ArrayList<Avion> enAttenteDecollage) {
		this.enAttenteDecollage = enAttenteDecollage;
	}
}
