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
enum GadgetType {
               //NAME        cost    upgrade_ability  techLevel_required   
     CARGOBAY("CARGOBAY",    1000,         1,               0          ),
     GPS(      "GPS",        3000,         4,               2),
     REPAIRTOOL("REPAIRTOOL",4000,         3,               2),
     AIMTOOL(  "AIMTOOL",    5000,         4,               3),
     CLOAK(    "CLOAK",      10000,        8,               5);
     
     private final String name;
     private final int cost;
     private final int upgradeAbility;
     private final int techLevelRequired;
     
     GadgetType(String gadgetName, int gadgetCost, int upgradeAbility, int techLevelRequired)
     {
          this.name = gadgetName;
          this.cost = gadgetCost;
          this.upgradeAbility = upgradeAbility;
          this.techLevelRequired = techLevelRequired;
     }
     public String getGadgetName()
     {
          return this.name;
     }
     public int getGadgetCost()
     {
          return this.cost;
     }
     public int getGadgetUpgradeAbility()
     {
          return this.upgradeAbility;
     }
     public int getGadgetRequiredTechLevel()
     {
          return this.techLevelRequired;
     }
}
