/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders1dot0.model;

/**
 *
 * @author song
 */
public class Planet {

    private final int xCoordinate;
    private final int yCoordinate;
    private final int techLevel;
    private final int specialResource;
    private int increaseEvent;
    private final String planetName;
    private Police[] planetPolice;
    private Government theGovernment;
    private Pirate[] planetPirate;
    /**
     * Creates a planet based off specifications of (x,y), tech level, special resource,
     * increase event and name
     * @param x the x coord position
     * @param y the y coord positon
     * @param t the techlevel amount
     * @param s the special resource value
     * @param ie increase event
     * @param n the name of the planet
     */
    public Planet(int x, int y, int t, int s, int ie, String n) {
        xCoordinate = x;
        yCoordinate = y;
        techLevel = t;
        specialResource = s;
        increaseEvent = ie;
        planetName = n;
//        planetPolice = new Police[t]; //i guess depending on tech level determines police
        this.createGovernment();
        this.createPlanetPolice();
        this.createPlanetPirate();
    }
    /**
     * Get the planet x coordinate
     * @retun the planets x coord
     */
    public int getXCoordinate() {
        return xCoordinate;
    }
    /**
     * Get the planet y coordinate
     * @return the planets y coord
     */
    public int getYCoordinate() {
        return yCoordinate;
    }
    /**
     *Gets the tech level associated with the planet
     * @return tech level for the planet
     */
    public int getTechLevel() {
        return techLevel;
    }

    /**
     *Gets the special resource associated with the planet
     * @return special resource for the planet
     */
    public int getSpecialResource() {
        return specialResource;
    }

    /**
     * Sets the special resource associated with the planet
     * @param int increaseEvent
     */
    public void setIncreaseEvent(int ie) {
        increaseEvent = ie;
    }

    /**
     *Gets the increase event associated with the planet
     * @return increase event for the planet
     */
    public int getIncreaseEvent() {
        return increaseEvent;
    }
    /**
     * Get the planet name
     * @return the planet name
     */
    public String getName() {
        return planetName;
    }

    /**
     *Gets the government associated with the planet
     * @return government for the planet
     */
    public Government getGovernment() {
        return theGovernment;
    }

    /**
     * Creates a government based off current planet's tech level
     */
    public Government createGovernment() {
        theGovernment = new Government();
        theGovernment.createGovernment(this.techLevel);
        return theGovernment;
    }

    /**
     * Creates the pirates for the planet based on the planets current crime
     * rate
     */
    public void createPlanetPirate() {
        int amountOfPirate = theGovernment.currentPS.getCrimeRate();
        planetPirate = new Pirate[amountOfPirate];
        for (int i = 0; i < planetPirate.length; i++) {
            planetPirate[i] = new Pirate(amountOfPirate);
        }
    }

    /**
     * Returns the container that holds the pirates on the planet
     *
     * @return returns the structure array holding all pirates for the planet
     */
    public Pirate[] getPirate() {
        return planetPirate;
    }

    /**
     * gets all the pirate information
     *
     * @return the pirates associated with the planets information
     */
    public String planetPirateInfo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < planetPirate.length; i++) {
            sb.append(planetPirate[i].toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * Creates the planet police for the planet based off planet government and police force
     */
    public void createPlanetPolice() {
        int amountOfPolice = theGovernment.getPoliceForce();
        planetPolice = new Police[amountOfPolice];
        for (int i = 0; i < planetPolice.length; i++) {
            planetPolice[i] = new Police(techLevel, specialResource);
        }
    }

    /**
     * returns structure holding all police
     *
     * @return returns the structure array containing all police for the planet
     */
    public Police[] getPolice() {
        return planetPolice;
    }

    /**
     * compiles each police information to output string
     *
     * @return the police associated with the planet is returned
     */
    public String planetPoliceInfo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < planetPolice.length; i++) {
            sb.append(planetPolice[i].toString() + "\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Planet name: " + planetName + " Coordinate: (" + xCoordinate + ", " + yCoordinate + ")" + "   TechLevel: "
                + techLevel(techLevel) + "  specialResource: " + specialResource(specialResource) + "\n "
                + theGovernment.toString() + "\n" + planetPoliceInfo() + "\n" + planetPirateInfo();
    }
    /**
     * Gets the special resource name based off the value given from government
     * @param s the value indicating what this special resource refers to
     * @return the string value of the special resource
     */
    private String specialResource(int s) {
        switch (s) {
            case 0:
                return "NO-SPECIAL-RESOURCES";
            case 1:
                return "MINERAL-RICH";
            case 2:
                return "MINERAL-POOR";
            case 3:
                return "DESERT";
            case 4:
                return "LOTS-OF-WATER";
            case 5:
                return "RICH-SOIL";
            case 6:
                return "RICH-FAUNA";
            case 7:
                return "LIFE-LESS";
            case 8:
                return "WEIRD-MUSHROOMS";
            case 9:
                return "LOTS-OF-HERBS";
            case 10:
                return "ARTISTIC";
            default:
                return "WARLIKE";
        }
    }
    /**
     * Gets the tech level string from the governments given tech value int
     * @param t the int value that associates what tech level it is
     * @return the string associated with the tech level.
     */
    private String techLevel(int t) {
        switch (t) {
            case 0:
                return "Pre-Agriculture";
            case 1:
                return "Agriculture";
            case 2:
                return "Medieval";
            case 3:
                return "Renaissance";
            case 4:
                return "Early-Industrial";
            case 5:
                return "Industrial";
            case 6:
                return "Post-Industrial";
            default:
                return "Hi-Tech";
        }
    }
}
