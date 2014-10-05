/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetraders1dot0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import spacetraders1dot0.model.Planet;

/**
 * FXML Controller class
 *
 * @author song
 */
public class PlanetController extends SolarSystemController implements Initializable {

    private Planet planet;
    
     /**
      * Initializes the controller class.
      */
     @Override
     public void initialize(URL url, ResourceBundle rb) {
     }     
     
         
    public void marketPlaceButtonHandler(){
        mainApp.goToScreen("Marketplace");
    }
    
     public Planet getPlanet(){
         return planet;
     }
     
}
