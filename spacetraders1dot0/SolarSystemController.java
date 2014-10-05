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
import spacetraders1dot0.model.SolarSystem;

/**
 * FXML Controller class
 *
 * @author ju-hwanlim
 */
public class SolarSystemController extends UniverseController implements Initializable {
        
    @FXML
    Button backButton;
    
    private SolarSystem solarSystem;
    
    /**
      * Initializes the controller class.
      */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void goToPlanet(){
        mainApp.goToScreen("Planet");
    }
    
    public void goToSolarSystem(){
        mainApp.goToScreen("Universe");
    }
    public SolarSystem getSolarSystem(){
         return solarSystem;
    }
    
    
}
