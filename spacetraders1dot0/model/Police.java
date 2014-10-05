/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders1dot0.model;

/**
 *
 * @author Kentaro
 */
//todo, 
//accept surrender, take to court,otherwise fight
//when search ship, if firearms are found then immediate confiscate 
//same for narcotics
public class Police extends Player {

    private int threatRating; //looks at player notoriety
    private int bribeRating; //determined by government type
    private int wantedBribe;
    private Boolean life; //true if alive, false if dead

    /**
     * Blank police officer with a random position, name, and 0 threat or bribe
     */
    public Police() {
        name = posNames[(int) (Math.random() * ((posNames.length)))];
        threatRating = 0;
        bribeRating = 0;
        life = true;
    }

    /**
     * Creates a police officer based off threat, bribe and x y positions Random
     * name
     *
     * @param threatRating amount of threat the officer has
     * @param bribeRating the bribe factor for how much the police will take
     */
    public Police(int threatRating, int bribeRating) {
        name = posNames[(int) (Math.random() * ((posNames.length)))];
        this.threatRating = threatRating;
        this.bribeRating = bribeRating;
        life = true;
    }

    /**
     * Set the police threatrating * @param threat amount to set the threat too
     * @param threat sets the police threat amount
     */
    public void setThreatRating(int threat) {
        threatRating = threat;
    }

    /**
     * Returns the police threat
     * @return the threatrating associated with the police character
     */
    public int getThreatRating() {
        return threatRating;
    }

    /**
     * Set the bribe amount officer will take
     *
     * @param bribeRating sets the bribeRating for the police to this value
     */
    public void setBribeRating(int bribeRating) {
        this.bribeRating = bribeRating;
    }

    /**
     * Return the bribe rating
     * @return the bribe rating associated with this police character
     */
    public int getBribeRating() {
        return bribeRating;
    }

    /**
     * Shows if dead or alive
     * @return returns whether alive or dead for police character
     */
    public String getLife() {
        if (life) {
            return "alive";
        } else {
            return "dead";
        }
    }

    /**
     * Set if dead or alive
     *
     * @param t true or false of whether want dead or alive.
     */
    public void setLife(Boolean t) {
        life = t;
    }

    /**
     * Police will search the ship if threatRating is high and or your notoriety
     * is high
     *
     * @param notoriety based off this determines if the ship will get searched
     */
    public Boolean searchSpaceShip(int notoriety) {
        //bs figures but gives the basic idea
        if (notoriety > 50) {  //pulls you over for bad police record
            return true;
        } else if ((notoriety + threatRating) >= 50) {
            return true; //pulls you over for this accumulation
        } else if (threatRating > 75) {
            return true;    //angry cop, will pull over anything
        } else {
            return false; //wont get pulled over
        }
    }

    /**
     * Based off of bribe rating and returns how much the police officer will
     * take as a bribe
     * @return the wanted bribe the police requires for success
     */
    public int getWantedBribe() {
        wantedBribe = (100 - bribeRating) * 100; //lower briberating will take more money
        return wantedBribe;
    }

    /**
     * if the police officer will accept the bribe or not
     *
     * @param bribeAmount the amount you give to officer and if he likes the
     * amount will accept the bribe
     * @return true or false if the officer accepted the bribeAmount
     */
    public Boolean acceptBribe(int bribeAmount) {
        if (bribeAmount >= wantedBribe) {
            return true;
        } else if (bribeRating == 0) {
            return false; //incorruptable
        } else {
            return false; //didn't give him enough bribe money
        }
    }

    /**
     * Prints individual police information
     */
    @Override
    public String toString() {
        return "\tPolice name: " + name + " threat:" + threatRating + " bribe: " + bribeRating + " Life status " + getLife();
    }

}
