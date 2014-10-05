package spacetraders1dot0.model;

/**
 * Class Item
 * Represents purchasable item
 * @author Nick
 * @version 1.0
 */
public class Item {
	

	private final String itemName;
	private final int mtlp;
	private final int mtlu;
	private final int ttp;
	private final int base;
	private final int ipl;
	private final int var;
	private final String ie;
	private final String cr;
	private final String er;
	private final int mtl;
	private final int mth;
        
        private int limit;
        private int quantity;

	/**
	 * Constructor for Item superclass
	 *
	 * @param name, name of the item
	 * @param mtlp, minimum tech level to purchase
	 * @param mtlu, minimum tech level to use
	 * @param ttp, Tech level that produces the most of this resource
	 * @param base, base price of item
	 * @param ipl, price increase per tech level
	 * @param var, variance in price
	 * @param ie, "increase event" determines price spike
	 * @param cr, Cheapest resource name
	 * @param er, Expensive resource name
	 * @param mtl, merchant trading value low
	 * @param mth, merchant trading value high
	 */
	public Item(String name, int mtlp, int mtlu, int ttp, int base, int ipl, int var,
		String ie, String cr, String er, int mtl, int mth) {

		itemName = name;
		this.mtlp = mtlp;
		this.mtlu = mtlu;
		this.ttp = ttp;
		this.base = base;
		this.ipl = ipl;
		this.var = var;
		this.ie = ie;
		this.cr = cr;
		this.er = er;
		this.mtl = mtlp;
		this.mth = mth;
                
                limit = 5;
                quantity = (int)(Math.random()*(limit-1)+1);
	}

	/**
	 * Getter for itemName
	 * @return String itemName
	 */
	public String getName() {
		return itemName;
	}

	/**
	 * Getter for MTLP
	 * @return int MTLP
	 */
	public int getMTLP() {
		return mtlp;
	}
	
	/**
	 * Getter for mtlu
	 * @return int mtlu
	 */
	public int getMTLU() {
		return mtlu;
	}
	
	/**
	 * Getter for ttp
	 * @return int ttp
	 */
	public int getTTP() {
		return ttp;
	}

	/**
	 * Getter for base
	 * @return int base
	 */
	public int getBase() {
		return base;
	}

	/**
	 * Getter for ipl
	 * @return int ipl
	 */
	public int getIPL() {
		return ipl;
	}
	
	/**
	 * Getter for var
	 * @return int var
	 */
	public int getVar() {
		return var;
	}
	
	/**
	 * Getter for ie
	 * @return String ie
	 */
	public String getIE() {
		return ie;
	}
	
	/**
	 * Getter for cr
	 * @return String cr
	 */
	public String getCR() {
		return cr;
	}
	
	/**
	 * Getter for er
	 * @return String er
	 */
	public String getER() {
		return er;
	}
	
	/**
	 * Getter for mtl
	 * @return int mtl
	 */
	public int getMTL() {
		return mtl;
	}
	
	/**
	 * Getter for mth
	 * @return int mth
	 */
	public int getMTH() {
		return mth;
	}
        /**
         * Getter for limit
         * @return int limit
         */
        public int getLimit(){
            return limit;
        }
        /**
         * Getter for quantity
         * @return quantity
         */
        public int getQuantity(){
            return quantity;
        }

        /**
         * Increments or decrements quantity
         * @param inc true if increment false if decrement
         */
        public void changeQuantity(boolean inc){
            quantity += (inc) ? 1 : -1;
        }
}