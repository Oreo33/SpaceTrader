/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders1dot0.model;
import java.util.HashSet;

/**
 *
 * @author song
 */
public class SolarSystem {
     private int x_axis;
     private int y_axis;
     private String ssName;
     private final int PLANETNUMBER;
     private final Planet[] thePlanet;
     
         /**
     * Creates a new solar system based off solar system name, how many planets, and its coordinates (x,y)
     * @param SSN the name of the solar system
     * @param planetNumber is how many planets the solar system will have
     * @param x is the x coord of solar system on the game screen
     * @param y is the y coord of solar system on the game screen
     */
     public SolarSystem(String SSN, int planetNumber, int x, int y)
     {
          x_axis = x;
          y_axis = y;
          ssName = SSN;
          PLANETNUMBER = planetNumber;
          thePlanet = new Planet[PLANETNUMBER];          
     }
         /**
     * Creates the planets for the associated solar system
     * each planet will have a random tech level
     * each planet will have a random special resource
     * @param name is the names of the planets, each planet will have a distinct name
     */
     public void createPlanet(String [] name)
     {
          int x, y, techLevel, specialResource, increaseEvent;
          HashSet theSet = new HashSet();
          for (int i = 0; i < PLANETNUMBER; ++i)
          {                                                 //the random might be temporary, b/c with image, size will be different
               x = (int) (Math.random() * 300 +50);         //planet x_axis in the solar system
               y = (int) (Math.random() * 300 + 50);        //planet y_axis in the solar system
                while(theSet.contains(x))                   //if the location has been taken, regenerate planet location
               {                                            
                    x = (int) (Math.random() * 300 +50);         
                    y = (int) (Math.random() * 300 + 50);
               }
               theSet.add(x);
               techLevel = (int)(Math.random() * 7); //8                 //planet tech level, which will determine the government type later in the planet
               specialResource = (int)(Math.random() * 11); //13     //planet special resource, which will affect trading
               increaseEvent = (int)(Math.random() * 8);
               /*create planets with x,y coordinate, technology level, special resource and distinct name*/
               thePlanet[i] = new Planet(x, y, techLevel, specialResource, increaseEvent, name[i]);
               
          }
     }
         /**
     * Displays information about all the planets within this solar system
     */
     public void displaySolarSystem()
     {
          System.out.println("solar system: " + ssName + "(" + x_axis + ", " + y_axis + ")" + " :   ");
          for (int i = 0; i < PLANETNUMBER; ++i)
          {
               System.out.println(thePlanet[i].toString());
          }
          System.out.println("");
     }
         /**
     * Gets the x coordinate of the solar system
     * @return current solar system x_axis value
     */
     public int getX_axis()
     {
          return x_axis;
     }
              /**
     * Gets the y coordinate of the solar system
     * @return current solar system y_axis value
     */
     public int getY_axix()
     {
          return y_axis;
     }
              /**
     * Gets the name of the solar system
     * @return current solar system name, so you will know which system you are in
     */
     public String getSolarSystemName()
     {
          return ssName;
     }
              /**
     * Gets the number of planets
     * @return the number of planets in this planets
     */
     public int getPlanetNumber()
     {
          return PLANETNUMBER;
     }
              /**
     * Gets the container holding all the planets in the solar system
     * @return returns the container holding all the planets
     */
     public Planet[] getPlanet()
     {
          return thePlanet;
     }
}
