package spacetraders1dot0.model;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Class Marketplace
 * Controls marketplace interactions
 * Changes prices based on planet
 * @author Nick
 * @version 1.0
 */
public class Marketplace {
	
	private int techLevel;	
	private int specialResource;
	private int increaseEvent;
	private final double CHEAPRESOURCE = 0.7;
	private final double EXPENSIVERESOURCE = 1.3;
	private final double INCREASEEVENT =  1.5;

	private HashMap<Item,Integer> inventory; 

	/**
	 * Constructor for Marketplace
	 *
	 * @param Planet planet
	 */
	public Marketplace(Planet planet) {
		techLevel = planet.getTechLevel();
		specialResource = planet.getSpecialResource();
		increaseEvent = planet.getIncreaseEvent();
		inventory = initializeInventory(techLevel);
	}

	/**
	 * Returns the inventory
	 * @return Hashmap inventory
	 */
	public HashMap<Item,Integer> getInventory() {
		if (inventory.isEmpty()) {
			return null;
		} else {
			return inventory;
		}
	}

	/**
	 * Determine price for selling an item to Marketplace
	 * @param String to convert to Item
	 * @return value
	 */
	public int getItemPrice(String s) {
		Item item = getItemKey(s);
		if ((item != null) && (inventory.size() != 0)) {
			int inventoryValue = inventory.get(item);
                        item.changeQuantity(true);
			return (int)(inventoryValue * .75);
		}
		return 0;
	}

	/**
	 * Creates a hashmap of the inventory
	 * @param int techlevel of planet
	 */
	private HashMap<Item,Integer> initializeInventory(int level) {

		HashMap<Item,Integer> tmpHashMap = new HashMap<Item,Integer>(inventorySize(level));
		Item[] arr = {new Water(), new Fur(), new Food(), new Ore(), new Games(), new Firearms(), new Medicine(), new Machines(), new Narcotics(), new Robots()};


		for (int i = 0; i < inventorySize(level); i++) {
			tmpHashMap.put(arr[i], priceItem(arr[i], level));
		}
		return tmpHashMap;
	}

	/**
	 * Determines size of inventory based on techlevel
	 * @param int techlevel of planet
	 */
	private int inventorySize(int level) {
		switch(level) {
			case 0:
				return 2;
			case 1:
				return 3;
			case 2:
				return 4;
			case 3:
				return 6;
			case 4:
				return 8;
			case 5:
				return 9;
			case 6:
				return 10;
		}
		return 0;
	}

	/**
	 * Determine price of an item
	 * Based on planet details
	 * 
	 * @param Item item to be priced
	 * @param int techlevel of planet
	 * @return int price of item
	 */
	private int priceItem(Item item, int level) {
		//basePrice + (IPL * (level - MTLP)) + var
		int price = item.getBase() + (item.getIPL() * (level - item.getMTLP())) + item.getVar();
		
		if (checkSpecialResource(specialResource).equals(item.getCR())) {
			price *= CHEAPRESOURCE;
		}
		else if (checkSpecialResource(specialResource).equals(item.getER())) {
			price *= EXPENSIVERESOURCE;
		}
		if (checkIncreaseEvent(increaseEvent).equals(item.getIE())){
			price *= INCREASEEVENT;
		}
		return price;
	}



	/**
	 * Helper of priceItem to check if the planet's
	 * special resource matches the CR or ER
	 * @param int specialResource of planet
	 */
	private String checkSpecialResource(int s) {
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
	 * Helper of priceItem to check if the planet's
	 * increase event matches the IE
	 * @param int increaseEvent of planet
	 */
	private String checkIncreaseEvent(int ie) {
        switch (ie) {
            case 0:
                return "DROUGHT";
            case 1:
                return "COLD";
            case 2:
                return "CROPFAIL";
            case 3:
                return "WAR";
            case 4:
                return "BOREDOM";
            case 5:
                return "PLAGUE";
            case 6:
                return "LACKOFWORKERS";
            default:
                return "NOTHING";
        }
    }

    /**
     * Check if contains by name
     * @param s name of item
     * @return ItemKey
     */
    public Item getItemKey(String s){
        s = s.toUpperCase();
        Iterator i = inventory.keySet().iterator();
        String[] names = new String[inventory.keySet().size()];
        while(i.hasNext()){
            Item tempItem = (Item)i.next();
            if(s.equals(tempItem.getName())){
                return tempItem;
            }
        }
        return null;
    }
}