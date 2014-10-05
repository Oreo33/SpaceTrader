/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders1dot0.model;

/**
 *
 * @author song
 */
public class CargoSlot implements Slot{
        private String itemName;                            //name of item in current cargo slot
        private final int MAXITEMPERSLOT;         //maximum items can be loaded into the current cargo slot
        private int itemNumber;                             //number of items have been loaded in the current cargo slot
        private boolean isSlotUsed;                         //whether any item in the slot
        private int currentSlotIndex;
        private int itemPrice;
        /**
         * in default, each cargo slot can hold maximum of 10 item
         */
        public CargoSlot()
        {
             itemName = "";
             MAXITEMPERSLOT = 10;
             itemNumber = 0;
             isSlotUsed = false;
             itemPrice = 0;
        }
        /**
         * 
         * @param itemName name from the good that the player just buy 
         */
        public void setItemName(String itemName)
        {
             this.itemName = itemName;        
        }
        public void setItemPrice(int itemPrice)
        {
             this.itemPrice = itemPrice;
        }
        /**
         * number of items in current cargo slot increase by one each time
         */
        public void addItem(int itemPrice)
        {
             this.itemNumber++;
             setItemPrice(itemPrice);
        }
        
        /**
         * number of items in current cargo slot decrease by one each time
         * when there is not more item in current cargo slot, reset current cargo slot as not been used so it can be reused later
         */
        public void removeItem()
        {
             this.itemNumber--;
             if(isCurrentSlotEmpty()){       //reset the current cargo slot state when there is no more item
                  itemName = "";
                  isSlotUsed = false;
                  itemPrice = 0;
             }
        }
        
        /**
         * 
         * @param slotUsed from spaceship cargo, the current cargo slot state is updated when first item is loaded into current cargo slot
         */
      public void setSlotUsed(boolean slotUsed) {
          this.isSlotUsed = slotUsed;
     }
      /**
       * 
       * @param index set the current slot index
       */
      public void setCurrentSlotIndex(int index)
      {
           this.currentSlotIndex = index;           
      }
      /**
       * 
       * @return true if current cargo slot is full, otherwise false
       */
     @Override
     public boolean isCurrentSlotFull() {
          return this.itemNumber == this.MAXITEMPERSLOT;
     }
      /**
       * 
       * @return true if current cargo slot is empty, otherwise false
       */
     @Override
     public boolean isCurrentSlotEmpty() {
          return this.itemNumber == 0;
     }
      /**
       * 
       * @return the number of items in the current cargo slot
       */
     @Override
     public int currentSlotItemQuantity() {
          return this.itemNumber;
     }
      /**
       * 
       * @return the item name in the current cargo slot
       */
     @Override
     public String currentSlotItemName() {
          return this.itemName;
     }
      /**
       * 
       * @return true if current cargo slot has been used
       */
     @Override
     public boolean isCurrentSlotUsed() {
          return this.isSlotUsed;
     }
      /**
       * 
       * @return the number of maximum item in each slot
       */
     @Override
     public int maxItemPerSlot() {
          return this.MAXITEMPERSLOT;
     }
     /**
      * 
      * @return the index of current slot
      */
     @Override
     public int currentSlotIndex() {
          return currentSlotIndex;
     }
     
}
