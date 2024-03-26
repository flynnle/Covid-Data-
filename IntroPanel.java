import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.net.URL;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import java.awt.event.MouseEvent;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import java.time.Duration;
import javafx.scene.Node;
import java.io.IOException;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class IntroPanel extends Application
{
    /**
     * Constructor for objects of class SceneGUI
     */
    
    @FXML private Button leftArrow;
    @FXML private Button rightArrow;
    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;
    @FXML private Button goButton;
    @FXML private Label errorLabel;
    
    @FXML private Label statisticName; 
    @FXML private Label statisticInfo; 
    
    private static LocalDate start;
    private static LocalDate end;
    private DataManipulator dm = new DataManipulator();
    private static ArrayList data = new ArrayList<>();
    
    private static boolean valid = false;
    
    //MapPanel map = new MapPanel();
    //StatsPanel stats = new StatsPanel();
    
    @FXML
    public void start(Stage stage) throws Exception{
        URL url = getClass().getResource("IntroPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Scene scene = new Scene(root); 
        stage.setTitle("Covid Scene"); 
        stage.setScene(scene); 
        stage.show();  
    }
    
    @FXML
    public void go(){
        start = startDate.getValue();
        end = endDate.getValue();
        if (dm.validDate(start, end) == 0){
            valid = true;
            leftArrow.setDisable(valid);
            rightArrow.setDisable(valid);
            errorLabel.setVisible(valid);
            errorLabel.setText("put BOTH dates in silly billy");
        }else if(dm.validDate(start, end) == 1){
            valid = false;
            leftArrow.setDisable(valid);
            rightArrow.setDisable(valid);
            errorLabel.setVisible(valid); 
            errorLabel.setVisible(valid);
            dm.filterDate(start, end); //load and select data for other classes (static list)
        }else if(dm.validDate(start, end) == -1){
            valid = false;
            leftArrow.setDisable(valid);
            rightArrow.setDisable(valid);
            errorLabel.setVisible(valid);
            errorLabel.setText("put BOTH dates in silly billy");
        }else{
            valid = true;
            leftArrow.setDisable(valid);
            rightArrow.setDisable(valid);
            errorLabel.setVisible(valid);
            errorLabel.setText("set valid date dummy");
        }
    }
    
    public LocalDate getStart(){
        return start;
    }
    
    public LocalDate getEnd(){
        return end;
    }
    
    public ArrayList<CovidData> getList(){
        return data;
    }
    
    @FXML
    public void switchToMap(ActionEvent event) throws IOException{
        URL url = getClass().getResource("map.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Map"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**@FXML
    public void switchToStats(ActionEvent event) throws IOException{
        URL url = getClass().getResource("statisticsPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Statistics"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }**/
    
    @FXML
    public void switchToGraph(ActionEvent event) throws IOException{
        URL url = getClass().getResource("graphPanel.fxml");
        Pane root = FXMLLoader.load(url);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Graph"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //statisticName.setText("Total Deaths");
        //statisticInfo.setText(String.valueOf(dm.getTotalDeaths(data)));
    }
}