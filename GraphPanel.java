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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import java.util.ArrayList;

public class GraphPanel extends Application  {
    
    @FXML private ChoiceBox<String> graphChoice;
    @FXML private BarChart<Integer, Integer>  barChart;
    @FXML private Button leftButton;
    @FXML private Button rightButton;
    private ObservableList<String> orderedBy;
    private String order;
    
    DataManipulator dm = new DataManipulator();
    ArrayList<CovidData> data = dm.getData();
    
    @FXML 
    public void initialize() {
        int total = 0;
        orderedBy = FXCollections.observableArrayList("Date", "Google Mobility Data", "New COVID cases", "Total COVID Cases", "New COVID Deaths");
        graphChoice.setItems(orderedBy);
        graphChoice.setValue("Date");
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Trends");
        
        for (CovidData i : data){
            series1.getData().add(new XYChart.Data(i.getNewDeaths(), dm.getStart()));
        }
        
    }
    
    @FXML
    public void start(Stage stage) throws Exception{
        URL url = getClass().getResource("graph.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Scene scene = new Scene(root); 
        stage.setTitle("Graph"); 
        stage.setScene(scene);
        stage.show(); 
    }
    
    @FXML
    public void switchToStats(ActionEvent event) throws IOException{
        URL url = getClass().getResource("statsPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Statistics"); 
        Scene scene = new Scene(root);
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
}