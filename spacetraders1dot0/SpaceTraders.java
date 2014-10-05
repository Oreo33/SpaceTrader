/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders1dot0;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import spacetraders1dot0.model.Player;
import spacetraders1dot0.model.Universe;

/**
 *
 * @author Justin
 */
public class SpaceTraders extends Application {

    public Stage primaryStage;
    
    public Player player;
    
    public Universe universe;
    
    private WelcomeController welcomeController;
    private ConfigurationController configurationController;
    private UniverseController universeController;
    private SolarSystemController solarSystemController;
    private PlanetController planetController;
  
    
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        welcomeController = new WelcomeController();
        configurationController = new ConfigurationController();
        universeController = new UniverseController();
        solarSystemController = new SolarSystemController();
        planetController = new PlanetController();
        
        player = new Player();
        universe = new Universe();
        universe.createUniverse(universe.getSSCoordinates());
        goToScreen("WelcomeScreen");
        stage.show();
    }
   /**
    * Switch screens
    * @param fxml name of screen to switch to
    */
    public void goToScreen(String fxml){
        try{
            ScreenController controller = (ScreenController) replaceSceneContent("view/"+fxml+".fxml");
            controller.setMainApp(this);
        }        
        catch(Exception e){
            System.out.println("Could not load screen: " + e.getMessage());
        }
    }
    
    /**
     * loads new screen, then switches screens
     * 
     * @param fxml path to fxml file
     * @return the controller of the screen
     * @throws Exception 
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = getClass().getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(getClass().getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        ScreenController ctrl;
        switch (fxml){
            case "Welcome":
                loader.setController(welcomeController);
                break;
            case "Configuration":
                loader.setController(configurationController);
                break;
            case "Universe":
                loader.setController(universeController);
                break;
            case "SolarSystem":
                loader.setController(solarSystemController);
                break;
            case "Planet":
                loader.setController(planetController);
                break;
        }
        return loader.getController();
    }
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
