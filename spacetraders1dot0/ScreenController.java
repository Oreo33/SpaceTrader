/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders1dot0;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Justin
 */
public abstract class ScreenController {
    SpaceTraders mainApp;
    public void setMainApp(SpaceTraders mainApp){
        this.mainApp = mainApp;
    };
    public abstract void screenChangeDialog();
}
