/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetraders1dot0;

import java.awt.ItemSelectable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.event.*;
import java.util.*;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import spacetraders1dot0.model.CargoSlot;
import spacetraders1dot0.model.Item;
import spacetraders1dot0.model.Marketplace;
import spacetraders1dot0.model.Planet;

/**
 * FXML Controller class
 *
 * @author Justin
 */
public class MarketplaceController extends PlanetController implements Initializable {
    @FXML
    ArrayList<Label> itemLabels;
    @FXML
    ArrayList<Label> cargoLabels;
    @FXML
    Button buy;
    
    private Planet planet;
    private Marketplace marketplace;
    private HashMap<Item,Integer> inventory;
    private Set<Item> items;
    private Collection<Integer> prices;
 
    private HashMap<String, Integer> cargoHold;
    private Set<String> cargoItems;
    private Collection<CargoSlot> cargoQuantities;
    private ArrayList<String> quantityList = new ArrayList();
    private HashMap<String, Integer> currentCargo = new HashMap();
//    private Collection<Integer> cargoQuantities;
    
    private final int SCREENTOP = 50;
    private int labelHeight;
    private final int LABELWIDTH = 400;
    
    @FXML
    private Label playerInfo;
    @FXML
    private Button backButton;
    
    
    public  EventHandler buyItemClick;
    public EventHandler sellItemClick;
    private boolean mainAppSet;
    
    //demo purposes
    @FXML
    private Button cheatButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemLabels = new ArrayList<Label>();
        cargoLabels = new ArrayList<Label>();
        mainAppSet = false;
        buyItemClick  = new EventHandler() {
            //buyhandler
            @Override
            public void handle(Event t) {
                String labelText = ((Label)t.getSource()).getText();
                String itemName = labelText.substring(0,labelText.indexOf(' '));
                String priceAndQuantity = labelText.substring(labelText.indexOf("$"));
                String price = priceAndQuantity.substring(1,priceAndQuantity.indexOf(' '));
                String quantity = priceAndQuantity.substring(priceAndQuantity.lastIndexOf(' ')+1);
                if(marketplace.getItemKey(itemName).getQuantity()>0 
                        && mainApp.player.canBuy(Integer.parseInt(price))){
                    mainApp.player.buyItem(itemName, Integer.parseInt(price));
                    marketplace.getItemKey(itemName).changeQuantity(false);
                    updateScreen();
                }
            }
        };
        
        sellItemClick= new EventHandler(){
            @Override
            public void handle(Event t){
                String labelText = ((Label)t.getSource()).getText();
                String itemName = labelText.substring(0,labelText.indexOf(' '));
                String quantity = labelText.substring(labelText.lastIndexOf(' ')+1);
                
                //mainApp.player.sellItem(itemName,marketplace.getItem(itemName));
                mainApp.player.sellItem(itemName, marketplace.getItemPrice(itemName));
                updateScreen();
            }
        };
    }    
    /**
     * Required because initialize is called before setMainApp is called
     */
    public void afterSetMainApp(){
        if(!mainAppSet){
            mainAppSet = true;
            marketInit();
            cargoInit();
            initScreen();
        }
    }
    /**
     * Helper for init, extracts information from marketplace and creates labels
     */
    private void marketInit(){
        marketplace = new Marketplace(mainApp.universe.getSolarSystem()[0].getPlanet()[0]);       
        inventory = marketplace.getInventory();
        items = inventory.keySet();
        prices = inventory.values();
        createMarketLabels();
    }
    
    /**
     * Helper for updatescreen and init, updates market's labels
     */
    private void createMarketLabels(){
        itemLabels.clear();
        Iterator itemsIterator = items.iterator();
        Iterator priceIterator = prices.iterator();
        Item tempItem = null;
        while(itemsIterator.hasNext()){       
            tempItem = (Item)(itemsIterator.next());
           itemLabels.add(new Label(appendLabel(tempItem.getName(),""+priceIterator.next(),""+tempItem.getQuantity())));
        }   
    }
    /**
     * Helper for init, extracts information from spaceShip and creates labels
     */
    private void cargoInit(){      
       cargoItems = mainApp.player.spaceShip.getCargo().cargoGoods().keySet();
        //this is broken
        cargoQuantities = mainApp.player.spaceShip.getCargo().cargoGoods().values();
        createCargoLabels();
    }
    
    /**
     * Helper for updateScreen and init, updates the cargoLabels
     */
    private void createCargoLabels(){
        cargoLabels.clear();
       Iterator itemsIterator = cargoItems.iterator();
       Iterator quantitiesIterator = cargoQuantities.iterator();        
       
        while(itemsIterator.hasNext()){           
           cargoLabels.add(new Label(appendLabel((String)itemsIterator.next(),"",""+((CargoSlot)quantitiesIterator.next()).currentSlotItemQuantity())));
        }

    }
    
    /**
     * Helper to standardize/format item names
     * @param text the item name
     * @param num the item price or quantity
     * @return the appended item name
     */
    private String appendLabel(String text, String price, String quantity){
        int labelLength = (price.equals("")) ? 18 : 25;
        String output = text;
        while(output.length()<labelLength){
            if(output.length()==17){
                if(!(price.equals(""))){
                    output+="$";
                }
                output+=price;
            }
            output+=" ";
        }
        output += "x" + quantity;
        return output;
    }
    
    /**
     * Helper for init, adds labels to pane and sets scene
     */
    private void initScreen(){
        AnchorPane marketPane = new AnchorPane();
        marketPane.relocate(0,0);
        marketPane.setStyle("-fx-background-color: black;");
        marketPane.getStylesheets().add(getClass().getResource("view/general.css").toExternalForm());

        
        labelHeight=((int)(mainApp.primaryStage.getHeight())-SCREENTOP)/itemLabels.size();
        for(int ii=0;ii<itemLabels.size();ii++){
            itemLabels.get(ii).setMaxHeight(labelHeight);
            itemLabels.get(ii).relocate(30, ii*labelHeight+ SCREENTOP);  
            itemLabels.get(ii).setOnMouseClicked(buyItemClick);
            marketPane.getChildren().add(itemLabels.get(ii));
        }
        
        if(cargoLabels.size()>0){//check for 0
            labelHeight=((int)(mainApp.primaryStage.getHeight())-SCREENTOP)/cargoLabels.size();

            for(int ii=0;ii<cargoLabels.size();ii++){
                cargoLabels.get(ii).setMaxHeight(labelHeight);
                cargoLabels.get(ii).relocate(LABELWIDTH, ii*labelHeight + SCREENTOP);  
                cargoLabels.get(ii).setOnMouseClicked(sellItemClick);
                marketPane.getChildren().add(cargoLabels.get(ii));
            }
        }
        playerInfo.setText(updatePlayerInfo());
        marketPane.getChildren().add(playerInfo);
        marketPane.getChildren().add(backButton);
        Scene marketScene = new Scene(marketPane,600,400);
        mainApp.primaryStage.setScene(marketScene);

    }
    
    /**
     * Updates screen with marketplace/cargo items and playerinfo
     */
    private void updateScreen(){
        AnchorPane anchor = (AnchorPane) (mainApp.primaryStage.getScene().getRoot());
        anchor.getChildren().clear();
        createMarketLabels();
        createCargoLabels();
        playerInfo.setText(updatePlayerInfo());
        labelHeight=((int)(mainApp.primaryStage.getHeight())-SCREENTOP)/itemLabels.size();
        for(int ii=0;ii<itemLabels.size();ii++){
            itemLabels.get(ii).setMaxHeight(labelHeight);
            itemLabels.get(ii).relocate(30, ii*labelHeight + SCREENTOP);  
            itemLabels.get(ii).setOnMouseClicked(buyItemClick);
            anchor.getChildren().add(itemLabels.get(ii));
        }
        
        if(cargoLabels.size()>0){//check for 0
            labelHeight=((int)(mainApp.primaryStage.getHeight())-SCREENTOP)/cargoLabels.size();
            for(int ii=0;ii<cargoLabels.size();ii++){
                cargoLabels.get(ii).setMaxHeight(labelHeight);
                cargoLabels.get(ii).relocate(LABELWIDTH, ii*labelHeight + SCREENTOP);  
                cargoLabels.get(ii).setOnMouseClicked(sellItemClick);
                anchor.getChildren().add(cargoLabels.get(ii));
            }
        }
        anchor.getChildren().add(playerInfo);
        anchor.getChildren().add(backButton);
        //demo purposes
        anchor.getChildren().add(cheatButton);

    }
    
    /**
     * Helper method for update - updates player info label
     * @return String with player info
     */
    private String updatePlayerInfo(){
        String out = "";
        out += "Slots Available: " +(mainApp.player.spaceShip.availableCargoSlots());
        out += "    $"+mainApp.player.getPlayerCurrency();
        return out;
    }
/**
 * creates buy dialog
 */
    public void buyHandler(){
        final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(mainApp.primaryStage);
                AnchorPane dialogPane = new AnchorPane();
                dialogPane.setStyle("-fx-background-color: black;");
                dialogPane.getStylesheets().add(getClass().getResource("view/general.css").toExternalForm());
                
                Label buyLabel = new Label("How many do you want to buy?");
                buyLabel.setStyle("-fx-font-size: 15px");
                buyLabel.relocate(50, 100);
                dialogPane.getChildren().add(buyLabel);
                
                Button increaseButton = new Button("+");
                increaseButton.relocate(50, 110);
                dialogPane.getChildren().add(increaseButton);
                
                Button decreaseButton = new Button("-");
                decreaseButton.relocate(90, 110);
                dialogPane.getChildren().add(decreaseButton); 
                
                Scene dialogScene = new Scene(dialogPane, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
    }
    
    /**
     * Goes back to planet screen
     */
    public void backButtonHandler(){
        mainApp.goToScreen("Planet");
    }
    
    /**
     * for demo purposes only, adds money
     */
    public void cheat(){
        mainApp.player.updatePlayerCurrent(1000);
    }
    
}
