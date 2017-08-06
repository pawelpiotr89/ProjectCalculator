package projectCalculatorControllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 *
 * @author Roxven89
 */
public class WelcomePaneController {

    private MainPaneController mainPaneController;

    @FXML
    private Button confirmButton;

    @FXML
    private void loginPasswordConfirmation() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/projectCalculatorsFXML/FXMLMenuPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
        }
        MenuPaneController menuPaneController = loader.getController();
        menuPaneController.setMainPaneController(mainPaneController);
        mainPaneController.setPane(pane);
    }

    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }
}