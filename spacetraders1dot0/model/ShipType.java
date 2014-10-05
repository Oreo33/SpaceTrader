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
enum ShipType {
                    //name		cs  w  s  g  c  f   mt fp  price  b    o   h    r  s
     GNAT("GNAT",                       15, 1, 0, 1, 1, 14,  5, 2, 10000, 50,  28, 100, 1, 1),
     FLEA("FLEA",                       10, 0, 0, 0, 1, 500, 4, 1, 2000,  5,   2,  25,  1, 1),
     FIREFLY("FIREFLY", 		15, 2, 1, 1, 1, 13,  5, 5, 25000, 75,  20, 100, 1, 1),
     MOSQUITO("MOSQUITO",               15, 1, 0, 1, 1, 14,  5, 2, 30000, 100, 20, 100, 1, 1),
     BUMBLEBEE("BUMBLEBEE",             25, 1, 2, 2, 2, 15,  5, 7, 60000, 125, 15, 100, 1, 2),
     BEHEMOTH("BEHEMOTH",               50, 5, 5, 5, 2, 15,  5, 7, 90000, 125, 15, 100, 1, 2);

    private final String name;
    private final int cargo;
    private final int weapons;
    private final int shields;
    private final int gadgets;
    private final int crewSize;
    private final int fuelSize;
    private final int minTechLevel;
    private final int fuelCost;
    private final int shipPrice;
    private final int shipBounty;
    private final int shipOccurence;
    private final int shipHullStrength;
    private final int shipRepairCost;
    private final int shipSize;

    ShipType(String shipName, int cargoSpace, int weaponSlots, int shieldSlots, int gadgetSlots, int crew, int fuel, int minTech,
            int fuelPrice, int price, int bounty, int occurence, int hullStrength, int repairCost, int size) {
        name = shipName;
        cargo = cargoSpace;
        weapons = weaponSlots;
        shields = shieldSlots;
        gadgets = gadgetSlots;
        crewSize = crew;
        fuelSize = fuel;
        minTechLevel = minTech;
        fuelCost = fuelPrice;
        shipPrice = price;
        shipBounty = bounty;
        shipOccurence = occurence;
        shipHullStrength = hullStrength;
        shipRepairCost = repairCost;
        shipSize = size;
    }

    public String getName() {
        return name;
    }

    /**
     * @return the cargo
     */
    public int getCargo() {
        return cargo;
    }

    /**
     * @return the weapons
     */
    public int getWeapons() {
        return weapons;
    }

    /**
     * @return the shields
     */
    public int getShields() {
        return shields;
    }

    /**
     * @return the gadgets
     */
    public int getGadgets() {
        return gadgets;
    }

    /**
     * @return the crewSize
     */
    public int getCrewSize() {
        return crewSize;
    }

    /**
     * @return the fuelSize
     */
    public int getFuelSize() {
        return fuelSize;
    }

    /**
     * @return the minTechLevel
     */
    public int getMinTechLevel() {
        return minTechLevel;
    }

    /**
     * @return the fuelCost
     */
    public int getFuelCost() {
        return fuelCost;
    }

    /**
     * @return the shipPrice
     */
    public int getShipPrice() {
        return shipPrice;
    }

    /**
     * @return the shipBounty
     */
    public int getShipBounty() {
        return shipBounty;
    }

    /**
     * @return the shipOccurence
     */
    public int getShipOccurence() {
        return shipOccurence;
    }

    /**
     * @return the shipHullStrength
     */
    public int getShipHullStrength() {
        return shipHullStrength;
    }

    /**
     * @return the shipRepairCost
     */
    public int getShipRepairCost() {
        return shipRepairCost;
    }

    /**
     * @return the shipSize
     */
    public int getShipSize() {
        return shipSize;
    }


}
