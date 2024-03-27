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
    private Map<Button, String> boroughNameMap = new HashMap<>();
    private ArrayList<Circle> circles = new ArrayList<Circle>();

    
    public MapPanel() {
        boroughNameMap = new HashMap<>();
        circles = new ArrayList<Circle>();
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
        initialize();

        Scene scene = new Scene(root);
        Circle cirENFI = (Circle) root.lookup("#cirENFI");
        circles.add(cirENFI); 
        Circle cirBARN = (Circle) root.lookup("#cirBARN");
        circles.add(cirBARN); 
        Circle cirHRGY = (Circle) root.lookup("#cirHRGY");
        circles.add(cirHRGY); 
        Circle cirWALT = (Circle) root.lookup("#cirWALT");
        circles.add(cirWALT);         
        Circle cirHRRW = (Circle) root.lookup("#cirHRRW");
        circles.add(cirHRRW); 
        Circle cirBREN = (Circle) root.lookup("#cirBREN");
        circles.add(cirBREN); 
        Circle cirCAMD = (Circle) root.lookup("#cirCAMD");
        circles.add(cirCAMD); 
        Circle cirISLI = (Circle) root.lookup("#cirISLI");
        circles.add(cirISLI); 
        Circle cirHACK = (Circle) root.lookup("#cirHACK");
        circles.add(cirHACK); 
        Circle cirREDB = (Circle) root.lookup("#cirREDB");
        circles.add(cirREDB); 
        Circle cirHAVE= (Circle) root.lookup("#cirHAVE");
        circles.add(cirHAVE);
        Circle cirHILL= (Circle) root.lookup("#cirHILL");
        circles.add(cirHILL);
        Circle cirEALI= (Circle) root.lookup("#cirEALI");
        circles.add(cirEALI);
        Circle cirKENS= (Circle) root.lookup("#cirKENS");
        circles.add(cirKENS);
        Circle cirWSTM= (Circle) root.lookup("#cirWSTM");
        circles.add(cirWSTM);
        Circle cirTOWH= (Circle) root.lookup("#cirTOWH");
        circles.add(cirTOWH);
        Circle cirNEWH= (Circle) root.lookup("#cirNEWH");
        circles.add(cirNEWH);
        Circle cirBARK= (Circle) root.lookup("#cirBARK");
        circles.add(cirBARK);
        Circle cirHOUN= (Circle) root.lookup("#cirHOUN");
        circles.add(cirHOUN);
        Circle cirHAMM= (Circle) root.lookup("#cirHAMM");
        circles.add(cirHAMM);
        Circle cirWAND= (Circle) root.lookup("#cirWAND");
        circles.add(cirWAND);
        Circle cirCITY= (Circle) root.lookup("#cirCITY");
        circles.add(cirCITY);
        Circle cirGWCH= (Circle) root.lookup("#cirGWCH");
        circles.add(cirGWCH);
        Circle cirBEXL= (Circle) root.lookup("#cirBEXL");
        circles.add(cirBEXL);


        // Change the fill color;
        for(Circle i : circles){
            i.setFill(Color.LIGHTGREEN);

            if(DataManipulator.getTotalDeaths()> 3){
                Color originalColor = Color.LIGHTGREEN;
                double darkenFactor = 0.5; // adjust this value to control darkness
                Color darkerColor = originalColor.darker().darker().darker().darker(); // applying the darker method multiple times for significant darkening

                // Filling the circle with the darker color
                i.setFill(darkerColor);

            };
        }

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

    
}