import javafx.scene.layout.Pane;
import java.net.URL;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * Write a description of class SceneGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StatsPanel extends Application
{
    ArrayList<CovidData> data = new ArrayList<>();
    DataManipulator dm = new DataManipulator();

    @FXML private Label statisticName;
    @FXML private Label statisticInfo;
    @FXML private Button statsRightButton;
    @FXML private Button statsLeftButton;
    @FXML private Button leftButton;
    @FXML private Button rightButton;
    
    private int statsCounter;
    
    private ArrayList <String> statNames = new ArrayList<>();
    private ArrayList <Integer> statNumbers = new ArrayList<>();
    
    @FXML
    public void start(Stage stage){
        try{
            URL url = getClass().getResource("statsPanel.fxml"); 
            Pane root = FXMLLoader.load(url); 
        
            Scene scene = new Scene(root);
        
            stage.setTitle("Statistics"); 
            stage.setScene(scene);
            stage.show();
            
            statNames.add("Total Deaths");
            statNames.add("Average Cases per Day");
            statNames.add("Average Transit GMR");
            statNames.add("Average Park GMR");
            
            try{
                statNumbers.add(dm.getTotalDeaths());
                statNumbers.add(dm.getAvgCases());
                statNumbers.add(dm.getAvgTransitGMR());
                statNumbers.add(dm.getAvgParksGMR());
            }
            catch(ArithmeticException ae){
                statisticInfo.setText("No available data");
            }
            statisticName.setText(statNames.get(0));
            statisticInfo.setText(String.valueOf(statNumbers.get(0)));
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
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
}