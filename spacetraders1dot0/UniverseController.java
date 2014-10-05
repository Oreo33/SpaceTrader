/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders1dot0;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import spacetraders1dot0.model.Universe;

/**
 * FXML Controller class
 *
 * @author song
 */
public class UniverseController extends ScreenController implements Initializable {

     @FXML
     private ImageView ssImage0;
     @FXML
     private ImageView ssImage1;
     @FXML
     private ImageView ssImage2;
     @FXML               
     private ImageView ssImage3;
     @FXML
     private ImageView ssImage4;
     @FXML     
     private ImageView ssImage5;     
     @FXML
     private ImageView ssImage6;            
     @FXML
     private ImageView ssImage7;
      @FXML    
     private ImageView ssImage8;
      @FXML    
     private ImageView ssImage9;    
     
      
     private boolean mainAppSet; 
     /**
     * Initializes Controller class
     * 
     * @param e determines source of ActionEvent call
     */
     @Override
     public void initialize(URL url, ResourceBundle rb) {
         mainAppSet = false;
     }
     
     /**
      * Real initialization, since setMainApp is called after the controller has been initialized,
      * and setMainApp is necessary to initialize.
      */
     public void afterSetMainApp(){
         if(!mainAppSet){
             mainAppSet=true;
             int[][] ssCoordinates = mainApp.universe.getSSCoordinates();
             ssImage0.relocate(ssCoordinates[0][0],ssCoordinates[0][1]);
             ssImage1.relocate(ssCoordinates[1][0],ssCoordinates[1][1]);
             ssImage2.relocate(ssCoordinates[2][0],ssCoordinates[2][1]);
             ssImage3.relocate(ssCoordinates[3][0],ssCoordinates[3][1]);
             ssImage4.relocate(ssCoordinates[4][0],ssCoordinates[4][1]);
             ssImage5.relocate(ssCoordinates[5][0],ssCoordinates[5][1]);
             ssImage6.relocate(ssCoordinates[6][0],ssCoordinates[6][1]);
             ssImage7.relocate(ssCoordinates[7][0],ssCoordinates[7][1]);
             ssImage8.relocate(ssCoordinates[8][0],ssCoordinates[8][1]);
             ssImage9.relocate(ssCoordinates[9][0],ssCoordinates[9][1]);
         }
     }
     
    /**
     * Switch to a planet screen when one solar system is selected
     * 
     */
    @FXML
    public void loadSolarSystemHandler()
    {
         mainApp.goToScreen("SolarSystem");
    }                  

    public void screenChangeDialog(){
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(mainApp.primaryStage);
        AnchorPane dialogPane = new AnchorPane();
        dialogPane.setStyle("-fx-background-color: black;");
        dialogPane.getStylesheets().add(getClass().getResource("view/general.css").toExternalForm());

        Scene dialogScene = new Scene(dialogPane, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
