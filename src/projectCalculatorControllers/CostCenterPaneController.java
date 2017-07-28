package projectCalculatorControllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class CostCenterPaneController {

    private MainPaneController mainPaneController;

    @FXML
    private TitledPane materialCostTitledPane;

    @FXML
    private TitledPane subconstructorsCostTitledPane;

    @FXML
    private TitledPane labourCostTitledPane;

    @FXML
    private TitledPane logisticCostTitledPane;

    @FXML
    private TitledPane otherCostTitledPane;

    @FXML
    private TitledPane addNewMaterialCostTitledPane;

    @FXML
    private TitledPane changeMaterialCostTitledPane;

    @FXML
    private TitledPane displayMaterialCostTitledPane;

    @FXML
    private TitledPane removeMaterialCostTitledPane;

    @FXML
    private void onMouseReleased() {
        if (addNewMaterialCostTitledPane.isExpanded()
                || changeMaterialCostTitledPane.isExpanded()
                || displayMaterialCostTitledPane.isExpanded()
                || removeMaterialCostTitledPane.isExpanded()) {
            materialCostTitledPane.setCollapsible(false);
            subconstructorsCostTitledPane.setCollapsible(false);
            labourCostTitledPane.setCollapsible(false);
            logisticCostTitledPane.setCollapsible(false);
            otherCostTitledPane.setCollapsible(false);
        } else {
            materialCostTitledPane.setCollapsible(true);
            subconstructorsCostTitledPane.setCollapsible(true);
            labourCostTitledPane.setCollapsible(true);
            logisticCostTitledPane.setCollapsible(true);
            otherCostTitledPane.setCollapsible(true);
        }
    }

    @FXML
    public void backToMenu() {
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
