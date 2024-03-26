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

import javafx.scene.Parent;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

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
    
    private static boolean introPass = false;
    
    private ArrayList<CovidData> data;
    
    private int statsCounter;
    private ArrayList <String> statNames = new ArrayList<>();
    private ArrayList <Integer> statNumbers = new ArrayList<>();
    @FXML private Label statisticName;
    @FXML private Label statisticInfo;

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
    
    
    //SWITCH METHODS
    @FXML
    public void switchToMap() throws java.io.IOException {
        Stage stage = new Stage();
        map.start(stage);
    }
    
    @FXML
    public void switchToStats() throws java.io.IOException {
        Stage stage = new Stage();
        stats.start(stage);
    }
    
    public void switchToGraph() throws java.io.IOException {
        Stage stage = new Stage();
        stats.start(stage);
    }
    
    @FXML
    public void switchToIntro() throws java.io.IOException {
        Stage stage = new Stage();
        start(stage);
    }
    
    @FXML 
    public void popupButton(ActionEvent event) {
        map.popupButton(event);
    }
    
}
