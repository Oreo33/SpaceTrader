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
public class SpaceshipEquipment {
     private int maxEquipmentSlots;                       //max Equipment slots on current spaceship
     private int numberEquipmentSlotsUsed;                
     private int numberOfEquipments;
     private int techLevel;                            //current spaceship's techLevel
     private EquipmentSlot[] theEquipmentSlots;
     
     
     /**
      * 
      * @param maxEquipmentSlots, it depends on the type of spaceship
      * @param techLevel, the spaceship technology level
      */
     public SpaceshipEquipment(int maxEquipmentSlots, int techLevel)
     {
          this.maxEquipmentSlots = maxEquipmentSlots;
          this.techLevel = techLevel;
          theEquipmentSlots = new EquipmentSlot[maxEquipmentSlots];
          numberEquipmentSlotsUsed = 0;
          numberOfEquipments = 0;
          initSpaceshipWeaponSlots();
     }
     
     /**
      * initialize Equipment slots for further Equipment installation
      */
     private void initSpaceshipWeaponSlots()
     {
          for (int i = 0; i < this.maxEquipmentSlots; ++i)
          {
               theEquipmentSlots[i] = new EquipmentSlot();
          }
     }
     
     /**
      * 
      *@param Equipment, the Equipment that the player intends to install
      *@return true if the Equipment can be installed, otherwise false
      * */
     public boolean loadEquipment(String equipment, int requiredTechLevel)
     { 
//if the spaceship techlevel could not meet with weapon techlevel requirement, can't install
          if(isEquipmentSlotsFull() || requiredTechLevel > techLevel)
               return false;       
          else
          {
               int equipmentSlotIndex = 0;
               if (!isEquipmentSlotsEmpty())                   //if there exists at least one weapon
               {
                    for (int i = 0; i < maxEquipmentSlots; ++i)
                    {
                         if(!theEquipmentSlots[i].isCurrentSlotUsed()){
                              equipmentSlotIndex = i;               //allocate an open weapon slot
                              break;
                         }
                    }                                  
               }
               //load the weapon to the slot
               theEquipmentSlots[equipmentSlotIndex].installEquipment(equipment);
               theEquipmentSlots[equipmentSlotIndex].setIsSlotUsed(true);
               theEquipmentSlots[equipmentSlotIndex].setCurrentSlotIndex(equipmentSlotIndex);
               numberEquipmentSlotsUsed++;    
               numberOfEquipments++;
               return true;
          }
     }
     
     /**
      * 
      * @param Equipment, the Equipment that the player intends to unload
      * @return true if the Equipment is uninstalled, otherwise false
      */
     public boolean unloadWeapon(String equipment)
     {
          if(isEquipmentSlotsEmpty())
               return false;
          else
          {
               for (int i = 0; i < numberEquipmentSlotsUsed; ++i)
               {
                    if(theEquipmentSlots[i].currentSlotItemName().equals(equipment)){
                         theEquipmentSlots[i].removeEquipment();
                         return true;
                    }
               }
               return false;
          }
     }
     
     /**
      * @return true if no weapon in the weapon slot, otherwise false
      * */
     public boolean isEquipmentSlotsEmpty()
     {
          return this.numberOfEquipments == 0;
     }
     
     /**
      * 
      * @return true if all the weapon slots have been used
      */
     public boolean isEquipmentSlotsFull()
     {
          return this.maxEquipmentSlots == this.numberEquipmentSlotsUsed;
     }
     
     /**
      * 
      *@return max weapon slots on current spaceship
      * */
     public int getMaxEquipmentSlots(){
          return this.maxEquipmentSlots;
     }
     
     /**
      * 
      * @return number of weapons have been installed
      */
     public int getNumberOfEquipments(){
          return this.numberOfEquipments;
     }
     
     /**
      * 
      * @return all the weapon slots
      * */
     public EquipmentSlot[] getEquipments(){
          return theEquipmentSlots;
     }
}

