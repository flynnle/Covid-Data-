import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.scene.Node;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;

public class GraphPanel extends Application {
    
    @FXML private ChoiceBox<String> graphChoice;
    @FXML private Button leftButton;
    @FXML private Button rightButton;
    private ObservableList<String> orderedBy;
    private String order;
    
    @FXML 
    public void initialize() {
        orderedBy = FXCollections.observableArrayList("Date", "Google Mobility Data", "New COVID cases", "Total COVID Cases", "New COVID Deaths");
        graphChoice.setItems(orderedBy);
        graphChoice.setValue("Date");
    }
    
    @FXML
    public void start(Stage stage) throws Exception{
        URL url = getClass().getResource("graphPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Scene scene = new Scene(root); 
        stage.setTitle("Graph"); 
        stage.setScene(scene);
        stage.show(); 
    }
    
    @FXML
    public void switchToStats(ActionEvent event) throws IOException{
        URL url = getClass().getResource("statistics.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Statistics"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToCovid(ActionEvent event) throws IOException{
        URL url = getClass().getResource("covidScene.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Covid Scene"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}