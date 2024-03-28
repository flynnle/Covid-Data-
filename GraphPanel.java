import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.scene.Node;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.util.ArrayList;
import java.time.LocalDate;

public class GraphPanel extends Application  {
    
    @FXML private ChoiceBox<String> graphChoice;
    @FXML private LineChart<LocalDate, Integer> lineChart;
    @FXML private Button leftButton;
    @FXML private Button rightButton;
    //private ObservableList<String> orderedBy;
    //private String order;
    
    DataManipulator dm = new DataManipulator();
    ArrayList<CovidData> data = dm.getData();
    XYChart.Series<LocalDate, Integer> seriesTotalCases = new XYChart.Series<>();
    XYChart.Series<LocalDate, Integer> seriesTotalDeaths = new XYChart.Series<>();
    
    @FXML 
    public void initialize() {
        lineChart.setTitle("Total Cases Over Time");
        lineChart.getXAxis().setLabel("Date");
        lineChart.getYAxis().setLabel("Total Cases");
        
        seriesTotalCases.setName("Total Cases");
        for (CovidData i : data){
            LocalDate date = LocalDate.parse(i.getDate());
            int totalCases = i.getTotalCases();
            seriesTotalCases.getData().add(new XYChart.Data<>(date, totalCases));
        }
        lineChart.getData().add(seriesTotalCases);
    }
    
    @FXML
    public void start(Stage stage) throws Exception{
        URL url = getClass().getResource("graph.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Scene scene = new Scene(root); 
        stage.setTitle("Graph"); 
        stage.setScene(scene);
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
    
}