package spacetraders1dot0.model;

/**
 *
 * @author Kentaro
 */
/**
 *
 * @author Kentaro
 */
public class Pirate extends Player {

    protected int aggression;
   /**
     * Creates a blank pirate with random name, 15 skillpoints, aggression of 1
     */
    public Pirate() {
        name = posNames[(int) (Math.random() * ((posNames.length)))];
        totalSkillPoints = 15;
        aggression = 1;
        skills[1] = totalSkillPoints;
    }
   /**
     * Create pirate with random name based on aggression and user x y
     * @param aggression the pirates total aggression that is to be set
     */
    public Pirate(int aggression) {
        name = posNames[(int) (Math.random() * ((posNames.length)))];
        this.aggression = aggression;
    }
   /**
     * Set the pirate aggression (often based on government)
     * @param a the amount to set aggression by
     */
    public void setAggression(int a) {
        aggression = a;
    }
   /**
     * Get the pirates aggression
     * @return gets the total aggression of this pirate
     */
    public int getAggression() {
        return aggression;
    }
   /**
     * Prints the pirate information
     * @return return the individual pirates information
     */
    @Override
    public String toString() {
        return ("\t\tPirate name: " + name + " aggression: " + aggression + " currency: " + currency);
    }
}
