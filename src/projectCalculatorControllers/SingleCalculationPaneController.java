package projectCalculatorControllers;

import DataBase.DataBaseCenter;

import java.math.BigInteger;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import static oracle.jrockit.jfr.events.Bits.intValue;
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
    private boolean contractDataStatus = false;
    private final DataBaseCenter dataBaseCenter = new DataBaseCenter();
    private final DecimalFormat bigIntegerFormat = new DecimalFormat("###,###,###,###,###,###.00");
    private int positionCount = 0;

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
    @FXML
    private Label materialNetCostsLabel;
    @FXML
    private Label materialNetOutcomeLabel;
    @FXML
    private Label materialGrossCostsLabel;
    @FXML
    private Label materialGrossOutcomeLabel;
    @FXML
    private Label materialOverheadCostsLabel;
    @FXML
    private Label materialNetOverheadOutcomeLabel;
    @FXML
    private Label materialTotalCostsLabel;
    @FXML
    private Label materialTotalOutcomeLabel;
    @FXML
    private Button unlockLockContractDataButton;
    @FXML
    private TextField projectNameField;
    
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
        
        projectTypeChoiceBox.setDisable(true);
        projectSubTypeChoiceBox.setDisable(true);
        companyAsChoiceBox.setDisable(true);
        customerChoiceBox.setDisable(true);
        cityRegionChoiceBox.setDisable(true);
        projectNameField.setDisable(true);
        calculatingPersonChoiceBox.setDisable(true);
        
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
    private void unlockLockContractData(ActionEvent event) {
        if(contractDataStatus == false){
            projectTypeChoiceBox.setDisable(false);
            projectSubTypeChoiceBox.setDisable(false);
            companyAsChoiceBox.setDisable(false);
            customerChoiceBox.setDisable(false);
            cityRegionChoiceBox.setDisable(false);
            projectNameField.setDisable(false);
            calculatingPersonChoiceBox.setDisable(false);
            contractDataStatus = true;
            unlockLockContractDataButton.setText("LOCK CONTRACT DATA");
        }
        else if(contractDataStatus == true){
            projectTypeChoiceBox.setDisable(true);
            projectSubTypeChoiceBox.setDisable(true);
            companyAsChoiceBox.setDisable(true);
            customerChoiceBox.setDisable(true);
            cityRegionChoiceBox.setDisable(true);
            projectNameField.setDisable(true);
            calculatingPersonChoiceBox.setDisable(true);
            contractDataStatus = false;
            unlockLockContractDataButton.setText("UNLOCK CONTRACT DATA");
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
        materialCostTableView.getItems().clear();
        resetPosition();
        clearMaterialOutcomeLabels();
        clearMaterialInputTextFields();
    }

    @FXML
    private void deleteMaterialRowButtonOnAction(ActionEvent event) {
        ObservableList<CostCenterDataBaseDetails> selectedMaterials, allMaterials, singleMaterial;
        allMaterials = materialCostTableView.getItems();
        selectedMaterials = materialCostTableView.getSelectionModel().getSelectedItems();
        selectedMaterials.forEach(allMaterials::remove);
        allMaterials = materialCostTableView.getItems();
        int size = allMaterials.size();
        for(int i = 0; i < size; i++){
        allMaterials.get(i).setPosition(i+1);
        setPosition(i+1);
        }
        materialCostTableView.setItems(allMaterials);
        clearMaterialOutcomeLabels();
        clearMaterialInputTextFields();
        
        sumGrossCosts(materialGrossOutcomeLabel);
        totalCostAndOverheads(materialTotalOutcomeLabel);
    }

    @FXML
    private void addMaterialToTabButtonOnAction() {
        if(singleCalculationMaterialID.getText().trim().isEmpty() || 
                singleCalculationQuantity.getText().trim().isEmpty() || 
                singleCalculationOverhead.getText().trim().isEmpty()){
        }
        else{
        dataBaseCenter.makeConnection();
        upPosition();
        dataBaseCenter.getAddRowMaterialDataToTable(materialNumberColumn, materialIDColumn, materialNameColumn, 
                materialPriceColumn, materialQuantityColumn, materialUnitColumn, materialVatRateColumn, materialOverheadColumn, 
                materialVendorColumn, materialDateColumn, materialCostTableView, singleCalculationMaterialID, 
                singleCalculationQuantity, singleCalculationOverhead, getPosition());
        sumGrossCosts(materialGrossOutcomeLabel);
        totalCostAndOverheads(materialTotalOutcomeLabel);
        clearMaterialInputTextFields();
        }
    }
    
    private int sumNetCosts(Label netCostSumLabel){
        int totalNetCosts = 0;
        
        for (CostCenterDataBaseDetails item : materialCostTableView.getItems()) {
        double doublePrice = item.getPrice();
        double doubleQuantity = item.getQuantity();
        totalNetCosts = totalNetCosts + intValue((doublePrice * doubleQuantity));
        BigInteger bigTotal = BigInteger.valueOf(totalNetCosts);
        
        netCostSumLabel.setText(bigIntegerFormat.format(bigTotal) + " ZŁ");
        }
        return totalNetCosts;
    }
    
    private void sumGrossCosts(Label grossCostSumLabel){
        int totalGrossCosts = 0;
        double doubleVatRate = 0;
        
        for (CostCenterDataBaseDetails item : materialCostTableView.getItems()) {
        double doublePrice = item.getPrice();
        double doubleQuantity = item.getQuantity();
        String stringVatRate = item.getVat();
        
        switch(stringVatRate){
            case "0%":
                doubleVatRate = 1.00;
                break;
            case "5%":
                doubleVatRate = 1.05;
                break;
            case "8%":
                doubleVatRate = 1.08;
                break;
            case "23%":
                doubleVatRate = 1.23;
                break;
            case "RC (Reverse Charge)":
                doubleVatRate = 1.00;
                break;
        }
        
        double doubleGrossPrice = (doublePrice * doubleVatRate);
        totalGrossCosts = totalGrossCosts + intValue((doubleGrossPrice * doubleQuantity));
        BigInteger bigTotal = BigInteger.valueOf(totalGrossCosts);
        
        grossCostSumLabel.setText(bigIntegerFormat.format(bigTotal) + " ZŁ");
        }
    }
    
    private int sumOverheads(Label overheadCostSumLabel){
        int totalOverheads = 0;
        
        for (CostCenterDataBaseDetails item : materialCostTableView.getItems()) {
        double doublePrice = item.getPrice();
        double doubleQuantity = item.getQuantity();
        double doubleOverhead = item.getOverhead();
        totalOverheads = totalOverheads + intValue((doublePrice * doubleQuantity * doubleOverhead / 100));
        BigInteger bigTotal = BigInteger.valueOf(totalOverheads);
        
        overheadCostSumLabel.setText(bigIntegerFormat.format(bigTotal) + " ZŁ");
        }
        return totalOverheads;
    }
    
    private void totalCostAndOverheads(Label materialSumOutcomeLabel){
        
        BigInteger bigTotalCosts = BigInteger.valueOf((sumNetCosts(materialNetOutcomeLabel) + sumOverheads(materialNetOverheadOutcomeLabel)));
        
        if(bigTotalCosts.doubleValue() == 0){    
        }
        else{
            materialSumOutcomeLabel.setText(bigIntegerFormat.format(bigTotalCosts) + " ZŁ");
        }
    }
    
    public void upPosition(){
        positionCount++;
    }
    
    public void resetPosition(){
        positionCount = 0;
    }
    
    public int getPosition(){
        return positionCount;
    }
    
    public void setPosition(int positionCount){
        this.positionCount = positionCount;
    }
    
    public int complexPositioning(int positionCount){
        upPosition();
        this.positionCount = positionCount;
        return positionCount;
    }
    
    public void clearMaterialOutcomeLabels(){
        materialNetOutcomeLabel.setText("");
        materialNetOverheadOutcomeLabel.setText("");
        materialGrossOutcomeLabel.setText("");
        materialTotalOutcomeLabel.setText("");
    }
    
    public void clearMaterialInputTextFields(){
        singleCalculationQuantity.clear();
        singleCalculationOverhead.clear();
        singleCalculationMaterialID.clear();
    }
}