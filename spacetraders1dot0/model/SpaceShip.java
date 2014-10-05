package spacetraders1dot0.model;

/**
 * FuelCapacityCurrent may need a modifier such that if it keeps track of how
 * much distance it can cover I am unsure of the realistic distances between
 * planets.
 */
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Kentaro, song
 */
public class SpaceShip {

    private ShipType type;
    private SpaceshipCargo theShipCargo;
    private SpaceshipWeapon theShipWeapon;        
    private SpaceshipShield theShipShield;
    private SpaceshipGadget theShipGadget;
    private int maxCargoSlots;
    private int maxWeaponSlots;
    private int maxShieldSlots;
    private int maxGadgetSlots;
    private int maxCrewSize;
    private int fuelCapacityTotal;
    private int fuelCapacityCurrent;
    private int fuelCapacityDistanceModifier = 50; //Planets are on a 350x350 plane, change this to change all the ships basic range
    private int minimumTech;
    private int fuelExpenditure;
    private int shipAmount;
    private int hullStrengthTotal;
    private int hullStrengthCurrent;
    private int repairCost;
    private int shipSize;
    private int xCoordinate;
    private int yCoordinate;

    private ShieldType shieldType;
    private String shieldName;
    private int shieldStrength;


    /**
     * On spaceship creation only the ship type and playermods should be known
     * Gadgets, weapons, and skills must be added later.
     *
     * @param t the type of ship call as "ShipType.GNAT" for example
     * @param playerMods an array containing the player skills to be used as
     * modifiers on the ship
     */
    public SpaceShip(ShipType t, int[] playerMods) {
        type = t;
        maxWeaponSlots = type.getWeapons();
        maxShieldSlots = type.getShields();
        maxGadgetSlots = type.getGadgets();
        maxCargoSlots = type.getCargo();
        maxCrewSize = type.getCrewSize();
        fuelCapacityTotal = type.getFuelSize();
        fuelCapacityCurrent = type.getFuelSize();
        minimumTech = type.getMinTechLevel();
        fuelExpenditure = type.getFuelCost();
        shipAmount = type.getShipPrice();
        hullStrengthTotal = type.getShipHullStrength();
        hullStrengthCurrent = type.getShipHullStrength();
        repairCost = type.getShipRepairCost();
        shipSize = type.getShipSize();
        shieldStrength = 0;
        this.playerSkillMod(playerMods);
        theShipCargo = new SpaceshipCargo(maxCargoSlots);//the amount of ship cargo needs to get created after playermod is calculated

        theShipWeapon = new SpaceshipWeapon(maxWeaponSlots, minimumTech);
        theShipShield = new SpaceshipShield(maxShieldSlots, minimumTech);
        theShipGadget = new SpaceshipGadget(maxGadgetSlots, minimumTech);
        xCoordinate = 0; //bs placeholder
        yCoordinate = 0; //bs placeholder
    }

    /**
     * Based off of the player skill mod, ship variables can update [0] == Pilot
     * == More Travel [1] == Fighter == More Weapon Damage [2] == Trader == More
     * Cargo Space [3] == Engineer == Better engine, less fuel use cost [4] ==
     * Investor == Cheaper repair Cost
     *
     * @param an array containing the player skills
     */
    public void playerSkillMod(int[] playerShipModifiers) {
        int max = 0;
        int maxPosition = 0;
        for (int i = 0; i < playerShipModifiers.length; i++) {
            if (playerShipModifiers[i] > max) {
                max = playerShipModifiers[i];
                maxPosition = i;
            }
        }
        if (maxPosition == 0) {
            fuelCapacityTotal += 2;
        } else if (maxPosition == 1) {
            //more weapon damage
        } else if (maxPosition == 2) {
            maxCargoSlots += 2;
        } else if (maxPosition == 3) {
            fuelExpenditure -= 1;
        } else if (maxPosition == 4) {
            repairCost -= 20; //BS value...will update later when prices are known
        } else {
            //placeholder
        }
    }
    public boolean loadGadget(GadgetType gadget)
    {
        if(theShipGadget.loadEquipment(gadget.getGadgetName(), gadget.getGadgetRequiredTechLevel()))
              return true;
         else
              return false;
    }
    public boolean unloadGadget(GadgetType gadget)
    {
         if(theShipGadget.unloadWeapon(gadget.getGadgetName()))
              return true;
         else
              return false;
    }
    public boolean loadShield(ShieldType shield)
    {
         if(theShipShield.loadEquipment(shield.getShieldName(), shield.getShieldRequiredTechLevel()))
              return true;
         else
              return false;
         
    }
    public boolean unloadShield(ShieldType shield)
    {
         if(theShipShield.unloadWeapon(shield.getShieldName()))
              return true;
         else
              return false;
    }
    /**
     * 
     * @param weapon, the player wants to add a weapon
     * @return true if the weapon can be installed, otherwise false
     */
    public boolean loadWeapon(WeaponType weapon)
    {
         if(theShipWeapon.loadEquipment(weapon.getWeaponName(), weapon.getWeaponRequiredTechLevel()))
              return true;
         else
              return false;
    }
    
    /**
     * 
     * @param weapon, the player wants to remove a weapon
     * @return true if the weapon is removed, otherwise false (if there is not such weapon)
     */
    public boolean unloadWeapon(WeaponType weapon)
    {
         if(theShipWeapon.unloadWeapon(weapon.getWeaponName()))
              return true;
         else
              return false;
    }
    public boolean isCargoHoldFull()
    {
         return theShipCargo.isCargoHoldFull();
    }
    
    /**
     *
     * @param item, the player intends to buy a good
     * @return false if you can't buy more, true if you did add more
     */
    public boolean buyCargo(String item, int itemPrice) {
        if (theShipCargo.loadCargo(item, itemPrice)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param item, the player intends to sell a good
     * @return true if the player has the item to sell, otherwise false
     *
     */

    public boolean sellCargo(String item, int itemPrice) {
        if (theShipCargo.unloadCargo(item, itemPrice)) {
            return true;
        } else {
            return false;
        }
    }

    
//    public boolean addItemToCargo(String item){
//        boolean success = false;
//        if(cargoHold.size() < maxCargoHold){
//            if(cargoHold.containsKey(item)){
//                cargoHold.put(item,cargoHold.get(item)+1);
//            }
//            else{
//                cargoHold.put(item,1);
//            }
//            success = true;
//        }
//        currentCargoHoldAmount++;
//        return success;
//    }
    
    /**
     * shows the contents in the current spaceship cargo
     */
    public void displayCargoGoods() {
        Set goodsSet;
        goodsSet = theShipCargo.cargoGoods().entrySet();
        Iterator i = goodsSet.iterator();
        while (i.hasNext()) {
            Map.Entry<String, CargoSlot> good = (Map.Entry) i.next();
            System.out.print(good.getKey() + ": ");
            System.out.println(good.getValue().currentSlotItemQuantity() + ", slot#: " + good.getValue().currentSlotIndex());
        }
    }

    /**
     * returns the repair cost
     *
     * @return the cost of the repair
     */
    public int getRepairCost() {
        return repairCost;
    }

    /**
     * The fuel used by the ship in travel
     *
     * @return the amount of fuel used
     */
    public int getFuelExpenditure() {
        return fuelExpenditure;
    }
    /**
     * Returns the current fuel capacity. Returns the amount in distance units you can travel
     * @return the distance units you can travel.
     */

    public int getFuelCapacityCurrent(){
        return fuelCapacityCurrent;
    }


    
//    public void removeItemFromCargo(String item){
//        if(cargoHold.containsKey(item)){
//            if(cargoHold.get(item)>1){
//                cargoHold.put(item,cargoHold.get(item)-1);
//            }
//            else{
//                cargoHold.remove(item);
//            }
//            currentCargoHoldAmount --;
//        }
//        else{
//            //error message
//        }
//    }
    
    /**
     * Gets the x coordinate of this ship
     *
     * @return x coordinate x
     */
    public int getX() {
        return xCoordinate;
    }

    /**
     * Get the y coordinate of this ship
     *
     * @return the y coord
     */
    public int getY() {
        return yCoordinate;
    }

    /**
     * Set the X coord
     *
     * @param x sets x
     */
    public void setX(int x) {
        xCoordinate = x;
    }

    /**
     * Set the Y coord
     *
     * @param y sets y
     */
    public void setY(int y) {
        yCoordinate = y;
    }

    /**
     * Return true if dead, false if still alive meanwhile calculating shield
     * and hull remaining power
     *
     * @param damage the amount of damage to take
     * @return True is ship is dead, false if ship can continue
     */
    public boolean takeDamage(int damage) {
        int shields = shieldStrength;
        int hull = hullStrengthCurrent;
        int remainingDamage;

        if (shields > 0) { //if you have any shield power
            shields -= damage;
            if (shields > 0) {
                shieldStrength = shields; //the new amount of shield left
            } else {
                remainingDamage = Math.abs(shields); //if the damage knocked out the remaining shield
                hull -= remainingDamage;
                if (hull <= 0) {
                    hullStrengthCurrent = 0; //ship blown up
                    return true;
                } else {
                    hullStrengthCurrent = hull;  //the remaining amount of hullStrength
                }
            }
        } else { //no shield power
            if (damage >= hullStrengthCurrent) {
                hullStrengthCurrent = 0;
                return true;
            } else {
                hullStrengthCurrent -= damage;
                return false;
            }
        }
        return false;
    }

    /**
     * This will calculate if you can reach your destination
     *
     * @param x the x of your destination
     * @param y the y of your destination
     * @return True is possible to reach and false if cannot reach destination
     */
    public boolean checkPossibleTarget(int x, int y) {
        int a = (int) Math.pow(x - xCoordinate, 2);
        int b = (int) Math.pow(y - yCoordinate, 2);
        int distance = (int) Math.sqrt(a + b);
        return distance <= fuelCapacityCurrent;
    }
    /**
     * This will take you to your target but if it fails it does nothing
     *
     * @param x the x of your target
     * @param y the y of your target
     * @return Returns true if the path was taken, false if not
     */
    public boolean travelToTarget(int x, int y) {
        if (checkPossibleTarget(x, y) == true) { //checks such that your fuel won't become in the negatives.
            xCoordinate = x - 20;
            yCoordinate = y - 20; //Ships travel 20 clicks away
            int a = (int) Math.pow(x - xCoordinate, 2);
            int b = (int) Math.pow(y - yCoordinate, 2);
            int removeFuelAmount = (int) Math.sqrt(a + b);
            fuelCapacityCurrent -= removeFuelAmount - 20;  //doesn't punish for game requirements therefore -20
            return true;
        }else{
            return false;
        }
    }
    
    public int maxCapacityOfGoods()
    {
         return theShipCargo.cargoMaxCapacity();
    }
    public int availableCargoSlots()
    {
         return this.maxCargoSlots - theShipCargo.getCurrentCargoSlotsUsed();
    }
    public int amountToRepair() {
        return hullStrengthTotal - hullStrengthCurrent;
    }

    public int amountToRefuel() {
        return fuelCapacityTotal - fuelCapacityCurrent;
    }
    /**
     * Access spaceship cargo
     * @return ship cargo
     */
    public SpaceshipCargo getCargo(){
        return theShipCargo;
    }

        /**
     * Set the shield for use, the shield strength may deplete so need to buy
     * shield again
     *
     * @param shield the kind to set call such as Shields.ION
     */
    public void setShields(ShieldType shield) {
        shieldType = shield;
        shieldName = shieldType.getShieldName();
        shieldStrength = shieldType.getShieldStrength();
    }

    /**
     * Accessor for the enum Shields
     *
     * @return the shield type
     */
    public ShieldType getShields() {
        return shieldType;
    }
    
//    public int getCurrentCargoSize(){
//        return currentCargoHoldAmount;
//    }
//    
//    public int getCargoMax(){
//        return maxCargoHold;
//    }
//    /**
//     * For debugging: seeing cargo
//     */
//    public void printCargo(){
//        System.out.println(cargoHold.toString());
//    }

}
