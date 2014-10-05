package spacetraders1dot0.model;

/**
 * Class Food extends Item
 * Represents purchasable item Food
 * @author Nick
 * @version 1.0
 */
public class Food extends Item {
	
	/**
	 * Constructor for Food
	 */
	public Food() {
		super("FOOD", 1, 0, 1, 100, 5, 5, "CROPFAIL",  "RICH-SOIL",  "POOR-SOIL",  90, 160);
	}
}