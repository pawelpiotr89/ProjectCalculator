package projectCalculatorControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import projectCalculatorMain.ProgramSettings;

/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class OptionsPaneController implements Initializable {
    
    private MainPaneController mainPaneController;
    private final ProgramSettings settings = new ProgramSettings();

    @FXML
    private Button backToMenuButton;
    
    @FXML
    private Pane optionsPane;
    
    @FXML
    private TextField currentPathLabel;
    
    @FXML
    private AnchorPane backPane;
    
    @FXML
    private AnchorPane mainPane;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backPane.maxHeightProperty().bind(backPane.heightProperty().multiply(0.9));
        mainPane.minHeightProperty().bind(mainPane.heightProperty().multiply(0.9));
        settings.createProperties();
        currentPathLabel.setText(settings.getPath());
    }
    
    @FXML
    private void backToMenu(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/projectCalculatorFXML/FXMLMenuPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException error) {
            System.out.println(error);
        }
        MenuPaneController menuPaneController = loader.getController();
        menuPaneController.setMainPaneController(mainPaneController);
        mainPaneController.setPane(pane);
    }
  
    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }      
}