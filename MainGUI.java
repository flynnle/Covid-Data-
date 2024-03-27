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
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToStats(ActionEvent event) throws java.io.IOException {
        URL url = getClass().getResource("StatsPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Statistics"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToGraph(ActionEvent event) throws java.io.IOException {
        XYChart.Series<Integer, LocalDate> series1 = graph.getSeriesOne();
        XYChart.Series<Integer, LocalDate> series2 = graph.getSeriesTwo();
        series1.setName("New deaths");
        series2.setName("New cases");
        
        data = dm.getData();
        
        for (CovidData i : data){
            series1.getData().add(new XYChart.Data(i.getNewDeaths(), dm.getStart()));
        }
        
        for (CovidData i : data){
            series2.getData().add(new XYChart.Data(i.getNewCases(), dm.getStart()));
        }
        
        BarChart bar = graph.getBarChart();
        bar.getData().addAll(series1,series2);
        
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
}
