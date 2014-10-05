/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders1dot0.model;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author song
 */
public class SpaceshipCargo{
    private int maxCargoSlots;                  //maximum of cargo slots on the ship depend on the type of ship
    private int numberCargoSlotsUsed;       //indicate the number of cargo slots have been used 
    private int numberOfGoods;                    //track number of goods in the current spaceship cargo
    private int maxCapacityOfGoods;            //maximum number of goods can be loaded in the current spaceship cargo
    private CargoSlot[] theCargoSlots;           //each cargo slot can contain maximum of 10 same type of good, e.g. 10 water, 10 fruit
    private HashMap<String, CargoSlot> theCargoGoods;    //each key will hold a slot, and each slot will have a CargoBox
    
    /**
     * Validates cargo slots for the space ship
     * 
     * @param spaceShip the current instance of spaceship 
     */
    public SpaceshipCargo(int cargoAmount)
    {
          maxCargoSlots = cargoAmount;          //max cargo slots on the ship is depend on the current spaceship type
          theCargoSlots = new CargoSlot[maxCargoSlots];       //each spaceship cargo has number of cargo slots
          theCargoGoods =  new HashMap<>();                 //cargo goods in the current cargo slots
          numberCargoSlotsUsed = 0;                         //number of current cargo slots have been used for storing goods
          numberOfGoods = 0;                                      //number of goods have been loaded into current spaceship cargo
          initSpaceshipCargoSlots();                                       //initialize cargo slots in current spaceship
    }
    private void initSpaceshipCargoSlots()
    {
         for(int i = 0; i < maxCargoSlots; ++i)
         {
              theCargoSlots[i] = new CargoSlot();
         }
         maxCapacityOfGoods = maxCargoSlots * theCargoSlots[0].maxItemPerSlot();
    }
    /**
     * Gets the max cargo slots
     * @return the max cargo slots
     */
    public int getMaxCargoSlots(){
        return maxCargoSlots;
    }
    /**
     * Updates the cargo slot amount
     * @param newCargoSlotAmount the new amount of cargo slots 
     */
    public void setMaxCargoSlots(int newCargoSlotAmount){
        maxCargoSlots = newCargoSlotAmount;
    }
    /**
     * 
     *@return true if all cargo slots have been used and could not store any more new item, otherwise false
     */
    public boolean isCargoHoldFull()
    {
          return numberCargoSlotsUsed == maxCargoSlots;
    }
    /**
    *
    * @return true if the cargo is empty; there is not an item has been stored yet, otherwise false
    */
    public boolean isCargoHoldEmpty()
    {
        return numberCargoSlotsUsed == 0;
    }
    /**
     * @param goods the player wants to unload the good from the spaceship cargo
     * @return true if a good can be unloaded from the ship; otherwise false
     */
    public boolean unloadCargo(String good, int goodPrice)
    {
         String goodName = good + "00";
         if(!theCargoGoods.containsKey(goodName))          //if there is not such good in current spaceship cargo
         {
              return false;
         }
         else
         {

              String currentGoodName = goodName;
             while(theCargoGoods.containsKey(goodName))
             {
                  currentGoodName = goodName;
                  goodName = nameAppend(goodName);
             }
             theCargoGoods.get(currentGoodName).removeItem();
             if(theCargoGoods.get(currentGoodName).isCurrentSlotEmpty())
             {
                  theCargoGoods.remove(currentGoodName);
                  numberCargoSlotsUsed--;
             }
             numberOfGoods--;
             return true;
         }
    }
    /**
     * 
     *when the player wants to buy a good and load it into the spaceship cargo, some conditions and restrictions may apply: 
     * 1. if the good is a new type, which means it has not been loaded into the current cargo before, and there is an empty cargo slot in the spaceship cargo, then this good can be loaded
     * 2. if the good is not a new type and the current cargo slots that hold this type of good are all full, but there is an empty cargo slot in the spaceship cargo, then this good can be loaded
     * 3. if the good is not a new type, which means it has been loaded in the current cargo before, and there is an open space in the current cargo slot that hold the same type of good, then this good can be loaded
     * otherwise, the good can not be loaded into the spaceship cargo, which means the player can't purchase this item
     * @param goods the player wants to load the good into the spaceship cargo
     * @return true if a good can be loaded onto the ship; otherwise false
     */
    public boolean loadCargo(String good, int goodPrice){
         String goodName = good + "00";           //prevent having same name for multiple slots with a same good type
        if (!theCargoGoods.containsKey(goodName))      //if the good is a new type
        {
             if (isCargoHoldFull())                       //a new type of good need a empty cargo slot
                  return false;                        //if current cargo slots have all been used, can't buy any new type of good
             else                                 //otherwise, there exists at least one empty cargo slot for this new type of good
             {
                  addGoodToNewSlot(goodName, goodPrice);        //load the good to a new empty cargo slot
                  return true;
             }
        }
        else        //if there exists at lease one cargo slot holds same type of good in the spaceship cargo 
        {   
             if(numberOfGoods == maxCapacityOfGoods)
                  return false;         //the spaceship has reach its maximum capacity, can't buy any more good
             else                       //a cargo slot holds the same type of good 
             {
                  //if multiple slots that hold a same type of good, take the newest one
                  while(theCargoGoods.containsKey(goodName) && theCargoGoods.get(goodName).isCurrentSlotFull())
                  {
                       goodName = nameAppend(goodName);
                  }
                  if(theCargoGoods.containsKey(goodName))        //There exists a slot that holds the same type of good, but it is not full
                  {
                        theCargoGoods.get(goodName).addItem(goodPrice);        //load the good into this cargo slot
                        numberOfGoods++;
                        return true;
                  }     
                  else                            //all cargo slots that hold the same type of good are full
                  {
                       if(isCargoHoldFull())          // there is not more empty cargo slot available
                            return false;         //can't buy any more good
                       else                            //there exists at least one empty cargo slot
                       {
                            addGoodToNewSlot(goodName, goodPrice);        //load the good to a new empty cargo slot
                            return true;
                       }
                  }
             }
        }
    }
    /**
     * 
     * 
     * @param a new good that the player buys
     */
    private void addGoodToNewSlot(String goodName, int goodPrice)
    {
          int index = emptyCargoSlotIndex();
          theCargoSlots[index].setSlotUsed(true);                //set the empty cargo slot as taken
          theCargoSlots[index].setItemName(goodName);       //set the type of good in this cargo slot
          theCargoSlots[index].setItemPrice(goodPrice);
          theCargoSlots[index].addItem(goodPrice);                        //increase item number
          theCargoSlots[index].setCurrentSlotIndex(index);       //sets current slot index
          theCargoGoods.put(goodName, theCargoSlots[index]);     //add new type of good to the hashmap 
          numberOfGoods++;                        // total number of goods increase  
          numberCargoSlotsUsed++;            //total number of cargo slots have been used
    }
    public int cargoMaxCapacity()
    {
         return this.maxCapacityOfGoods;
    }
    public int getCurrentCargoGoodsTotal()
    {
         return this.numberOfGoods;
    }
    public int getCurrentCargoSlotsUsed()
    {
         return this.numberCargoSlotsUsed;
    }
    /**
     * the index of empty cargo slot can be any number, as long as no items in a cargo slot, it is empty
     * @return the index of an empty cargo slot
     */
    private int emptyCargoSlotIndex()
    {
          int index = 0;
          while(theCargoSlots[index].isCurrentSlotUsed() && index < maxCargoSlots)          //take the next available empty cargo slot for the new good
          {
               index++;
          }
          return index;
    }
    
    /**
     * 
     * @param the good name, it needs to be modified in order for multiple slots of same item type
     * @return the modified new good name
     */
    private String nameAppend(String name)
    {
         String fs = name.substring(0, name.length() - 2);
         String es = name.substring(name.length() -2);
         int index = Integer.parseInt(es);
         index++;
        String nameAppend = "";
        if(index < 10)
             nameAppend = "" + 0 + index;
        else 
             nameAppend = "" + index;
        return fs+nameAppend;
    }
    /**
     * 
     * display all existing goods in current spaceship cargo
     * */
    public HashMap<String, CargoSlot> cargoGoods()
    {
         return theCargoGoods;
    }      
}
