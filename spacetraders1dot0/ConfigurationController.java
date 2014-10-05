/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders1dot0;

import java.net.URL;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.event.*;
import java.util.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


import spacetraders1dot0.SpaceTraders;

/**
 * FXML Controller class
 *
 * @author Justin
 */
public class ConfigurationController extends ScreenController implements Initializable {
    //FXML stuff
    @FXML
    private TextField playerName;
    
    @FXML
    private Label pointsLeftLabel;
    
    @FXML
    private TextField pilotSkill;
    @FXML
    private TextField fighterSkill;
    @FXML
    private TextField traderSkill;
    @FXML
    private TextField engineerSkill;
    @FXML
    private TextField investorSkill;
    
    @FXML
    private Button pilotInc;
    @FXML
    private Button fighterInc;
    @FXML
    private Button traderInc;
    @FXML
    private Button engineerInc;
    @FXML
    private Button investorInc;
    
    @FXML
    private Button pilotDec;
    @FXML
    private Button fighterDec;
    @FXML
    private Button traderDec;
    @FXML
    private Button engineerDec;
    @FXML
    private Button investorDec;
    
    @FXML
    private Button reset;
    
    @FXML
    private Button confirm;
    @FXML
    private Button cancel;
    
    //logistical stuff
    private int pointsLeft;
    private final int MAXPOINTS = 15;
    
/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pointsLeft = MAXPOINTS;
    }      

    /**
     * Increment player's skill level
     * 
     * @param e determines source of ActionEvent call
     */
    public void incrementSkill(ActionEvent e){
        if(pointsLeft>0){
            if(e.getSource().toString().contains("pilot")){
                pilotSkill.setText("" + (Integer.parseInt(pilotSkill.getText().toString())+1));
            }
            else if(e.getSource().toString().contains("fighter")){
                fighterSkill.setText("" + (Integer.parseInt(fighterSkill.getText().toString())+1));
            }
            else if(e.getSource().toString().contains("trader")){
                traderSkill.setText("" + (Integer.parseInt(traderSkill.getText().toString())+1));
            }
            else if(e.getSource().toString().contains("engineer")){
                engineerSkill.setText("" + (Integer.parseInt(engineerSkill.getText().toString())+1));
            }
            else if(e.getSource().toString().contains("investor")){
                investorSkill.setText("" + (Integer.parseInt(investorSkill.getText().toString())+1));
            }
            pointsLeft -= 1;
            pointsLeftLabel.setText("" + pointsLeft);
        }
    }
    
    /**
     * Increment player's skill level
     * 
     * @param e determines source of ActionEvent call
     */
    public void decrementSkill(ActionEvent e){
        if(pointsLeft<MAXPOINTS){
            if(Integer.parseInt(pilotSkill.getText()) > 0 && e.getSource().toString().contains("pilot")){

                pilotSkill.setText("" + (Integer.parseInt(pilotSkill.getText().toString())-1));
                pointsLeft += 1;
            }
            else if(Integer.parseInt(fighterSkill.getText()) > 0 && e.getSource().toString().contains("fighter")){

                fighterSkill.setText("" + (Integer.parseInt(fighterSkill.getText().toString())-1));
                pointsLeft += 1;
            }
            else if(Integer.parseInt(traderSkill.getText()) > 0 && e.getSource().toString().contains("trader")){
                traderSkill.setText("" + (Integer.parseInt(traderSkill.getText().toString())-1));
                pointsLeft += 1;
            }
            else if(Integer.parseInt(engineerSkill.getText()) > 0 && e.getSource().toString().contains("engineer")){
                engineerSkill.setText("" + (Integer.parseInt(engineerSkill.getText().toString())-1));
                pointsLeft += 1;
            }
            else if(Integer.parseInt(investorSkill.getText()) > 0 && e.getSource().toString().contains("investor")){
                investorSkill.setText("" + (Integer.parseInt(investorSkill.getText().toString())-1));
                pointsLeft += 1;
            }
            pointsLeftLabel.setText("" + pointsLeft);
        }
    }
    
    /**
     * Set all skill levels to 0
     * Sets skill points available to MAXPOINTS
     * 
     * @param e determines source of ActionEvent call
     */
    public void resetHandler(ActionEvent event){
        pilotSkill.setText("0");
        fighterSkill.setText("0");
        traderSkill.setText("0");
        engineerSkill.setText("0");
        investorSkill.setText("0");
        pointsLeft = MAXPOINTS;
        pointsLeftLabel.setText(""+MAXPOINTS);
        
    }
    
    /**
     * Confirm skill levels
     * Change screen to Universe view
     * 
     * @param event determines source of ActionEvent call
     */
    public void confirmHandler(ActionEvent event){
         confirmPlayerSetting();
         mainApp.goToScreen("Universe");
    }
    
    /**
     * Confirm and save skill levels
     * 
     */
    public void confirmPlayerSetting(){
        mainApp.player.setPlayerName(playerName.getText());
        mainApp.player.allocatePlayerSkill(Integer.parseInt(pilotSkill.getText()), 0);
        mainApp.player.allocatePlayerSkill(Integer.parseInt(fighterSkill.getText()), 1);
        mainApp.player.allocatePlayerSkill(Integer.parseInt(traderSkill.getText()), 2);
        mainApp.player.allocatePlayerSkill(Integer.parseInt(engineerSkill.getText()), 3);
        mainApp.player.allocatePlayerSkill(Integer.parseInt(investorSkill.getText()), 4);
    }

    /**
     * Cancel actions
     * Return to welcome screen
     * 
     * @param e determines source of ActionEvent call
     */
    public void cancelHandler(ActionEvent event){
        System.out.print(mainApp.toString());
        mainApp.goToScreen("WelcomeScreen");
    }
    
    public void screenChangeDialog(){
        
    }
}//eof
