import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import java.net.URL;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.util.Map;
import java.util.HashMap;

/**
 * Write a description of class MapPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapPanel extends Application 
{
    @FXML private Button leftArrow;
    @FXML private Button rightArrow;
    @FXML private Button ISLI;
    @FXML private Button ENFI;
    @FXML private Button BARN;
    @FXML private Button HRGY;
    @FXML private Button WALT;
    @FXML private Button HRRW;
    @FXML private Button BREN;
    @FXML private Button CAMD;
    @FXML private Button HACK;
    @FXML private Button REDB;
    @FXML private Button HAVE;
    @FXML private Button HILL;
    @FXML private Button EALI;
    @FXML private Button KENS;
    @FXML private Button WSTM;
    @FXML private Button TOWH;
    @FXML private Button NEWH;
    @FXML private Button BARK;
    @FXML private Button HOUN;
    @FXML private Button HAMM;
    @FXML private Button WAND;
    @FXML private Button CITY;
    @FXML private Button GWCH;
    @FXML private Button BEXL;
    @FXML private Button RICH;
    @FXML private Button MERT;
    @FXML private Button LAMB;
    @FXML private Button STHW;
    @FXML private Button LEWS;
    @FXML private Button KING;
    @FXML private Button SUTT;
    @FXML private Button CROY;
    @FXML private Button BROM;
    private Map<Button, String> boroughNameMap = new HashMap<>();
    
    /**
     * Constructor for objects of class MapPanel
     */
    public void initialize() {
        boroughNameMap.put(ENFI, "Enfield");
        boroughNameMap.put(BARN, "Barnet");
        boroughNameMap.put(HRGY, "Haringey");
        boroughNameMap.put(WALT, "Waltham Forest");
        boroughNameMap.put(HRRW, "Harrow");
        boroughNameMap.put(BREN, "Brent");
        boroughNameMap.put(CAMD, "Camden");
        boroughNameMap.put(ISLI, "Islington");
        boroughNameMap.put(HACK, "Hackney");
        boroughNameMap.put(REDB, "Redbridge");
        boroughNameMap.put(HAVE, "Havering");
        boroughNameMap.put(HILL, "Hillingdon");
        boroughNameMap.put(EALI, "Ealing");
        boroughNameMap.put(KENS, "Kensington and Chelsea");
        boroughNameMap.put(WSTM, "Westminster");
        boroughNameMap.put(TOWH, "Tower Hamlets");
        boroughNameMap.put(NEWH, "Newham");
        boroughNameMap.put(BARK, "Barking and Dgaenham");
        boroughNameMap.put(HOUN, "Hounslow");
        boroughNameMap.put(HAMM, "Hammersmith and Fulham");
        boroughNameMap.put(WAND, "Wandsworth");
        boroughNameMap.put(CITY, "City of London");
        boroughNameMap.put(GWCH, "Greenwich");
        boroughNameMap.put(BEXL, "Bexley");
        boroughNameMap.put(RICH, "Richmond Upon Thames");
        boroughNameMap.put(MERT, "Merton");
        boroughNameMap.put(LAMB, "Lambeth");
        boroughNameMap.put(STHW, "Southwark");
        boroughNameMap.put(LEWS, "Lewisham");
        boroughNameMap.put(KING, "Kingston Upon Thames");
        boroughNameMap.put(SUTT, "Sutton");
        boroughNameMap.put(CROY, "Croydon");
        boroughNameMap.put(BROM, "Bromley");
    }
    
    @FXML
    public void start(Stage stage) throws IOException{
            URL url = getClass().getResource("MapPanel.fxml"); 
            Pane root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
              
            stage.setTitle("Map"); 
            stage.setScene(scene); 
    
            stage.show(); 
        }
    
    @FXML
    public void switchToCovid(ActionEvent event) throws IOException{
        URL url = getClass().getResource("introPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Covid Scene"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToStats(ActionEvent event) throws IOException{
        try{
            URL url = getClass().getResource("statsPanel.fxml"); 
            Pane root = FXMLLoader.load(url); 
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //general method to create new window for boroughs
    @FXML 
    public void popupButton(ActionEvent event) {
        try {
            Button button = (Button)event.getSource();
            String borough = boroughNameMap.get(button);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("borough.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            BoroughData controller = fxmlLoader.getController();
            controller.setBoroughName(borough);
            Stage stage = new Stage();
            stage.setTitle("Borough Data");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e)
        {
            

        }


        } 
    }
