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
public interface Slot {
     /**
      * 
      * @return true if current slot is full; otherwise false
      */
     public boolean isCurrentSlotFull();
     /**
      * 
      * @return true if current slot is empty; otherwise false
      */
     public boolean isCurrentSlotEmpty();
     /**
      *
      * @return true if current slot has been used; otherwise false
     */
     public boolean isCurrentSlotUsed();
     /**
      * 
      * @return the number of items in current slot
      */
     public int currentSlotItemQuantity();
     /**
      * 
      * @return the name of item in current slot
      */
     public String currentSlotItemName();
     
     /**
      * 
      * @return maximum items can be loaded in one slot
      */
     public int maxItemPerSlot();
     /**
      * 
      * @return the index of current slot number
      */
     public int currentSlotIndex();
}
