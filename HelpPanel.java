
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

/**
 * Write a description of class HelpPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HelpPanel extends Application
{
    @FXML private Hyperlink nhslink;

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
    
    public void openNHS(ActionEvent event) throws URISyntaxException, IOException{
        URI uri = new URI("https://www.nhs.uk/conditions/covid-19/covid-19-symptoms-and-what-to-do/");
        java.awt.Desktop.getDesktop().browse(uri);
    }
}
