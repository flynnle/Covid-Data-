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
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;


public class BoroughData extends Application {
    DataManipulator dm = new DataManipulator();
    
    @FXML ChoiceBox<String> choicebox;
    @FXML Label display;
    @FXML Label borough;
    
    @FXML TableView<CovidData> dataTable;
    
    @FXML TableColumn<CovidData, String> dateColumn;
    @FXML TableColumn<CovidData, String> transitColumn;
    @FXML TableColumn<CovidData, String> newCovidColumn;
    @FXML TableColumn<CovidData, String> totalCovidColumn;
    @FXML TableColumn<CovidData, String> newDeathsColumn;
    
    private ArrayList<String> orderedBy;
    private String order;
    
    ObservableList<CovidData> covidDataList = FXCollections.observableArrayList();
    
    MapPanel mp = new MapPanel();
    
    @FXML 
    public void initialize() {
        orderedBy = new ArrayList<>();
        choicebox.getItems().addAll("Date", "Transit GMR", "New COVID cases", "Total COVID cases", "New COVID deaths");
        choicebox.setValue("Date");
        
        populate();
        
        choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) -> {
            sortColumn(newVal);
        });
        
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
    
    public void createList(String borough){
        covidDataList.clear();
        covidDataList.addAll(dm.filterBorough(borough));
    }
    
    @FXML
    public void populate(){
        dateColumn.setCellValueFactory(cellData -> {
            String date = cellData.getValue().getDate();
            return Bindings.createObjectBinding(() -> date);
        });
        
        transitColumn.setCellValueFactory(cellData -> {
            int gmr = cellData.getValue().getTransitGMR();
            return new SimpleStringProperty(Integer.toString(gmr));
        });
        
        newCovidColumn.setCellValueFactory(cellData -> {
            int newCases = cellData.getValue().getNewCases();
            return new SimpleStringProperty(Integer.toString(newCases));
        });
        
        totalCovidColumn.setCellValueFactory(cellData -> {
            int totalCases = cellData.getValue().getTotalCases();
            return new SimpleStringProperty(Integer.toString(totalCases));
        });
        
        newDeathsColumn.setCellValueFactory(cellData -> {
            int newDeaths = cellData.getValue().getNewDeaths();
            return new SimpleStringProperty(Integer.toString(newDeaths));
        });
         
        dataTable.setItems(covidDataList);
    }
    
    private void sortColumn(String name){
        ObservableList<CovidData> sortedData = dm.sortData(dataTable.getItems(), name);
        dataTable.setItems(sortedData);
    }

}
