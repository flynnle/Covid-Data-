import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import java.net.URL;
import javafx.scene.control.Label;

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
    // instance variables - replace the example below with your own
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
    
    private static boolean introPass = false;

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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

    
    
    
    
    //SWITCH METHODS
    public void switchToMap() throws java.io.IOException {
        Stage stage = new Stage();
        map.start(stage);
    }
    
    /*public void switchToStats() throws java.io.IOException {
        Stage stage = new Stage();
        stats.start(stage);
    }*/
    
    /*public void switchToGraph() throws java.io.IOException {
        Stage stage = new Stage();
        stats.start(stage);
    }*/
    
    public void switchToIntro() throws java.io.IOException {
        Stage stage = new Stage();
        start(stage);
    }
    
    
}
