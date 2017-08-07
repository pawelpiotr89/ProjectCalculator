package projectCalculatorControllers;

import DataBase.DataBaseCenter;
import java.io.IOException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class CostCenterPaneController {

    private MainPaneController mainPaneController;
    private DataBaseCenter dataBaseCenter;

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
    private DatePicker datePickerMaterial;
    
    @FXML
    private TextField materialNameTextField;
    
    @FXML
    private ChoiceBox vatRateChoiceBox;
    
    @FXML
    private ChoiceBox unitsOfMeasureChoiceBox;
    
    @FXML
    private void initialize(){
        
        dataBaseCenter = new DataBaseCenter();
        
        datePickerMaterial.setEditable(false);
        datePickerMaterial.setShowWeekNumbers(false);
        datePickerMaterial.setValue(LocalDate.now());
        
        vatRateChoiceBox.setItems(FXCollections.observableArrayList(dataBaseCenter.getVatRateList()));
        vatRateChoiceBox.getSelectionModel().selectFirst();
       
        unitsOfMeasureChoiceBox.setItems(FXCollections.observableArrayList(dataBaseCenter.getUnitOfMeasureList()));
        unitsOfMeasureChoiceBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void onMouseReleased() {
        if(!materialCostTitledPane.isExpanded()){
            addNewMaterialCostTitledPane.setExpanded(false); 
            changeMaterialCostTitledPane.setExpanded(false);
            displayMaterialCostTitledPane.setExpanded(false);
            removeMaterialCostTitledPane.setExpanded(false);
        }
    }
    

    @FXML
    public void backToMenu() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource
        ("/projectCalculatorsFXML/FXMLMenuPane.fxml"));
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