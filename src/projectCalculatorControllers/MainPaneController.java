package projectCalculatorControllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class MainPaneController {
    
    @FXML
    private Pane mainPane;

    public void initialize() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/projectCalculatorsFXML/FXMLWelcomePane.fxml"));
        Pane pane = null;
        try{
            pane = loader.load();
           }catch(IOException e){
            }
        WelcomePaneController welcomePaneController = loader.getController();
        welcomePaneController.setMainPaneController(this);
        setPane(pane);
        
    }
    public void setPane(Pane pane){
        mainPane.getChildren().clear();
        mainPane.getChildren().add(pane);
    }
}