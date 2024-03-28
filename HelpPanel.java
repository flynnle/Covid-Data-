
import java.net.URI;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import java.net.URL;
import javafx.event.ActionEvent;
import java.net.URISyntaxException;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.Node;

/**
 * Displays the help and information panel
 *
 * @Camille Junique K23057058, Shrishaa Pathak K22051823, 
Leila Flynn K23046238, Shankhi Sinha K23038624
 */
public class HelpPanel extends Application
{
    @FXML private Hyperlink nhslink;
    @FXML private Hyperlink covidVaccine;
    @FXML private Hyperlink testingServices;
    @FXML private Hyperlink mentalHealth;
    @FXML private Hyperlink finance;
    @FXML private Hyperlink travel;
    @FXML private Button leftButton; 
    @FXML private Button rightButton;
    /**
     * Displays the help panel
     *
     * @Camille Junique K23057058, Shrishaa Pathak K22051823, 
        Leila Flynn K23046238, Shankhi Sinha K23038624
     */
    public void start(Stage stage) throws Exception
    {
        URL url = getClass().getResource("helpPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Scene scene = new Scene(root); 
        stage.setTitle("Information"); 
        stage.setScene(scene); 
        stage.show();  
    }
    
    /**
     * Open link to Covid-19 Symptoms and What To Do
     */
    public void openNHS(ActionEvent event) throws URISyntaxException, IOException{
        URI uri = new URI("https://www.nhs.uk/conditions/covid-19/covid-19-symptoms-and-what-to-do/");
        java.awt.Desktop.getDesktop().browse(uri);
    }
    
    /**
     * Open link to Vaccine Sites In London
     */
    public void openVaccine(ActionEvent event) throws URISyntaxException, IOException{
        URI uri = new URI("https://www.england.nhs.uk/london/our-work/covid-19-vaccination-programme-2/covid-19-vaccine-sites-in-london/");
        java.awt.Desktop.getDesktop().browse(uri);
    }
    
    /**
     * Open link to Covid-19 Testing Providers
     */
    public void openTesting(ActionEvent event) throws URISyntaxException, IOException{
        URI uri = new URI("https://uk.usembassy.gov/covidtestingproviders/");
        java.awt.Desktop.getDesktop().browse(uri);
    }
    
    /**
     * Open link to Covid-19 Mental Health Services
     */
    public void openMentalHealth(ActionEvent event) throws URISyntaxException, IOException{
        URI uri = new URI("https://www.london.gov.uk/coronavirus/coronavirus-and-looking-after-your-mental-health");
        java.awt.Desktop.getDesktop().browse(uri);
    }
    
    /**
     * Open link to Covid-19 Financial Support 
     */
    public void openFinanceSupport(ActionEvent event) throws URISyntaxException, IOException{
        URI uri = new URI("https://www.london.gov.uk/coronavirus/financial-support-during-coronavirus#:~:text=For%20information%20and%20online%20advice,on%20wellbeing%20during%20coronavirus%20helpful.");
        java.awt.Desktop.getDesktop().browse(uri);
    }
    
    /**
     * Open link to Foreign Travel guidelines including lastest information on coronavirus
     */
    public void openForeignTravel(ActionEvent event) throws URISyntaxException, IOException{
        URI uri = new URI("https://www.gov.uk/foreign-travel-advice");
        java.awt.Desktop.getDesktop().browse(uri);
    }
    
    /**
     * Method to switch scenes. Linked to left arrow button
     */
    @FXML
    public void switchToStats(ActionEvent event) throws IOException{
        URL url = getClass().getResource("statsPanel.fxml"); 
        Pane root = FXMLLoader.load(url); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Statistics Panel"); 
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Method to switch scenes. Linked to right arrow button
     */
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
