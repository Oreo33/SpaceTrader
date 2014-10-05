package spacetraders1dot0.model;

/**
 * Class Medicine extends Item
 * Represents purchasable item Medicine
 * @author Nick
 * @version 1.0
 */
public class Medicine extends Item{
	
	/**
	 * Constructor for medicine
	 */
	public Medicine() {
		super("MEDICINE", 4, 1, 6, 650, -20, 10, "PLAGUE",  "LOTS-OF-HERBS", "Never", 400,  700);
	}
}