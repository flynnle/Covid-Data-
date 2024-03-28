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
import javafx.scene.control.Label;
import javafx.scene.shape.*;
import java.util.ArrayList;
import javafx.scene.paint.*;
import javafx.collections.ObservableList;

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
    @FXML private Label borough;
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
    @FXML private Circle CirISLI;
    @FXML private Circle CirENFI;
    @FXML private Circle CirBARN;
    @FXML private Circle CirHRGY;
    @FXML private Circle CirWALT;
    @FXML private Circle CirHRRW;
    @FXML private Circle CirBREN;
    @FXML private Circle CirCAMD;
    @FXML private Circle CirHACK;
    @FXML private Circle CirREDB;
    @FXML private Circle CirHAVE;
    @FXML private Circle CirHILL;
    @FXML private Circle CirEALI;
    @FXML private Circle CirKENS;
    @FXML private Circle CirWSTM;
    @FXML private Circle CirTOWH;
    @FXML private Circle CirNEWH;
    @FXML private Circle CirBARK;
    @FXML private Circle CirHOUN;
    @FXML private Circle CirHAMM;
    @FXML private Circle CirWAND;
    @FXML private Circle CirCITY;
    @FXML private Circle CirGWCH;
    @FXML private Circle CirBEXL;
    @FXML private Circle CirRICH;
    @FXML private Circle CirMERT;
    @FXML private Circle CirLAMB;
    @FXML private Circle CirSTHW;
    @FXML private Circle CirLEWS;
    @FXML private Circle CirKING;
    @FXML private Circle CirSUTT;
    @FXML private Circle CirCROY;
    @FXML private Circle CirBROM;
    //@FXML private Circle CirENFI;
    private Map<Button, String> boroughNameMap = new HashMap<>();
    private HashMap<Circle, String> circles = new HashMap<Circle, String>();
    private HashMap<Circle, String> circleNames = new HashMap<>();
    private ObservableList<CovidData> data;
    DataManipulator dm = new DataManipulator();
    public MapPanel() {
        boroughNameMap = new HashMap<>();

        initialize();

    }

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
        boroughNameMap.put(BARK, "Barking and Dagenham");
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
        circleNames.put(CirENFI, "Enfield");
        circleNames.put(CirBARN, "Barnet");
        circleNames.put(CirHRGY, "Haringey");
        circleNames.put(CirWALT, "Waltham Forest");
        circleNames.put(CirHRRW, "Harrow");
        circleNames.put(CirBREN, "Brent");
        circleNames.put(CirCAMD, "Camden");
        circleNames.put(CirISLI, "Islington");
        circleNames.put(CirHACK, "Hackney");
        circleNames.put(CirREDB, "Redbridge");
        circleNames.put(CirHAVE, "Havering");
        circleNames.put(CirHILL, "Hillingdon");
        circleNames.put(CirEALI, "Ealing");
        circleNames.put(CirKENS, "Kensington and Chelsea");
        circleNames.put(CirWSTM, "Westminster");
        circleNames.put(CirTOWH, "Tower Hamlets");
        circleNames.put(CirNEWH, "Newham");
        circleNames.put(CirBARK, "Barking and Dgaenham");
        circleNames.put(CirHOUN, "Hounslow");
        circleNames.put(CirHAMM, "Hammersmith and Fulham");
        circleNames.put(CirWAND, "Wandsworth");
        circleNames.put(CirCITY, "City of London");
        circleNames.put(CirGWCH, "Greenwich");
        circleNames.put(CirBEXL, "Bexley");
        circleNames.put(CirRICH, "Richmond Upon Thames");
        circleNames.put(CirMERT, "Merton");
        circleNames.put(CirLAMB, "Lambeth");
        circleNames.put(CirSTHW, "Southwark");
        circleNames.put(CirLEWS, "Lewisham");
        circleNames.put(CirKING, "Kingston Upon Thames");
        circleNames.put(CirSUTT, "Sutton");
        circleNames.put(CirCROY, "Croydon");
        circleNames.put(CirBROM, "Bromley");
        
        //updateColour();
    }


    @FXML
    public void start(Stage stage) throws IOException{
        URL url = getClass().getResource("MapPanel.fxml"); 
        Pane root = FXMLLoader.load(url);
        initialize();

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
        URL url = getClass().getResource("statsPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Statistics Panel"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //general method to create new window for boroughs
    @FXML 
    public void popupButton(ActionEvent event) {
        try {
            Button button = (Button)event.getSource();
            System.out.println(button.getId());
            String borough = boroughNameMap.get(button);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("borough.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            BoroughData controller = fxmlLoader.getController();
            controller.setBoroughName(borough);
            data = dm.filterBorough(borough);
            Stage stage = new Stage();
            stage.setTitle("Borough Data");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Can't load new window");
        }
    }
    
    @FXML 
    public ObservableList<CovidData> populateBorough() {
        return data;
    }
        
    }
