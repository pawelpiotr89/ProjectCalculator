package projectCalculatorControllers;

import projectCalculatorMain.SingleCalculationStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import projectCalculatorMain.ExitAlertWindow;
import projectCalculatorMain.PreCalculationData;

/**
 *
 * @author Roxven89
 */
public class CalculationsPaneController implements Initializable {

    private ExitAlertWindow exitAlertWindow;
    private MainPaneController mainPaneController;
    private SingleCalculationStage singleCalculationStage;
    private PreCalculationData preCalculationData;

    @FXML
    private Button startCalculationButton;
    @FXML
    private Pane calculationsPane;
    @FXML
    private SplitPane costCenterSplitPane;
    @FXML
    private Button backFromCostCenterToMenuButton;
    @FXML
    private TextField calculatingPersonNameTextField;
    @FXML
    private Button addPersonButton;
    @FXML
    private Label addPersonLabel;
    @FXML
    private TextField projectTypeTextField;
    @FXML
    private Button addProjectButton;
    @FXML
    private Label addProjectTypeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        startCalculationButton.setDisable(SingleCalculationStage.getStartCalculationButtonState());

        backFromCostCenterToMenuButton.setDisable(false);
        
        preCalculationData = new PreCalculationData();
    }

    @FXML
    public void startCalculationOnAction() throws IOException {
        singleCalculationStage = new SingleCalculationStage(startCalculationButton);
        SingleCalculationStage.setStartCalculationButtonState(true);
        startCalculationButton.setDisable(SingleCalculationStage.getStartCalculationButtonState());
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
    
    @FXML
    private void standardTextFieldActions(KeyEvent event) {
        preCalculationData.standardTextFieldActions(event);
    }
   
    @FXML
    private void addPersonAction(ActionEvent event) {
        preCalculationData.addPersonToDataBase(event, calculatingPersonNameTextField, addPersonLabel);
    }
    
    @FXML
    private void addProjectAction(ActionEvent event) {
        preCalculationData.addProjectTypeToDataBase(event, projectTypeTextField, addProjectTypeLabel);
    }

    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }

    public void programExit() {
        exitAlertWindow = new ExitAlertWindow();
        exitAlertWindow.askingQuestion();
    }

}