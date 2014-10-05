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
enum WeaponType {
     //name                   damage    cost      min_techLevel             
     PULSE("PULSE",           50,       100,           0),
     BEAM("BEAM",             80,       200,           3),
     MILITARY("MILITARY",     200,      1000,          5);

     private final String name;
     private final int damage;
     private final int cost;
     private final int minTechLevel;
     WeaponType(String weaponName, int weaponDamage, int weaponCost, int weaponTechLevel)
     {
          name = weaponName;
          damage = weaponDamage;
          cost = weaponCost;
          minTechLevel = weaponTechLevel;
     }
     /**
      * 
      * @return current weapon name
      */
     public String getWeaponName()
     {
          return name;
     }
     /**
      * 
      * @return current weapon damage
      */
     public int getWeaponDamage()
     {
          return damage;
     }
     /**
      * 
      * @return current weapon cost
      */
     public int getWeaponCost()
     {
          return cost;
     }
     /**
      * @return minimum tech level for the weapon
      * */
     public int getWeaponRequiredTechLevel()
     {
          return minTechLevel;
     }
    
}
