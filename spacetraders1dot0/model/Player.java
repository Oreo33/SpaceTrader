//playerSkillAllocation works as following
//playerSkillAllocation[0] == Pilot
//playerSkillAllocation[1] == Fighter
//playerSkillAllocation[2] == Trader
//playerSkillAllocation[3] == Engineer
//playerSkillAllocation[4] == Investor
//We can use these values as modifiers for later. 
//For instance a high point allocation under Fighter
//can be used as a damage modifier/multiplier in combat
//or High point in investor
//can be modifier for how lucky you are in getting money.
package spacetraders1dot0.model;

import sun.plugin.cache.OldCacheEntry;

/**
 *
 * @author Kentaro
 *
 */
public class Player {

    /**
     * Possible names
     */
    protected final String[] posNames = {"Ken", "Bro", "Song", "Ju-Hwan", "Ryan", "Justin", "Nub",
        "Bro1", "Bro2", "TeleTubby", "Ham", "Donut", "Chicken", "Bob", "Bobbro", "ChestBro"};
    /**
     * Player name
     */
    protected String name;
    /**
     * Player total skill points
     */
    protected int totalSkillPoints;
    /**
     * Player currency
     */
    protected double currency;
    /**
     * Player skill allocation
     */
    protected int[] skills;
    /**
     * Player notoriety
     */
    protected int notoriety; //for police
    /**
     * This is the max amount of currency you can have, ENFORCED
     */
    protected int maxCurrency = 1000000;
    /**
     * As with directions you can only have one ship at a time, want new ship?
     * sell old ship to ship master
     */
    public SpaceShip spaceShip;

    public Player() {
        name = "";
        totalSkillPoints = 15;
        currency = 1000;
        skills = new int[5];//Pilot, Fighter, Trader, Engineer, Investor
        notoriety = 0;
        spaceShip = new SpaceShip(ShipType.GNAT, skills);
    }

    /**
     * Creates Player to specifications
     *
     * @param name players name
     * @param totalSkill players totalSkillpoints
     * @param currency players start currency
     * @param skills players start skill
     * @param notoriety player notoriety
     */
    public Player(String name, int totalSkill, double currency, int[] skills, int notoriety, ShipType type) {
        this.name = name;
        totalSkillPoints = totalSkill;
        this.currency = currency;
        this.skills = skills;
        this.notoriety = notoriety;
        spaceShip = new SpaceShip(type, skills);

    }

    /**
     * Sets the new Ship with the skills of the player as modifiers, only one
     * ship per character..
     *
     * @param type the ship type, pass in as ENUM "ShipType.GNAT" as example
     */
    public void setSpaceShip(ShipType type) {
        spaceShip = new SpaceShip(type, skills);
    }

    /**
     * Set player notoriety level
     *
     * @param notoriety player notoriety amount
     */
    public void setNotoriety(int notoriety) {
        this.notoriety = notoriety;
    }

    /**
     * Get Player notoriety
     *
     * @return the notoriety of player
     *
     */
    public int getNotoriety() {
        return notoriety;
    }

    /**
     * sets the player name
     *
     * @param name the name to set as
     */
    public void setPlayerName(String name) {
        this.name = name;
    }

    /**
     * Get Player name
     *
     * @return the name of player
     */
    public String getPlayerName() {
        return name;
    }

    /**
     * Set players skill points
     *
     * @param skillPoints the amount of points to give player
     */
    public void setPlayerSkillPoints(int skillPoints) {
        totalSkillPoints = skillPoints;
    }

    /**
     * Get players skill points
     *
     * @return the totalSkillPoints associated with the player
     */
    public int getPlayerSkillPoints() {
        return totalSkillPoints;
    }

    /**
     * Set players money, enforced
     *
     * @param money the amount of money player should have
     */
    public void setPlayerCurrency(double money) {
        if (money >= maxCurrency) {
            currency = maxCurrency;
        } else {
            currency = money;
        }

    }

    /**
     * Set players money, enforced
     *
     * @param money adds money to player
     */
    public void updatePlayerCurrent(double money) {
        if (money + currency >= maxCurrency) {
            currency = maxCurrency;
        } else {
            currency += money;
        }

    }

    /**
     * Get players money
     *
     * @return the total currency of the player
     */
    public double getPlayerCurrency() {
        return currency;
    }

    /**
     * get the player skill allocation
     *
     * @return the player skill container
     */
    public int[] getPlayerSkillAllocation() {
        return skills;
    }

    /**
     * Set Players individual skill skill corresponds to which skill to update
     * (Pilot, Fighter, Trader, Engineer, Investor)
     *
     * @param amount the amount of skill to increase by
     * @param skill the position of skill to increase
     */
    public void allocatePlayerSkill(int amount, int skill) {
        skills[skill] = amount;
    }

    /**
     * Determined by which skill the player has, returns that job title
     *
     * @return the player job associated from skill points
     */
    public String getPlayerJob() {
        int max = 0;
        int maxPosition = 0;
        for (int i = 0; i < skills.length; i++) {
            if (skills[i] > max) {
                max = skills[i];
                maxPosition = i;
            }
        }
        if (maxPosition == 0) {
            return "Pilot";
        } else if (maxPosition == 1) {
            return "Fighter";
        } else if (maxPosition == 2) {
            return "Trader";
        } else if (maxPosition == 3) {
            return "Engineer";
        } else {
            return "Investor";
        }
    }

    /**
     * Resets the player by resetting all skills to normal level
     */
    public void playerReset() {
        name = "";
        totalSkillPoints = 15;
        currency = 1000;
        notoriety = 0;
        for (int i = 0; i < skills.length; i++) {
            skills[i] = 0;
        }
        spaceShip = new SpaceShip(ShipType.GNAT, skills);
    }
    public boolean buyItem(String item, int itemPrice)
    {
         if(spaceShip.buyCargo(item, itemPrice)){
              currency -= itemPrice;
              return true;
         }
         else
              return false;
    }
    public boolean sellItem(String item, int itemPrice)
    {
         if(spaceShip.sellCargo(item, itemPrice)){
              currency += itemPrice;
              return true;
         }
         else
              return false;
    }
    /**
     * Buys an item, adds to ship cargo if there is enough room and the player
     * has enough money, and updates money
     *
     * @param item the item being purchased
     * @return returns whether or not the purchase was successful
     */
/*    public boolean buyItem(String item, int price) {
        boolean success = false;
        if (item != null) {
            if (spaceShip.currentCargoHoldAmount < spaceShip.maxCargoHold
                    && currency >= price) {
                spaceShip.addItemToCargo(item);
                currency -= price;
                success = true;
            }
            /*for M5 demo
            spaceShip.printCargo();
            System.out.println(toString());
        }
        return success;
    }
*/
    public boolean canBuy(int price) {
        return currency >= price && !spaceShip.isCargoHoldFull();
    }

    /**
     * Sells item to marketplace, updates money, removes from cargo
     *
     * @param item the item to sell
     * @param price the price the item sells for
     * @return whether or not the sale was successful
     *
    public boolean sellItem(String item, int price) {
        boolean success = false;
        if (item != null && price > 0) {
            currency += price;
            spaceShip.removeItemFromCargo(item);
            success = true;
            spaceShip.printCargo();
            System.out.println(toString());

        }
        return success;
    }
*/
    /**
     * Print out the individual player information
     */
    @Override
    public String toString() {
        return name + "\nSkills: Pilot(" + skills[0] + ")|Fighter(" + skills[1] + ")|Trader("
                + skills[2] + ")|Engineer(" + skills[3] + ")|Investor(" + skills[4] + ")\n"
                + "Currency: " + currency;
    }
}
