/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders1dot0;

import java.io.IOException;
import java.net.URL;

import javafx.scene.control.*;
import javafx.fxml.*;
import javafx.event.*;
import java.util.*;
import javafx.scene.layout.*;

/**
 *
 * @author Justin
 */
public class WelcomeController extends ScreenController implements Initializable {
    @FXML
    private Label status;
    
    @FXML
    private Button newGame;
    
    @FXML
    private Button loadGame;

    @FXML
    private void newGameHandler (ActionEvent event) throws IOException{
        status.setText("Starting new game...");
        mainApp.goToScreen("ConfigurationScreen");
    }
    
        
    @FXML
    private void loadGameHandler(ActionEvent event){
        status.setText(("Loading game..."));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void screenChangeDialog(){
        
    }
}
