package projectCalculatorControllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import projectCalculatorMain.ExitAlertWindow;

/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class MenuPaneController {

    private ExitAlertWindow exitAlertWindow;
    private MainPaneController mainPaneController;

    @FXML
    private void enterCostCenter() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/projectCalculatorFXML/FXMLCostCenterPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
        }
        CostCenterPaneController costCenterPaneController = loader.getController();
        costCenterPaneController.setMainPaneController(mainPaneController);
        mainPaneController.setPane(pane);
    }

    @FXML
    private void enterCalculationsCenter() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/projectCalculatorFXML/FXMLCalculationsPane.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
        }
        CalculationsPaneController calculationsPaneController = loader.getController();
        calculationsPaneController.setMainPaneController(mainPaneController);
        mainPaneController.setPane(pane);
    }

    public void programExit() {
        exitAlertWindow = new ExitAlertWindow();
        exitAlertWindow.askingQuestion();
    }

    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }
}
