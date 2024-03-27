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
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.util.ArrayList;

public class BoroughData extends Application {
    @FXML ChoiceBox<String> choicebox;
    @FXML Label display;
    @FXML Label borough;
    @FXML TableView<CovidData> dataTable;
    @FXML TableColumn<CovidData, String> date;
    @FXML TableColumn<CovidData, String> googleMobilityData;
    @FXML TableColumn<CovidData, String> newCovid;
    @FXML TableColumn<CovidData, String> totalCovid;
    @FXML TableColumn<CovidData, String> totalDeaths;
    private ArrayList<String> orderedBy;
    private String order;
    MapPanel mp = new MapPanel();
    
    @FXML 
    public void initialize() {
        orderedBy = new ArrayList<>();
        orderedBy.add("Date");
        orderedBy.add("Google Mobility Data");
        orderedBy.add("New COVID cases");
        orderedBy.add("Total COVID cases");
        orderedBy.add("New COVID Cases");
        choicebox.getItems().addAll(orderedBy);
        choicebox.setValue("Date");
        dataTable.setItems(mp.populateBorough());
        //date.setCellValueFactory(CovidData -> CovidData.getValue().getDate());
    }
    
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
    public void getOutput(ActionEvent event) {
        order = choicebox.getValue();
        display.setText(order);
    }
    
    public void setBoroughName(String name) {
        borough.setText("Borough Name: " + name);
    }
    
    @FXML
    public void populate(){
    }

}
