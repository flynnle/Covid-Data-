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
    
    /**
     * method for go button
     */
    @FXML
    public void go(){
        start = startDate.getValue();
        end = endDate.getValue();
        
        //date validation 
        if (dm.validDate(start, end) == 0){
            valid = true; //disable button and show error message for bad dates
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
            dm.filterDate(start, end); //load and select data for other classes 
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
    
    /**
     * @return LocalDate start which is the date inside from datepicker
     */
    public LocalDate getStart(){
        return start;
    }
    
    /**
     * @return LocalDate end which is the date inside from datepicker
     */
    public LocalDate getEnd(){
        return end;
    }
    
    /**
     * @return arraylist which has been filtered by date already
     */
    public ArrayList<CovidData> getList(){
        return data;
    }
}