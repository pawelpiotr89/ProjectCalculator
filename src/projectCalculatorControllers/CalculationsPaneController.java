package projectCalculatorControllers;

import projectCalculatorMain.SingleCalculationStage;
import DataBase.DataBaseCalculations;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import projectCalculatorMain.ExitAlertWindow;
/**
 *
 * @author Roxven89
 */
public class CalculationsPaneController implements Initializable {
    
    private ExitAlertWindow exitAlertWindow;
    private MainPaneController mainPaneController;
    private DataBaseCalculations dataBaseCalculations;
    private SingleCalculationStage singleCalculationStage;
    
    @FXML
    private ChoiceBox projectTypeChoiceBox;
    @FXML
    private ChoiceBox companyAsChoiceBox;
    @FXML
    private Button startCalculationButton;
    @FXML
    private Pane calculationsPane;
    @FXML
    private SplitPane costCenterSplitPane;
    @FXML
    private Button backFromCostCenterToMenuButton;
    @FXML
    private ChoiceBox<?> customerChoiceBox;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        startCalculationButton.setDisable(SingleCalculationStage.getStartCalculationButtonState());
        
        dataBaseCalculations = new DataBaseCalculations();
       
        projectTypeChoiceBox.setItems(dataBaseCalculations.getProjectsList());
        projectTypeChoiceBox.getSelectionModel().selectFirst();
        
        companyAsChoiceBox.setItems(dataBaseCalculations.getCompanyAs());
        companyAsChoiceBox.getSelectionModel().selectFirst();
        
        backFromCostCenterToMenuButton.setDisable(false);   
    }
    
    @FXML
    public void startCalculationOnAction() throws IOException{
        singleCalculationStage = new SingleCalculationStage(startCalculationButton);
        SingleCalculationStage.setStartCalculationButtonState(true);
        startCalculationButton.setDisable(SingleCalculationStage.getStartCalculationButtonState());
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
    
    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }
    
    public void programExit() {
        exitAlertWindow = new ExitAlertWindow();
        exitAlertWindow.askingQuestion();
    }
}