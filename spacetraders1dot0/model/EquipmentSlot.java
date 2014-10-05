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
public class EquipmentSlot implements Slot{
     private String equipmentName;
     private int MAXEQUIPMENTPERSLOT;
     private int equipmentNumber;
     private boolean isSlotUsed;
     private int currentSlotIndex;
     
     public EquipmentSlot()
     {
          equipmentName = "";
          MAXEQUIPMENTPERSLOT = 1;
          equipmentNumber = 0;
          isSlotUsed = false;
     }
     public void installEquipment(String equipment)
     {
          equipmentName = equipment;
          equipmentNumber++;
          isSlotUsed = true;
     }
     public void removeEquipment()
     {
          equipmentNumber--;
          if(isCurrentSlotEmpty())
          {
               equipmentName = "";
               isSlotUsed = false;
          }
     }
     public void setIsSlotUsed(boolean isSlotUsed)
     {
          this.isSlotUsed = isSlotUsed;
     }
     public void setCurrentSlotIndex(int currentSlotIndex) 
     {
          this.currentSlotIndex = currentSlotIndex;
     }
     @Override
     public boolean isCurrentSlotFull() {
          return this.equipmentNumber == this.MAXEQUIPMENTPERSLOT;
     }

     @Override
     public boolean isCurrentSlotEmpty() {
          return this.equipmentNumber == 0;
     }

     @Override
     public boolean isCurrentSlotUsed() {
          return isSlotUsed;
     }

     @Override
     public int currentSlotItemQuantity() {
          return this.equipmentNumber;
     }

     @Override
     public String currentSlotItemName() {
          return this.equipmentName;
     }

     @Override
     public int maxItemPerSlot() {
          return this.MAXEQUIPMENTPERSLOT;
     }

     @Override
     public int currentSlotIndex() {
          return this.currentSlotIndex;
     }
}
