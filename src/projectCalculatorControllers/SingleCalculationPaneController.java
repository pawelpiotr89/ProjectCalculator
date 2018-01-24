package projectCalculatorControllers;

import DataBase.DataBaseCenter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import projectCalculatorMain.CostCenterDataBaseDetails;
import projectCalculatorMain.PreCalculationData;

/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class SingleCalculationPaneController implements Initializable {

    private PreCalculationData preCalculationData;
    private boolean materialTabStatus = false;
    private ObservableList<CostCenterDataBaseDetails> observableList;
    private DataBaseCenter dataBaseCenter = new DataBaseCenter();

    @FXML
    private TabPane sinlgeCalculationTabPane;
    @FXML
    private SplitPane materialCostSplitPane;
    @FXML
    private AnchorPane materialCostAnchorPane;
    @FXML
    private TableView<CostCenterDataBaseDetails> materialCostTableView;
    @FXML
    private AnchorPane materialCostAddRowAnchorPane;
    @FXML
    private GridPane materialCostGridPane;
    @FXML
    private ChoiceBox<String> calculatingPersonChoiceBox;
    @FXML
    private SplitPane materialCostSplitPane1;
    @FXML
    private AnchorPane materialCostAnchorPane1;
    @FXML
    private TableView<?> materialCostTableView1;
    @FXML
    private AnchorPane materialCostAddRowAnchorPane1;
    @FXML
    private GridPane materialCostGridPane1;
    @FXML
    private SplitPane materialCostSplitPane11;
    @FXML
    private AnchorPane materialCostAnchorPane11;
    @FXML
    private TableView<?> materialCostTableView11;
    @FXML
    private AnchorPane materialCostAddRowAnchorPane11;
    @FXML
    private GridPane materialCostGridPane11;
    @FXML
    private SplitPane materialCostSplitPane12;
    @FXML
    private AnchorPane materialCostAnchorPane12;
    @FXML
    private TableView<?> materialCostTableView12;
    @FXML
    private AnchorPane materialCostAddRowAnchorPane12;
    @FXML
    private GridPane materialCostGridPane12;
    @FXML
    private SplitPane materialCostSplitPane13;
    @FXML
    private AnchorPane materialCostAnchorPane13;
    @FXML
    private TableView<?> materialCostTableView13;
    @FXML
    private AnchorPane materialCostAddRowAnchorPane13;
    @FXML
    private GridPane materialCostGridPane13;
    @FXML
    private ChoiceBox<String> projectTypeChoiceBox;
    @FXML
    private ChoiceBox<String> projectSubTypeChoiceBox;
    @FXML
    private ChoiceBox<String> companyAsChoiceBox;
    @FXML
    private ChoiceBox<String> customerChoiceBox;
    @FXML
    private ChoiceBox<String> cityRegionChoiceBox;
    @FXML
    private Button unlocLockMaterialTabButton;
    @FXML
    private Button clearMaterialTabButton;
    @FXML
    private Button deleteMaterialRowButton;
    @FXML
    private TextField singleCalculationQuantity;
    @FXML
    private TextField singleCalculationOverhead;
    @FXML
    private TextField singleCalculationMaterialID;
    @FXML
    private Button addMaterialToTabButton;
    @FXML
    private TableColumn<CostCenterDataBaseDetails, Integer> materialNumberColumn;
    @FXML
    private TableColumn<CostCenterDataBaseDetails, String> materialNameColumn;
    @FXML
    private TableColumn<CostCenterDataBaseDetails, Double> materialPriceColumn;
    @FXML
    private TableColumn<CostCenterDataBaseDetails, Double> materialQuantityColumn;
    @FXML
    private TableColumn<CostCenterDataBaseDetails, String> materialUnitColumn;
    @FXML
    private TableColumn<CostCenterDataBaseDetails, String> materialVatRateColumn;
    @FXML
    private TableColumn<CostCenterDataBaseDetails, Double> materialOverheadColumn;
    @FXML
    private TableColumn<CostCenterDataBaseDetails, String> materialVendorColumn;
    @FXML
    private TableColumn<CostCenterDataBaseDetails, String> materialDateColumn; 
    @FXML
    private TableColumn<CostCenterDataBaseDetails, String> materialIDColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        materialCostAnchorPane.maxHeightProperty().bind(materialCostSplitPane.heightProperty().multiply(0.7));
        materialCostAnchorPane.minHeightProperty().bind(materialCostSplitPane.heightProperty().multiply(0.7));

        preCalculationData = new PreCalculationData();

        preCalculationData.populateChoiceBox(preCalculationData.getSQLPerson());
        calculatingPersonChoiceBox.setItems(FXCollections.observableArrayList(preCalculationData.getList()));

        preCalculationData.populateChoiceBox(preCalculationData.getSQLProject());
        projectTypeChoiceBox.setItems(FXCollections.observableArrayList(preCalculationData.getList()));

        preCalculationData.populateChoiceBox(preCalculationData.getSQLProjectSubtype());
        projectSubTypeChoiceBox.setItems(FXCollections.observableArrayList(preCalculationData.getList()));

        preCalculationData.populateChoiceBox(preCalculationData.getSQLCompanyAs());
        companyAsChoiceBox.setItems(FXCollections.observableArrayList(preCalculationData.getList()));

        preCalculationData.populateChoiceBox(preCalculationData.getSQLCustomer());
        customerChoiceBox.setItems(FXCollections.observableArrayList(preCalculationData.getList()));

        preCalculationData.populateChoiceBox(preCalculationData.getSQLCityRegion());
        cityRegionChoiceBox.setItems(FXCollections.observableArrayList(preCalculationData.getList()));
        
        clearMaterialTabButton.setDisable(true);
        deleteMaterialRowButton.setDisable(true);
        singleCalculationQuantity.setDisable(true);
        singleCalculationOverhead.setDisable(true);
        singleCalculationMaterialID.setDisable(true);
        addMaterialToTabButton.setDisable(true);
        materialCostTableView.setDisable(true);
    }

    @FXML
    private void standardTextFieldActions(KeyEvent event) {
        TextField textFieldSource = (TextField) event.getSource();
        String character = event.getCharacter();
        String charSequence = "";
        if (event.getSource().equals(textFieldSource)) {
            charSequence = textFieldSource.getText();
        }
        if (charSequence.length() > 79 || charSequence.startsWith(" ")
                || charSequence.isEmpty() && " ".contains(character)) {
            event.consume();
        }
    }
    
    @FXML
    private void processKeyEventQuantity(KeyEvent event) {
        TextField textFieldSource = (TextField) event.getSource();
        String character = event.getCharacter();
        String charSequence = textFieldSource.getText();

        if ("1234567890.".contains(character)) {
            if (charSequence.startsWith("0") && !charSequence.startsWith("0.") && "1234567890".contains(character)) {
                event.consume();
            }
            if (charSequence.startsWith(".") && !".".contains(character)) {
                if (".".contains(character)) {
                    event.consume();
                }
                textFieldSource.setText("0.");
                textFieldSource.end();
            }
            if (charSequence.contains(".")) {
                int index = charSequence.indexOf(".");
                if (charSequence.length() > (index + 2)) {
                    event.consume();
                }
                if (".".contains(character)) {
                    event.consume();
                }
            }
        } else {
            event.consume();
        }
        if (charSequence.length() > 9 && !charSequence.contains(".")) {
            if (".".contains(character)) {
            } else {
                event.consume();
            }
        }
    }
    
    @FXML
    private void processKeyEventOverhead(KeyEvent event) {
        TextField textFieldSource = (TextField) event.getSource();
        String character = event.getCharacter();
        String charSequence = textFieldSource.getText();

        if ("1234567890.".contains(character)) {
            if (charSequence.startsWith("0") && !charSequence.startsWith("0.") && "1234567890".contains(character)) {
                event.consume();
            }
            if (charSequence.startsWith(".") && !".".contains(character)) {
                if (".".contains(character)) {
                    event.consume();
                }
                textFieldSource.setText("0.");
                textFieldSource.end();
            }
            if (charSequence.contains(".")) {
                int index = charSequence.indexOf(".");
                if (charSequence.length() > (index + 2)) {
                    event.consume();
                }
                if (".".contains(character)) {
                    event.consume();
                }
            }
        } else {
            event.consume();
        }
        if (charSequence.length() > 2 && !charSequence.contains(".")) {
            if (".".contains(character)) {
            } else {
                event.consume();
            }
        }
    }
    
    @FXML
    private void standardIDTextFieldActions(KeyEvent event) {
        TextField textFieldSource = (TextField) event.getSource();
        String character = event.getCharacter();
        if (!"1234567890".contains(character)) {
            event.consume();
        }
    }

    @FXML
    private void unlocLockMaterialTabButtonOnAction(ActionEvent event) {
        if(materialTabStatus == false){
            clearMaterialTabButton.setDisable(false);
            deleteMaterialRowButton.setDisable(false);
            singleCalculationQuantity.setDisable(false);
            singleCalculationOverhead.setDisable(false);
            singleCalculationMaterialID.setDisable(false);
            addMaterialToTabButton.setDisable(false);
            materialCostTableView.setDisable(false);
            materialTabStatus = true;
            unlocLockMaterialTabButton.setText("LOCK MATERIAL TAB");
        }
        else if(materialTabStatus == true){
            clearMaterialTabButton.setDisable(true);
            deleteMaterialRowButton.setDisable(true);
            singleCalculationQuantity.setDisable(true);
            singleCalculationOverhead.setDisable(true);
            singleCalculationMaterialID.setDisable(true);
            addMaterialToTabButton.setDisable(true);
            materialCostTableView.setDisable(true);
            materialTabStatus = false;
            unlocLockMaterialTabButton.setText("UNLOCK MATERIAL TAB");
        }
    }

    @FXML
    private void clearMaterialTabButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void deleteMaterialRowButtonOnAction(ActionEvent event) {
    }

    @FXML
    private void addMaterialToTabButtonOnAction() {
        dataBaseCenter.makeConnection();
        dataBaseCenter.getAddRowMaterialDataToTable(materialNumberColumn, materialIDColumn, materialNameColumn, 
                materialPriceColumn, materialQuantityColumn, materialUnitColumn, materialVatRateColumn, materialOverheadColumn, 
                materialVendorColumn, materialDateColumn, materialCostTableView, singleCalculationMaterialID, 
                singleCalculationQuantity, singleCalculationOverhead);
    }
}