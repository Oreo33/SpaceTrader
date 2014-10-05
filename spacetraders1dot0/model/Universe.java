/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders1dot0.model;

// import javafx.fxml.FXML;

import java.util.Vector;

// import javafx.scene.image.ImageView;

/**
 *
 * @author song
 */
 
 /* PlanetNames class is created for storing all the planet names only*/
 /*funtion as structure*/
class PlanetNames {

    private String pName;
    private boolean isTaken;

    /**
     * planetname is not taken yet by default
     */
    public PlanetNames() {
        pName = "";
        isTaken = false;
    }

    /**
     * Set the planetname
     */
    public void setPName(String n) {
        pName = n;
    }
/**
     * Get the planetname
     * @return the planename is returned
     */
    public String getPName() {
        return pName;
    }
/**
     * 
     * when a name is chosen, set the name as been taken already, then will be nomore assignment for that name
     */
    public void setIsTaken(boolean b) {
        isTaken = b;
    }
/**
     * return boolean of whether the name has been taken or not
     */
    public boolean getIsTaken() {
        return isTaken;
    }
}

public class Universe {
    private int planetsPerSystem;           //number of planets in a solar system, not a constant

    private final SolarSystem[] theSystem;  //10 systems
    private final PlanetNames[] theName;    //numbers of names as listed below {name}
    
     private final int NUMBEROFSYSTEM;       //total of 10 solar system
     private final int DIMENSION = 2;             //we are doing a 2-d universe
     private final int[][] ssCoordinate;   //solar system coordinate, x_axis & y_axis
     
    private final String[] name = {
        "Acamar",
        "Adahn", // The alternate personality for The Nameless One in "Planescape: Torment"
        "Aldea",
        "Andevian",
        "Antedi",
        "Balosnee",
        "Baratas",
        "Brax", // One of the heroes in Master of Magic
        "Bretel", // This is a Dutch device for keeping your pants up.
        "Calondia",
        "Campor",
        "Capelle", // The city I lived in while programming this game
        "Carzon",
        "Castor", // A Greek demi-god
        "Cestus",
        "Cheron",
        "Courteney", // After Courteney Cox…
        "Daled",
        "Damast",
        "Davlos",
        "Deneb",
        "Deneva",
        "Devidia",
        "Draylon",
        "Drema",
        "Endor",
        "Esmee", // One of the witches in Pratchett's Discworld
        "Exo",
        "Ferris", // Iron
        "Festen", // A great Scandinavian movie
        "Fourmi", // An ant, in French
        "Frolix", // A solar system in one of Philip K. Dick's novels
        "Gemulon",
        "Guinifer", // One way of writing the name of king Arthur's wife
        "Hades", // The underworld
        "Hamlet", // From Shakespeare
        "Helena", // Of Troy
        "Hulst", // A Dutch plant
        "Iodine", // An element
        "Iralius",
        "Janus", // A seldom encountered Dutch boy's name
        "Japori",
        "Jarada",
        "Jason", // A Greek hero
        "Kaylon",
        "Khefka",
        "Kira", // My dog's name
        "Klaatu", // From a classic SF movie
        "Klaestron",
        "Korma", // An Indian sauce
        "Kravat", // Interesting spelling of the French word for "tie"
        "Krios",
        "Laertes", // A king in a Greek tragedy
        "Largo",
        "Lave", // The starting system in Elite
        "Ligon",
        "Lowry", // The name of the "hero" in Terry Gilliam's "Brazil"
        "Magrat", // The second of the witches in Pratchett's Discworld
        "Malcoria",
        "Melina",
        "Mentar", // The Psilon home system in Master of Orion
        "Merik",
        "Mintaka",
        "Montor", // A city in Ultima III and Ultima VII part 2
        "Mordan",
        "Myrthe", // The name of my daughter
        "Nelvana",
        "Nix", // An interesting spelling of a word meaning "nothing" in Dutch
        "Nyle", // An interesting spelling of the great river
        "Odet",
        "Og", // The last of the witches in Pratchett's Discworld
        "Omega", // The end of it all
        "Omphalos", // Greek for navel
        "Orias",
        "Othello", // From Shakespeare
        "Parade", // This word means the same in Dutch and in English
        "Penthara",
        "Picard", // The enigmatic captain from ST:TNG
        "Pollux", // Brother of Castor
        "Quator",
        "Rakhar",
        "Ran", // A film by Akira Kurosawa
        "Regulas",
        "Relva",
        "Rhymus",
        "Rochani",
        "Rubicum", // The river Ceasar crossed to get into Rome
        "Rutia",
        "Sarpeidon",
        "Sefalla",
        "Seltrice",
        "Sigma",
        "Sol", // That's our own solar system
        "Somari",
        "Stakoron",
        "Styris",
        "Talani",
        "Tamus",
        "Tantalos", // A king from a Greek tragedy
        "Tanuga",
        "Tarchannen",
        "Terosa",
        "Thera", // A seldom encountered Dutch girl's name
        "Titan", // The largest moon of Jupiter
        "Torin", // A hero from Master of Magic
        "Triacus",
        "Turkana",
        "Tyrus",
        "Umberlee", // A god from AD&D, which has a prominent role in Baldur's Gate
        "Utopia", // The ultimate goal
        "Vadera",
        "Vagra",
        "Vandor",
        "Ventax",
        "Xenon",
        "Xerxes", // A Greek hero
        "Yew", // A city which is in almost all of the Ultima games
        "Yojimbo", // A film by Akira Kurosawa
        "Zalkon",
        "Zuul" // From the first Ghostbusters movie
    };
/**
     * Creates a universe with 10 solar systems
     * define number of names for planet name
     */
    public Universe() {
        NUMBEROFSYSTEM = 10;                    //create 10 solar system
        theName = new PlanetNames[name.length]; //store all the listed planet names into the planetname object
        theSystem = new SolarSystem[NUMBEROFSYSTEM];    
        ssCoordinate = new int[NUMBEROFSYSTEM][DIMENSION];
        for(int ii=0; ii < NUMBEROFSYSTEM; ii++){
            for(int jj=0;jj<2;jj++){
                if(jj==0){
                    ssCoordinate[ii][jj] = (int)(Math.random()*520 + 30);
                }
                else{
                    ssCoordinate[ii][jj] = (int)(Math.random()*330+30);
                }
            }        
        }
    }
/**
     * Create the universe with 10 solar systems
     * Creates 1 to 5 planets in each solar system with distinct name assigned 
     * @param ssCoordinate takes in the solar system coordinate, which is the layout based on the game screen
     */
    public void createUniverse(int[][] ssCoordinate) {
        String[] planetName;
        for (int j = 0; j < name.length; ++j) {         //store all the listed planet names into planetname object
            theName[j] = new PlanetNames();             //with default boolean noTaken for every name
            theName[j].setPName(name[j]);
        }

        for (int i = 0; i < NUMBEROFSYSTEM; ++i) {
            planetsPerSystem = (int) (Math.random() * 5 + 1);   //planets for each system varies, from 1 to 5
            planetName = new String[planetsPerSystem];         //planets' name buffer for each solar system, e.g. 3 planets will need 3 names
            String ssName = "SSN" + i;                        //name for each solar system, e.g. solar system 1 will be SSN1

            /*create solar system based on solar system name, number of planets in the system,
            the current solar system x, y coordinate in the universe
            */
            theSystem[i] = new SolarSystem(ssName, planetsPerSystem, ssCoordinate[i][0], ssCoordinate[i][1]);
            
            /*assign random planet names for each solar system
            all the planets in the solar systems will be different, each planet has its own distinct name
            */
            for (int k = 0; k < planetsPerSystem; ++k) 
            {
                int nameIndex = (int) (Math.random() * planetName.length);
                while (theName[nameIndex].getIsTaken()) {
                    nameIndex++;        //if the random generated name has been taken, search down until find one has not been chosen
                }
                theName[nameIndex].setIsTaken(true);        //set the chosen name as been taken, so will not be assigned to other planet again
                planetName[k] = theName[nameIndex].getPName();  //planets' name buffer for each system
            }
            theSystem[i].createPlanet(planetName);      //each solar system generates planet by using the distinct planet name
        }
    }
/**
     * Displays the universe
     * list detail structure for each solar system in the universe
     */
    public void displayUniverse() {
        for (int i = 0; i < NUMBEROFSYSTEM; ++i) {
            theSystem[i].displaySolarSystem();
        }
    }
    /**
     * For debugging:
     * Displays coordinates of solarsystem
     */
    public void displayCoordinate(){
                for(int ii=0; ii < NUMBEROFSYSTEM; ii++){
            for(int jj=0;jj<2;jj++){
                System.out.println(ssCoordinate[ii][jj]);
            }        
        }
    }
/**
     * Returns the solar system from the universe
     * @return the container holding the solarsystems
     */
    public SolarSystem[] getSolarSystem() {
        return theSystem;
    }
    
    public int [][] getSSCoordinates(){
        return ssCoordinate;
    }
}
