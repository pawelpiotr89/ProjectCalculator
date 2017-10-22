package projectCalculatorControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import projectCalculatorMain.ExitAlertWindow;

/**
 *
 * @author Roxven89
 */
public class CalculationsPaneController implements Initializable {
    private ExitAlertWindow exitAlertWindow;
    private MainPaneController mainPaneController;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }
    
    public void programExit() {
        exitAlertWindow = new ExitAlertWindow();
        exitAlertWindow.askingQuestion();
    }
    
    @FXML
    private void backToMenu(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource
        ("/projectCalculatorFXML/FXMLMenuPane.fxml"));
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
}