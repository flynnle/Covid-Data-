import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import java.net.URL;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.shape.*;
import java.util.ArrayList;
import javafx.scene.paint.*;
import java.util.HashMap;

import javafx.scene.Parent;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 * Write a description of class MainGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainGUI extends Application
{
    DataManipulator dm = new DataManipulator();
    IntroPanel intro = new IntroPanel();
    MapPanel map = new MapPanel();
    StatsPanel stats = new StatsPanel();
    GraphPanel graph = new GraphPanel();
    
    @FXML private Button leftArrow;
    @FXML private Button rightArrow;
    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;
    @FXML private Button goButton;
    @FXML private Label errorLabel;
    @FXML private TableView dataTable;   
    @FXML private Button statsLoad;
    @FXML private Button statsLeftButton;
    @FXML private Button statsRightButton;
    private static boolean introPass = false;
    private ArrayList<Circle> circles = new ArrayList<Circle>();

    
    private ArrayList<CovidData> data;
    
    private HashMap<Circle, String> circleNames = new HashMap<>();
    
    private int statsCounter;
    private ArrayList <String> statNames = new ArrayList<>();
    private static ArrayList <Integer> statNumbers = new ArrayList<>();
    @FXML private Label statisticName;
    @FXML private Label statisticInfo;
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
    public void initialize(){
        statNames.add("Total Deaths");
        statNames.add("Average Cases per Day");
        statNames.add("Average Transit GMR");
        statNames.add("Average Park GMR");
    }
    
    public void start(Stage first) throws java.io.IOException
    {
        URL url = getClass().getResource("IntroPanel.fxml");
        Pane root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        first.setTitle("Covid Data Viewer");
        first.setScene(scene);
        first.show();    
    }
    
    //intro
    @FXML
    public void goMethod(){
        LocalDate start = startDate.getValue();
        LocalDate end = endDate.getValue();
        if (dm.validDate(start, end) == 0){
            introPass = true;
            leftArrow.setDisable(introPass);
            rightArrow.setDisable(introPass);
            errorLabel.setVisible(introPass);
            errorLabel.setText("put BOTH dates in silly billy");
        }else if(dm.validDate(start, end) == 1){
            introPass = false;
            leftArrow.setDisable(introPass);
            rightArrow.setDisable(introPass);
            errorLabel.setVisible(introPass); 
            errorLabel.setVisible(introPass);
            dm.filterDate(start, end); //load and select data for other classes (static list)
            
            data = dm.getData();
            statNumbers.add(dm.getTotalDeaths());
            statNumbers.add(dm.getAvgCases());
            statNumbers.add(dm.getAvgTransitGMR());
            statNumbers.add(dm.getAvgParksGMR());
            
        }else if(dm.validDate(start, end) == -1){
            introPass = true;
            leftArrow.setDisable(introPass);
            rightArrow.setDisable(introPass);
            errorLabel.setVisible(introPass);
            errorLabel.setText("put BOTH dates in silly billy");
        }else{
            introPass = true;
            leftArrow.setDisable(introPass);
            rightArrow.setDisable(introPass);
            errorLabel.setVisible(introPass);
            errorLabel.setText("set valid date dummy");
        }
    }
    
    //stats
    @FXML
    public void leftStat(ActionEvent event) throws IOException{
        statsCounter = statsCounter + 1;
        if (statsCounter > 3){
            statsCounter = 0;
        }
        statisticName.setText(statNames.get(statsCounter));
        statisticInfo.setText(String.valueOf(statNumbers.get(statsCounter)));
    }
    
    @FXML
    public void rightStat(ActionEvent event) throws IOException{
        statsCounter = statsCounter - 1;
        if (statsCounter < 0){
            statsCounter = 3;
        }
        statisticName.setText(statNames.get(statsCounter));
        statisticInfo.setText(String.valueOf(statNumbers.get(statsCounter)));
    }
    
    @FXML 
    public void statsLoading() {
        statsLoad.setVisible(false); 
        statsLeftButton.setDisable(false);
        statsLeftButton.setVisible(true);
        statsRightButton.setDisable(false);
        statsRightButton.setVisible(true);
        statisticName.setText(statNames.get(0));
        statisticInfo.setText(String.valueOf(statNumbers.get(0)));
    }
    
    //SWITCH METHODS
    @FXML
    public void switchToMap(ActionEvent event) throws java.io.IOException {
        URL url = getClass().getResource("MapPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Map"); 
        Scene scene = new Scene(root);
        /*Circle cirENFI = (Circle) root.lookup("#cirENFI");
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
        Circle cirRICH= (Circle) root.lookup("#cirRICH");
        circles.add(cirRICH);
        Circle cirMERT= (Circle) root.lookup("#cirMERT");
        circles.add(cirMERT);
         Circle cirLAMB= (Circle) root.lookup("#cirLAMB");
        circles.add(cirLAMB); 
        Circle cirSTHW= (Circle) root.lookup("#cirSTHW");
        circles.add(cirSTHW);circles.add(cirBEXL);
        Circle cirLEWS= (Circle) root.lookup("#cirLEWS");
        circles.add(cirLEWS);
         Circle cirKING= (Circle) root.lookup("#cirKING");
        circles.add(cirKING); 
        Circle cirSUTT= (Circle) root.lookup("#cirSUTT");
        circles.add(cirSUTT);circles.add(cirBEXL);
        Circle cirCROY= (Circle) root.lookup("#cirCROY");
        circles.add(cirCROY);
         Circle cirBROM= (Circle) root.lookup("#cirBROM");
        circles.add(cirBROM); */
           
        circleName();
    
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToStats(ActionEvent event) throws java.io.IOException {
        URL url = getClass().getResource("statsPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Statistics"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToGraph(ActionEvent event) throws java.io.IOException {
        //graph.initialize();
        URL url = getClass().getResource("graph.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Graph"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToIntro(ActionEvent event) throws java.io.IOException {
        URL url = getClass().getResource("IntroPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Welcome"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void popupButton(ActionEvent event){
        map.popupButton(event);
    }
    
    @FXML
    public void circleName(){
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
        
        circleNames.forEach((circle, name) ->{
           circle.setFill(Color.RED); 
        });
        
        // Change the fill color;
        /*for(Circle i : circleNames){
            i.setFill(Color.LIGHTGREEN);
            if(DataManipulator.getTotalDeaths()> 300){
                Color originalColor = Color.LIGHTGREEN;
                double darkenFactor = 0.5; // adjust this value to control darkness
                Color darkerColor = originalColor.darker();// applying the darker method multiple times for significant darkening

                // Filling the circle with the darker color
                i.setFill(darkerColor);
    
            }
        }*/
    }
}
