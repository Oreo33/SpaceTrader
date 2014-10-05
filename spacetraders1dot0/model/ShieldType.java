/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders1dot0.model;

/**
 *
 * @author Kentaro
 */
enum ShieldType {

     GODMODEHACKS("GODMODE", 1000, 5),
     PLASMA("PLASMA",100, 4),
     ION("ION", 75, 3),
     MAGNETIC("MAGNETIC", 50, 3),
     DEFLECTOR("DEFLECTOR", 25, 2),
     STEEL("STEEL", 10, 1);

    private final String shieldName;
    private final int shieldStrength;
    private final int requiredTechLevel;
    
    ShieldType(String name, int strength, int requiredTechLevel) {
        shieldName = name;
        shieldStrength = strength;
        this.requiredTechLevel = requiredTechLevel;
    }
    /**
     * Returns the shield name
     * @return returns the shield name
     */
    public String getShieldName(){
        return shieldName;
    }
    public int getShieldStrength(){
        return shieldStrength;
    }
    public int getShieldRequiredTechLevel()
    {
         return this.requiredTechLevel;
    }
}