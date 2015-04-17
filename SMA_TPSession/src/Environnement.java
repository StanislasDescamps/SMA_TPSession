import java.util.ArrayList;

/**
 * Created by Florian Sainjeon on 17/04/2015.
 */
public class Environnement {
    private ArrayList<Aeroport> aeroports;
    private ArrayList<Avion> avions;
    private ArrayList<Balise> balises;

    public Environnement(){
    	
    	//Création des listes
    	aeroports = new ArrayList<Aeroport>();
    	avions = new ArrayList<Avion>();
    	balises = new ArrayList<Balise>();
    	
    	//Remplissage de la liste des aéroports
    	aeroports.add(new Aeroport("Paris","ORY",null));
    	aeroports.add(new Aeroport("Lille","LIL",null));
    	aeroports.add(new Aeroport("Bordeaux","BOD",null));
    	aeroports.add(new Aeroport("Lyon","LYS",null));
    	aeroports.add(new Aeroport("Nice","NCE",null));    	
    	
    	//Remplissage de la liste des balises
    	balises.add(new Balise("LIL-ORY-01"));
    	balises.add(new Balise("LIL-ORY-02"));
    	
    	balises.add(new Balise("LIL-BOD-01"));
    	balises.add(new Balise("LIL-BOD-02"));
    	balises.add(new Balise("LIL-BOD-03"));
    	balises.add(new Balise("LIL-BOD-04"));
    	balises.add(new Balise("LIL-BOD-05"));
    	balises.add(new Balise("LIL-BOD-06"));
    	
    	balises.add(new Balise("LIL-LYS-01"));
    	balises.add(new Balise("LIL-LYS-02"));
    	balises.add(new Balise("LIL-LYS-03"));
    	balises.add(new Balise("LIL-LYS-04"));
    	balises.add(new Balise("LIL-LYS-05"));
    	
    	balises.add(new Balise("LYS-NCE-01"));
    	balises.add(new Balise("LYS-NCE-02"));
    	balises.add(new Balise("LYS-NCE-03"));
    	balises.add(new Balise("LYS-NCE-04"));
    	
    	balises.add(new Balise("ORY-NCE-01"));
    	balises.add(new Balise("ORY-NCE-02"));
    	balises.add(new Balise("ORY-NCE-03"));
    	balises.add(new Balise("ORY-NCE-04"));
    	balises.add(new Balise("ORY-NCE-05"));
    	
    	balises.add(new Balise("ORY-LYS-01"));
    	balises.add(new Balise("ORY-LYS-02"));
    	balises.add(new Balise("ORY-LYS-03"));
    	
    	balises.add(new Balise("ORY-BOD-01"));
    	balises.add(new Balise("ORY-BOD-02"));
    	balises.add(new Balise("ORY-BOD-03"));
    	balises.add(new Balise("ORY-BOD-04"));
    	
    	balises.add(new Balise("BOD-NCE-01"));
    	balises.add(new Balise("BOD-NCE-02"));
    	balises.add(new Balise("BOD-NCE-03"));
    	balises.add(new Balise("BOD-NCE-04"));
    	balises.add(new Balise("BOD-NCE-05"));
    	
    	balises.add(new Balise("BOD-LYS-01"));
    	balises.add(new Balise("BOD-LYS-02"));
    	balises.add(new Balise("BOD-LYS-03"));
    	balises.add(new Balise("BOD-LYS-04"));
    	balises.add(new Balise("BOD-LYS-05"));
    	balises.add(new Balise("BOD-LYS-06"));
    	balises.add(new Balise("BOD-LYS-07"));
    	
    	//Remplissage de la liste des avions
    	avions.add(new Avion("AF 101"));
    	avions.add(new Avion("AF 202"));
    	avions.add(new Avion("AF 103"));
    	avions.add(new Avion("AF 880"));
    	avions.add(new Avion("FR 325"));
    	avions.add(new Avion("FR 001"));
    	avions.add(new Avion("FR 999"));
    	avions.add(new Avion("FR 020"));
    	avions.add(new Avion("FR 330"));
    }
}
