package projectCalculatorControllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class MainPaneController {
    
    @FXML
    private AnchorPane mainPane;

    public void initialize() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/projectCalculatorsFXML/FXMLWelcomePane.fxml"));
        Pane welcomePane = null;
        try{
            welcomePane = loader.load();
           }catch(IOException e){
               e.printStackTrace();
            }
        mainPane.getChildren().add(welcomePane);
    }
}