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
 
 /*
     PoliticalSystem class is used as struct. This object will store all the possible types of governments, their 
     min and max technology level, how strong of the police force, how bad for the crime, what is the most desired 
     resource on the planet, whether people want illegal good and drug, whether people like trading, and if caught be 
     police, the percentage of bribing without running or fighting.
     */
class PoliticalSystem{
     private String politicalSystemName;
     private int minTechLevel;
     private int maxTechLevel;
     private int policeForce;
     private int crimeRate;
     private String demandResource;
     private int illegalDemand;
     private int drugDemand;
     private int traderFavor;
     private int bribeRate;
     /**
     * Creates default political system with nothing*/
     public PoliticalSystem()
     {
          politicalSystemName = "";
          minTechLevel = 0;
          maxTechLevel = 0;
          policeForce = 0;
          crimeRate = 0;
          demandResource = "";
          illegalDemand = 0;
          drugDemand = 0;
          traderFavor = 0;
          bribeRate = 0;
     }
     /**
     * Set the political system
     * @param s is the type of political system wished to use
     */
     public void setPoliticalSystemName(String s)
     {
          politicalSystemName = s;
     }
     //some government require minimum technology level, but some government will not exist if technology advanced too much
     /**
     * Set the min tech level for a type of government
     */
     public void setMinTechLevel(int n)
     {
          minTechLevel = n;
     }
     /**
     * Set the max tech level for a type of government
     */
     public void setMaxTechLevel(int n)
     {
          maxTechLevel = n;
     }
     /**
     * Set the police force amount for the government, whether strong or weak
     * strong police force always indicates less crime rate
     */
     public void setPoliceForce(int n)
     {
          policeForce = n;
     }
     /**
     * Set the crime rate for the government
     * high crime rate always implicitly indicates weak police force
     */
     public void setCrimeRate(int n)
     {
          crimeRate = n;
     }
     /*
     *set the good or resource that are most demand on this planet or under this government
     *which means this good will have a good price, and trader should look for it for business
     */
     public void setDemandResource(String s)
     {
          demandResource = s;
     }
     /**
     * Set the illegal demand for government, some government or people will not need illegal good
     * so trader will have no market in this case; if high demand, illegal good, such as firearm will 
     * make good profit.
     */
     public void setIllegalDemand(int n)
     {
          illegalDemand = n;
     }
       /**
     * Set the drug demand for government. some government or people will not trade drug
     * it is important for trader to know wheter he can make business on the planet or not
     */
     public void setDrugDemand(int n)
     {
          drugDemand = n;
     }
       /**
     * Set the trader favor for government. on some planet, people will not need to trade for good, 
     * they have everything already. So, trader will have very small market or none.
     */
     public void setTraderFavor(int n)
     {
          traderFavor = n;
     }
       /**
     * Set the bribe rate for government. If you travel and trade with illegal good or drug, police can 
     * come and get you. However, with high briberate and corrupted government, you have a chance to get
     * away form it, which means without losing goods, paying fine, and lowering reputation
     * an utopia, but under such government, crime rate usually high
     */
     public void setBribeRate(int n)
     {
          bribeRate = n;
     }
       /**
     * Get the political system for the government
     * @return the political system name
     */
     public String getPoliticalSystemName()
     {
          return     politicalSystemName;
     }
       /**
     * gets the min tech level
     * @return the min tech level
     */
     public int getMinTechLevel()
     {
          return     minTechLevel;
     }
          /**
     * gets the max tech level
     * @return the max tech level
     */
     public int getMaxTechLevel()
     {
          return maxTechLevel;
     }
          /**
     * gets the police force amount
     * @return the amount of police
     */
     public int getPoliceForce()
     {
          return policeForce;
     }
          /**
     * gets the crime rate
     * @return the crime rate level
     */
     public int getCrimeRate()
     {
          return crimeRate;
     }
          /**
     * gets the demand resource
     * @return the demanded resource
     */
     public String getDemandResource()
     {
          return demandResource;
     }
          /**
     * gets the illegal demand level
     * @return the illegal demand level
     */
     public int getIllegalDemand()
     {
         return illegalDemand;
     }
               /**
     * gets the drug demand level
     * @return the drug demand level
     */
     public int getDrugDemand()
     {
          return drugDemand;
     }
               /**
     * gets the trader favor
     * @return the trader favor
     */
     public int getTraderFavor()
     {
         return traderFavor;
     }
               /**
     * gets the bribe rate for the police
     * @return the bribe rate of the governments police
     */
     public int getBribeRate()
     {
          return bribeRate;
     }
}
public class Government {
     private final int POLITICALSYSTEMNUMBER;
     PoliticalSystem [] thePS;          //This is for all types of government system
     PoliticalSystem currentPS;         //this is for a specific one
     
      private String [] politicalSystem = 
     {
          //this information is extraced from the game description, might not be accurate
          //all the aspects will be store in the government type respectively as listed below
          //system min max police crime rare illegal drug trader bribe
          "Anarchy", "0", "6", "0", "5", "Food", "3", "3" , "0", "0",
          "Capitalist State", "5", "7", "2", "2", "Ore", "4", "4", "5", "0",
          "Communist State", "6", "7", "5", "5", "Illegal", "5", "4", "3", "5",
          "Confederacy", "7", "7", "3", "3", "Game", "3", "3", "4", "1",
          "Corporate State", "5", "7", "5", "1", "Robot", "4", "4", "4", "1",
          "Cybernetic State", "7", "7", "5", "5", "Ore", "0", "0", "4", "0",
          "Democracy", "0", "7", "3", "4", "Game", "4", "4", "5", "2",
          "Dictatorship", "0", "7", "5", "4", "Game", "3", "3", "3", "1",
          "Fascist State", "0", "7", "5", "1", "Machine", "2", "0", "1", "1",
          "Feudal State", "0", "1", "1", "5", "Firearm", "5", "4", "1", "2",
          "Military State", "4", "7", "5", "0", "Robot", "0", "0", "5", "0",
          "Monarchy", "0", "4", "4", "3", "Medicine", "2", "3", "4", "2",
          "Pacifist State", "0", "7", "1", "1", "Natural", "0", "2", "5", "0",
          "Socialist State", "0", "5", "1", "5", "Illegal", "5", "3", "3", "5",
          "State of Satori", "0", "1", "1", "0", "None", "0", "0", "0", "0",
          "Technocracy", "5", "7", "5", "1", "Water", "4", "4", "4", "3",
          "Theocracy", "0", "4", "5", "1", "Drug", "0", "5", "3", "3"
     };
    /**
     * Creates a blank government with blank political
     */
      public Government()
      {
           POLITICALSYSTEMNUMBER = 17;       //total type of governments are 17
           thePS = new PoliticalSystem[POLITICALSYSTEMNUMBER];
           currentPS = null;
      }
                /**
     * Creates the government based off techLevel
     * @param techLevel the techLevel that the government should use
     */
      public void createGovernment(int techLevel)
      {
           initialize();      //get all the possible government systems, do not know what for current planet yet
           int index = (int)(Math.random() * POLITICALSYSTEMNUMBER);
           while(true)
           {        /*random assigned government system, but restrict by technology level
                    if not matched with min and max technology level, the government will not be created
                    so the government has to meet the requirement
                    */
                if (techLevel >= thePS[index].getMinTechLevel()  && techLevel <= thePS[index].getMaxTechLevel())
                     break;
                else
                     index = (int)(Math.random() * POLITICALSYSTEMNUMBER);      //re-assign
           }
           currentPS = thePS[index];    //meet all the requirement
      }
    
      
      public String getPoliticalSystem()//Getter for political system name of the government
      {
          return currentPS.getPoliticalSystemName();
      }
      
    /**
     * The amount of police associated with this political system
     * @return the amount of police
     */
      public int getPoliceForce()
      {
           return currentPS.getPoliceForce();
      }
      
      public int getCrimeRate()//getter for crime rate of the government
      {
          return currentPS.getCrimeRate();
      }
      
      public String getDemandResource()//getter for demand resource of the government
      {
          return currentPS.getDemandResource();
      }
      
      public int getIllegalDemand()//getter for illegal demand 
      {
          return currentPS.getIllegalDemand();
      }
      
      public int getDrugDemand()//getter for derug demand level
      {
          return currentPS.getDrugDemand();
      }
      
      public int getTraderFavor()//getter for trader favor level
      {
          return currentPS.getTraderFavor();
      }
      
    /**
     * the current political systems briberate
     * @return the current political systems briberate
     */
      public int getBribeRate()
      {
           return currentPS.getBribeRate();
      }
     
     @Override
      public String toString()
      {      
           return "Political System Name: " + currentPS.getPoliticalSystemName() + "\n" +
                     "Police Force Level: " + currentPS.getPoliceForce() + "\n" +
                     "Crime Rate Level: " + currentPS.getCrimeRate() + "\n" + 
                     "Demand Resource Name: " + currentPS.getDemandResource() + "\n" + 
                     "Illegal Demand Level: " + currentPS.getIllegalDemand() + "\n" +
                     "Drug Demand Level: " + currentPS.getDrugDemand() + "\n" +
                     "Trader Favor Level: " + currentPS.getTraderFavor() + "\n" +
                     "Bribe Rate Level: " + currentPS.getBribeRate();
      }
      
      private void initialize()
      {
           //store all the characteristics for each government system from the information provided above
           //total of 17 systems, each field will be stored respectively
           for (int i = 0; i < POLITICALSYSTEMNUMBER; ++i)
           {
                int j = i * 10;
                thePS[i] = new PoliticalSystem();
                thePS[i].setPoliticalSystemName(politicalSystem[j]);
                thePS[i].setMinTechLevel(Integer.parseInt(politicalSystem[j+1]));
                thePS[i].setMaxTechLevel(Integer.parseInt(politicalSystem[j+2]));
                thePS[i].setPoliceForce(Integer.parseInt(politicalSystem[j+3]));
                thePS[i].setCrimeRate(Integer.parseInt(politicalSystem[j+4]));
                thePS[i].setDemandResource(politicalSystem[j+5]);
                thePS[i].setIllegalDemand(Integer.parseInt(politicalSystem[j+6]));
                thePS[i].setDrugDemand(Integer.parseInt(politicalSystem[j+7]));
                thePS[i].setTraderFavor(Integer.parseInt(politicalSystem[j+8]));
                thePS[i].setBribeRate(Integer.parseInt(politicalSystem[j+9]));
           }
      }
}
