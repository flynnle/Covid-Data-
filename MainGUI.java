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

/*import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;*/

/**
 * Runs the entire program.
 *
 * @Camille Junique K23057058, Shrishaa Pathak K22051823, 
Leila Flynn K23046238, Shankhi Sinha K23038624

 */
public class MainGUI extends Application
{
    DataManipulator dm = new DataManipulator();
    IntroPanel intro = new IntroPanel();
    MapPanel map = new MapPanel();
    StatsPanel stats = new StatsPanel();
    
    
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
    private HashMap<Circle, String> circles = new HashMap<Circle, String>();
    
    private ArrayList<CovidData> data;
    
    private int statsCounter;
    private ArrayList <String> statNames = new ArrayList<>();
    private static ArrayList <Integer> statNumbers = new ArrayList<>();
    @FXML private Label statisticName;
    @FXML private Label statisticInfo;    
    

    public void initialize(){
        statNames.add("Total Deaths");
        statNames.add("Average Cases per Day");
        statNames.add("Average Transit GMR");
        statNames.add("Average Park GMR");
    }
    
    /**
     * Displays the welcome page
     */
    public void start(Stage first) throws java.io.IOException
    {
        URL url = getClass().getResource("IntroPanel.fxml");
        Pane root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        first.setTitle("Covid Data Viewer");
        first.setScene(scene);
        first.show();    
    }
    
    /**
     * Method that is called when the Go button is pressed on IntroPanel
     * Checks that the dates from the date picker is in range. If they are in range, it 
     * enables the left and right arrows to switch panels. If they are not in range or if the 
     * end date is before the start date, it displays an error message. 
     */
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
    
    /**
     * Shows previous statistic when left arrow button is clicked on the statistic panel. Loops
     * back to the last panel. 
     */
    @FXML
    public void leftStat(ActionEvent event) throws IOException{
        statsCounter = statsCounter + 1;
        if (statsCounter > 3){
            statsCounter = 0;
        }
        statisticName.setText(statNames.get(statsCounter));
        statisticInfo.setText(String.valueOf(statNumbers.get(statsCounter)));
    }
    
    /**
     * Shows next statistic when right arrow button is click on the statistic panel. Loops back
     * to the first statistic after the last one.
     */
    @FXML
    public void rightStat(ActionEvent event) throws IOException{
        statsCounter = statsCounter - 1;
        if (statsCounter < 0){
            statsCounter = 3;
        }
        statisticName.setText(statNames.get(statsCounter));
        statisticInfo.setText(String.valueOf(statNumbers.get(statsCounter)));
    }
    
    /**
     * Method that is called when the Load button is pressed on the statistics panel. It hides
     * the Load button and shows the left and right button, as well as the statistic.
     */
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
    /**
     * Switches to the map panel and colour codes each borough according to the number of 
     * deaths in each borough relative to the time period given
     */
    @FXML
    public void switchToMap(ActionEvent event) throws java.io.IOException {
        URL url = getClass().getResource("MapPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Map"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        circles.clear();
        Circle cirENFI = (Circle) root.lookup("#cirENFI");
        circles.put(cirENFI, "Enfield"); 
        Circle cirBARN = (Circle) root.lookup("#cirBARN");
        circles.put(cirBARN, "Barnet"); 
        Circle cirHRGY = (Circle) root.lookup("#cirHRGY");
        circles.put(cirHRGY, "Haringey"); 
        Circle cirWALT = (Circle) root.lookup("#cirWALT");
        circles.put(cirWALT, "Waltham Forest");         
        Circle cirHRRW = (Circle) root.lookup("#cirHRRW");
        circles.put(cirHRRW, "Harrow"); 
        Circle cirBREN = (Circle) root.lookup("#cirBREN");
        circles.put(cirBREN, "Brent"); 
        Circle cirCAMD = (Circle) root.lookup("#cirCAMD");
        circles.put(cirCAMD, "Camden"); 
        Circle cirISLI = (Circle) root.lookup("#cirISLI");
        circles.put(cirISLI, "Islington"); 
        Circle cirHACK = (Circle) root.lookup("#cirHACK");
        circles.put(cirHACK, "Hackney"); 
        Circle cirREDB = (Circle) root.lookup("#cirREDB");
        circles.put(cirREDB, "Redbridge"); 
        Circle cirHAVE= (Circle) root.lookup("#cirHAVE");
        circles.put(cirHAVE, "Havering");
        Circle cirHILL= (Circle) root.lookup("#cirHILL");
        circles.put(cirHILL, "Hillingdon");
        Circle cirEALI= (Circle) root.lookup("#cirEALI");
        circles.put(cirEALI, "Ealing");
        Circle cirKENS= (Circle) root.lookup("#cirKENS");
        circles.put(cirKENS, "Kensington and Chelsea");
        Circle cirWSTM= (Circle) root.lookup("#cirWSTM");
        circles.put(cirWSTM, "Westminster");
        Circle cirTOWH= (Circle) root.lookup("#cirTOWH");
        circles.put(cirTOWH, "Tower Hamlets");
        Circle cirNEWH= (Circle) root.lookup("#cirNEWH");
        circles.put(cirNEWH, "Newham");
        Circle cirBARK= (Circle) root.lookup("#cirBARK");
        circles.put(cirBARK, "Barking and Dagenham");
        Circle cirHOUN= (Circle) root.lookup("#cirHOUN");
        circles.put(cirHOUN, "Hounslow");
        Circle cirHAMM= (Circle) root.lookup("#cirHAMM");
        circles.put(cirHAMM, "Hammersmith and Fulham");
        Circle cirWAND= (Circle) root.lookup("#cirWAND");
        circles.put(cirWAND, "Wandsworth");
        Circle cirCITY= (Circle) root.lookup("#cirCITY");
        circles.put(cirCITY, "City of London");
        Circle cirGWCH= (Circle) root.lookup("#cirGWCH");
        circles.put(cirGWCH, "Greenwich");
        Circle cirBEXL= (Circle) root.lookup("#cirBEXL");
        circles.put(cirBEXL, "Bexley");
        Circle cirRICH= (Circle) root.lookup("#cirRICH");
        circles.put(cirRICH, "Richmond Upon Thames");
        Circle cirMERT= (Circle) root.lookup("#cirMERT");
        circles.put(cirMERT, "Merton");
        Circle cirLAMB= (Circle) root.lookup("#cirLAMB");
        circles.put(cirLAMB, "Lambeth"); 
        Circle cirSTHW= (Circle) root.lookup("#cirSTHW");
        circles.put(cirSTHW, "Southwark");;
        Circle cirLEWS= (Circle) root.lookup("#cirLEWS");
        circles.put(cirLEWS, "Lewisham");
        Circle cirKING= (Circle) root.lookup("#cirKING");
        circles.put(cirKING, "Kingston Upon Thames"); 
        Circle cirSUTT= (Circle) root.lookup("#cirSUTT");
        circles.put(cirSUTT, "Sutton");
        Circle cirCROY= (Circle) root.lookup("#cirCROY");
        circles.put(cirCROY, "Croydon");
        Circle cirBROM= (Circle) root.lookup("#cirBROM");
        circles.put(cirBROM, "Bromley");
        //System.out.println("Switching to MapPanel...");
        LocalDate start = startDate.getValue();
        LocalDate end = endDate.getValue();
        for (Map.Entry<Circle, String> entry : circles.entrySet()) {
            Circle circle = entry.getKey();
            
            String boroughName = entry.getValue();
            // Get the total deaths for the borough from your data source
            //int totalDeaths = dm.getDeaths(start, end, boroughName);  // You need to implement this method
        
            //System.out.println(totalDeaths);// Set the fill color based on the total deaths
            double ratio = dm.getDeathRatio(start, end, boroughName);
            
            //double ratio = (dm.getMaxDeaths(start, end, boroughName) - dm.getMinDeaths(start, end, boroughName));
            Color colour = getColorForTotalDeaths(ratio);
            circle.setFill(colour);
            
        }
        //map.circleName();
    
    }
    
    /**
     * 
     */
    private Color getColorForTotalDeaths(double ratio) {
    
        // Define your logic to determine the color based on the total deaths
        // For example, you can use a gradient or predefined thresholds to map total deaths to colors
        // Here's a simple example:
        if (ratio <0.025) {
            return Color.LIGHTGREEN;
        } else if (ratio < 0.035) {
            return Color.KHAKI;
        } else if (ratio < 1){
            return Color.TOMATO;
        }
        else{
            return Color.LIGHTGRAY; 
        }
        
    }
    
    /**
     * Displays statistic panel
     */
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
    
    /**
     * Displays help panel
     */
    public void switchToHelp(ActionEvent event) throws java.io.IOException {
        URL url = getClass().getResource("helpPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Information"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Displays intro page
     */
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
    
    /**
     * Calls the popupButton method in the MapPanel class when a borough button is pressed on 
     * the map panel
     */
    @FXML
    public void popupButton(ActionEvent event){
        map.popupButton(event);
    }
}
