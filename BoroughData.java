import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import java.net.URL;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class BoroughData extends Application {
    @FXML ChoiceBox<String> choicebox;
    @FXML Label display;
    @FXML Label borough;
    private ObservableList<String> orderedBy;
    private String order;
    @FXML
    public void start(Stage stage) throws Exception{
        URL url = getClass().getResource("borough.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Scene scene = new Scene(root); 
        stage.setTitle("Borough Data"); 
        stage.setScene(scene);
        stage.show(); 
    }
    
    @FXML 
    public void initialize() {
        orderedBy = FXCollections.observableArrayList("Date", "Google Mobility Data", "New COVID cases", "Total COVID Cases", "New COVID Deaths");
        choicebox.setItems(orderedBy);
        choicebox.setValue("Date");
        order = "Date";
        display.setText(order);
        choicebox.setOnAction(event -> getOutput(event));
    }
    
    @FXML 
    public void getOutput(ActionEvent event) {
        order = choicebox.getValue();
        display.setText(order);
    }
    
    public void setBoroughName(String name) {
        borough.setText("Borough Name: " + name);
    }

}
