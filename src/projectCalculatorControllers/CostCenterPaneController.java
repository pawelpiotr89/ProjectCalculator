package projectCalculatorControllers;

import DataBase.DataBaseCenter;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import projectCalculatorMain.ChangeMaterialConfirmationWindow;
import projectCalculatorMain.DataBaseDetails;
import projectCalculatorMain.EnterDataConfirmationWindow;
import projectCalculatorMain.RemoveDataConfirmationWindow;
/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class CostCenterPaneController implements Initializable {

    private MainPaneController mainPaneController;
    private DataBaseCenter dataBaseCenter;
    private EnterDataConfirmationWindow enterDataConfirmationWindow;
    private RemoveDataConfirmationWindow removeDataConfirmationWindow;
    private ChangeMaterialConfirmationWindow changeMaterialConfirmationWindow;
    ObservableList<DataBaseDetails> data;
///////////////////////////Material cost FXML///////////////////////////////////    
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
    private TextField materialNetPriceTextField;
    @FXML
    private TextField supplierNameTextField;
    @FXML
    private Label materialEnterDataOutputInfo;
    @FXML
    private TextField searchMaterialTextField;
    @FXML
    private Pane costCenterPane;
    @FXML
    private SplitPane costCenterSplitPane;
    @FXML
    private Button backFromCostCenterToMenuButton;
    @FXML
    private Button materialEnterData;
    @FXML
    private Button materialSearchButton;
    @FXML
    private TableView<DataBaseDetails> materialDisplayTable;
    @FXML
    private TableColumn<DataBaseDetails, String> materialNameColumn;
    @FXML
    private TableColumn<DataBaseDetails, String> materialUnitColumn;
    @FXML
    private TableColumn<DataBaseDetails, String> materialPriceColumn;
    @FXML
    private TableColumn<DataBaseDetails, String> materialVatColumn;
    @FXML
    private TableColumn<DataBaseDetails, String> materialVendorColumn;
    @FXML
    private TableColumn<DataBaseDetails, String> materialDateColumn;
    @FXML
    private TableColumn<DataBaseDetails, String> materialIDColumn;
    @FXML
    private TextField materialIDTextField;
    @FXML
    private Button pickIDButton;
    @FXML
    private Label materialToRemoveLabel;
    @FXML
    private Label removeMaterialConfirmationLabel;
    @FXML
    private Button removeMaterialButton;
    @FXML
    private Button resetMaterialID;
    @FXML
    private Button materialDisplaAllButton;
    @FXML
    private TextField materialIDChangeField;
    @FXML
    private Button pickMaterialToChangeButton;
    @FXML
    private Button saveMaterialButton;
    @FXML
    private TextField materialNameChangeField;
    @FXML
    private TextField materialNetPriceChangeField;
    @FXML
    private DatePicker materialDayOfPriceChangeField;
    @FXML
    private ChoiceBox materialUnitChangeChoiceBox;
    @FXML
    private ChoiceBox materialVATrateChangeChoiceBox;
    @FXML
    private TextField materialSupplierChangeField;
////////////////////////////////////////////////////////////////////////////////    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        
        dataBaseCenter = new DataBaseCenter();
        dataBaseCenter.checkAndCreateDatabase();
        
        datePickerMaterial.setEditable(false);
        datePickerMaterial.setShowWeekNumbers(false);
        datePickerMaterial.setValue(LocalDate.now());
        
        vatRateChoiceBox.setItems(FXCollections.observableArrayList(dataBaseCenter.getVatRateList()));
        vatRateChoiceBox.getSelectionModel().selectFirst();
       
        unitsOfMeasureChoiceBox.setItems(FXCollections.observableArrayList(dataBaseCenter.getUnitOfMeasureList()));
        unitsOfMeasureChoiceBox.getSelectionModel().selectFirst();
        
        materialNetPriceTextField.setAlignment(Pos.CENTER_RIGHT);
        
        removeMaterialButton.setDisable(true);
        resetMaterialID.setDisable(true);
        
        saveMaterialButton.setDisable(true);
        
        materialDayOfPriceChangeField.setEditable(false);
        materialDayOfPriceChangeField.setShowWeekNumbers(false);
        materialDayOfPriceChangeField.setValue(LocalDate.now());
        materialDayOfPriceChangeField.setDisable(true);
    }
/////////////////////Expandable and Closable Cost Cards/////////////////////////
    @FXML
    private void onMouseReleased() {
        if(!materialCostTitledPane.isExpanded()){
            addNewMaterialCostTitledPane.setExpanded(false); 
            changeMaterialCostTitledPane.setExpanded(false);
            displayMaterialCostTitledPane.setExpanded(false);
            removeMaterialCostTitledPane.setExpanded(false);
        }
    }
///////////////////////ID text field inputs only digits/////////////////////////
    @FXML
    private void standardIDTextFieldActions(KeyEvent event){
       TextField textFieldSource = (TextField) event.getSource();
       String character = event.getCharacter();
       if(!"1234567890".contains(character)){
           event.consume();
       }
    }
//////////////////////40 characters input limit, no blank space///////////////// 
    @FXML
    private void standardTextFieldActions(KeyEvent event){
       TextField textFieldSource = (TextField) event.getSource();
       String character = event.getCharacter();
       String charSequence = "";
       if(event.getSource().equals(textFieldSource)){
           charSequence = textFieldSource.getText();
       }          
       if(charSequence.length() > 39 || charSequence.startsWith(" ") || 
          charSequence.isEmpty() && " ".contains(character)){
           event.consume();
       }   
    }
/////////////////////////Price input restrictions///////////////////////////////  
    @FXML
    private void processKeyEventPrice(KeyEvent event) {
    TextField textFieldSource = (TextField) event.getSource();
    String character = event.getCharacter();
    String charSequence = textFieldSource.getText();
    
    if("1234567890.".contains(character)){
        if(charSequence.startsWith("0") && !charSequence.startsWith("0.") && "1234567890".contains(character)){
            event.consume();
        }
        if(charSequence.startsWith(".") && !".".contains(character)){
            if(".".contains(character)){
                event.consume();
            }
            textFieldSource.setText("0.");
            textFieldSource.end();
        }
        if(charSequence.contains(".")){
            int index = charSequence.indexOf(".");
            if(charSequence.length() > (index + 2)){
                event.consume();
            }
            if(".".contains(character)){
                event.consume();
            }
        }
    }
    else{
        event.consume();
    }
    if(charSequence.length() > 9 && !charSequence.contains(".")){
        if(".".contains(character)){
        }
        else{
            event.consume();
        }
    }
    }
/////////////////////////Adding new material cost to database///////////////////  
    @FXML
    private void materialEnterDataOnAction(ActionEvent event){
        costEnterDataOnAction(materialNetPriceTextField, materialNameTextField, 
                supplierNameTextField, materialEnterDataOutputInfo, datePickerMaterial,
                unitsOfMeasureChoiceBox, vatRateChoiceBox, dataBaseCenter.getInsertNewMaterial());
    }
/////////////////////Searching database for given material name/////////////////  
    @FXML
    private void materialSearchButtonOnAction(ActionEvent event){
        costSearchButtonOnAction(searchMaterialTextField, dataBaseCenter.getselectFromMaterial(), 
                materialDisplayTable, materialIDColumn, materialNameColumn, 
                materialUnitColumn, materialPriceColumn, materialVatColumn, 
                materialVendorColumn, materialDateColumn);
    }
///////////////////////Searching material database by given ID number///////////
    @FXML
    private void pickMaterialIDFromDataBase(ActionEvent event){
        pickCostIDFromDataBase(materialIDTextField, dataBaseCenter.getSelectFromMaterialByID(), 
                materialToRemoveLabel, removeMaterialButton, resetMaterialID, 
                pickIDButton);
    }
//////////////////////Resetting material ID text field//////////////////////////
    @FXML
    private void resetMaterialIDTextFieldAction(ActionEvent event){
        resetCostIDTextFieldAction(materialToRemoveLabel, removeMaterialButton, 
                pickIDButton, resetMaterialID, materialIDTextField);
    }
////////////////////Removing material from database/////////////////////////////    
    @FXML
    private void removeMaterialFromDataBaseAction(ActionEvent event) {
        removeCostFromDataBaseAction(materialIDTextField, materialToRemoveLabel, 
                pickIDButton, resetMaterialID, removeMaterialButton);
    }
////////////////////Displaing all materials from database///////////////////////    
    @FXML
    private void displayAllMaterialButton(){
        displayAllCostsButton(materialDisplayTable, materialIDColumn, materialNameColumn, 
                materialUnitColumn, materialPriceColumn, materialVatColumn, 
                materialVendorColumn, materialDateColumn);
    }
///////////////Picking material from database to perform change action//////////    
    @FXML
    private void pickMaterialIDToChangeOnAction(ActionEvent event){
        pickCostIDToChangeOnAction(materialIDChangeField, materialNameChangeField, 
                materialNetPriceChangeField, materialDayOfPriceChangeField, 
                materialUnitChangeChoiceBox, materialVATrateChangeChoiceBox, 
                materialSupplierChangeField, saveMaterialButton, pickMaterialToChangeButton);
    }
/////////////////////////Change material data///////////////////////////////////    
    @FXML
    private void saveMaterialDataOnAction(ActionEvent event) {
        saveCostDataOnAction(materialIDChangeField, materialNetPriceChangeField, 
                materialSupplierChangeField, materialNameChangeField, materialDayOfPriceChangeField, 
                materialUnitChangeChoiceBox, materialVATrateChangeChoiceBox, 
                pickMaterialToChangeButton, saveMaterialButton);
    }
////////////////////////Going back to menu//////////////////////////////////////  
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
////////////////////////////////////////////////////////////////////////////////
    public void setMainPaneController(MainPaneController mainPaneController) {
        this.mainPaneController = mainPaneController;
    }
///////////////////Adding new cost to database TEMPLATE/////////////////////////
    private void costEnterDataOnAction(TextField costNetPriceTF, TextField costNameTF, 
            TextField costSupplierTF, Label costOutputInfoTF, DatePicker costDatePicker, 
            ChoiceBox costUnitOfMeasureTF, ChoiceBox costVatRate, String insertCost){
        final String incorrectDataInput = "PLEASE ENTER CORRECT DATA!";
        final String correctDataInput = "DATA IS CORRECT!";
        final String confirmation = "DATA ENTERD CORRECTLY!";
        final String priceData = costNetPriceTF.getText();
        final String insertNewCost = insertCost;
        if(costNameTF.getText().trim().isEmpty() || 
            costNetPriceTF.getText().isEmpty() || 
            costSupplierTF.getText().trim().isEmpty() ||
            priceData.matches("[^1234567890.]")){
            costOutputInfoTF.setText(incorrectDataInput);
        }
        else{
            costOutputInfoTF.setText(correctDataInput);
            enterDataConfirmationWindow = new EnterDataConfirmationWindow();
            enterDataConfirmationWindow.askingQuestion(costNameTF.getText(), 
                    costNetPriceTF.getText(),
                    costDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), 
                    costUnitOfMeasureTF.getValue().toString(), costVatRate.getValue().toString(), 
                    costSupplierTF.getText());
            
            Optional<ButtonType> result = enterDataConfirmationWindow.getAlert().showAndWait();
            if (result.get() == ButtonType.YES) {
                double price = Double.parseDouble(costNetPriceTF.getText());
                Date date = Date.valueOf(costDatePicker.getValue());
                String newCost = insertNewCost + costNameTF.getText() + "', '" + 
                        costUnitOfMeasureTF.getValue().toString() + "', " + 
                        price + ", '" + costVatRate.getValue().toString() + "', '" + 
                        costSupplierTF.getText() + "', '" + 
                        date + "')";
                dataBaseCenter.makeConnection();
                dataBaseCenter.addNewCost(newCost);
                costNetPriceTF.clear();
                costNameTF.clear(); 
                costSupplierTF.clear();
                costOutputInfoTF.setText(confirmation);
            } 
            else {
            }
        }
    }
////////////////////////////Searching cost TEMPLATE/////////////////////////////  
    private void costSearchButtonOnAction(TextField textField, String sql, 
            TableView<DataBaseDetails> tableView, TableColumn<DataBaseDetails, String> tableColumn1, 
            TableColumn<DataBaseDetails, String> tableColumn2, 
            TableColumn<DataBaseDetails, String> tableColumn3, 
            TableColumn<DataBaseDetails, String> tableColumn4, 
            TableColumn<DataBaseDetails, String> tableColumn5, 
            TableColumn<DataBaseDetails, String> tableColumn6, 
            TableColumn<DataBaseDetails, String> tableColumn7){
        if(textField.getText().trim().isEmpty()){   
        }
        else{
           String fraze = "('%" + textField.getText() + "%')";
           dataBaseCenter.makeConnection();
           dataBaseCenter.getFromDataBaseToTableView(sql, fraze, tableView, 
                   tableColumn1, tableColumn2, tableColumn3,
                   tableColumn4, tableColumn5, tableColumn6, tableColumn7);
        }
    }
////////////////////////////Pick cost ID TEMPLATE///////////////////////////////    
    private void pickCostIDFromDataBase(TextField textField, String sql, Label label1, 
            Button button1, Button button2, Button button3){
        if(!textField.getText().trim().isEmpty()){
            String materialID = textField.getText();
            dataBaseCenter.makeConnection();
            dataBaseCenter.getLookForDataBaseByID(sql, materialID, label1, 
                    button1, button2, button3, textField);
        }
        else{
            String warrning = "SELECT ID FIRST!";
            label1.setText(warrning);
        }
    }
/////////////////////////Resed Cost ID TEMPLATE/////////////////////////////////
    private void resetCostIDTextFieldAction(Label label, Button button1, 
            Button button2, Button button3, TextField textField){
        label.setText("");
        button1.setDisable(true);
        button2.setDisable(false);
        button3.setDisable(true);
        textField.setDisable(false);
        textField.setText("");
    }
////////////////////////Remove cost from database TEMPLATE//////////////////////
    private void removeCostFromDataBaseAction(TextField textField, Label label, 
            Button button1, Button button2, Button button3){
        String materialID = textField.getText();
        String materialRemoved = "MATERIAL REMOVED CORRECTLY!";
        removeDataConfirmationWindow = new RemoveDataConfirmationWindow();
        removeDataConfirmationWindow.askingQuestion();
        Optional<ButtonType> result = removeDataConfirmationWindow.getAlert().showAndWait();
        if(result.get() == ButtonType.YES){
        dataBaseCenter.makeConnection();
        dataBaseCenter.getRemoveFromDataBase(dataBaseCenter.getRemoveFromMaterial(), materialID);
        textField.setText("");
        label.setText(materialRemoved);
        textField.setDisable(false);
        button1.setDisable(false);
        button2.setDisable(true);
        button3.setDisable(true);
        }
        else{
        }
    }
//////////////////////Display all costs TEMPLATE////////////////////////////////
    private void displayAllCostsButton(TableView<DataBaseDetails> tableView, TableColumn<DataBaseDetails, 
            String> tableColumn1, TableColumn<DataBaseDetails, String> tableColumn2, 
            TableColumn<DataBaseDetails, String> tableColumn3, 
            TableColumn<DataBaseDetails, String> tableColumn4, 
            TableColumn<DataBaseDetails, String> tableColumn5, 
            TableColumn<DataBaseDetails, String> tableColumn6, 
            TableColumn<DataBaseDetails, String> tableColumn7){
        final String fraze = "";
        dataBaseCenter.makeConnection();
           dataBaseCenter.getFromDataBaseToTableView(dataBaseCenter.getSelectAllFromMaterials(), 
                   fraze, tableView, tableColumn1, tableColumn2, tableColumn3,
                   tableColumn4, tableColumn5, tableColumn6, tableColumn7);
    }
//////////Picking costs from database to perform change action TEMPLATE/////////
    private void pickCostIDToChangeOnAction(TextField textField1, TextField textField2, 
            TextField textField3, DatePicker datePicker, ChoiceBox choiceBox1, 
            ChoiceBox choiceBox2, TextField textField4, Button button1, Button button2){
    if(!textField1.getText().trim().isEmpty()){
            String materialID = textField1.getText();
            dataBaseCenter.makeConnection();
            dataBaseCenter.getDataFromMaterialToChange(dataBaseCenter.getSelectFromMaterialByID(), 
                    materialID, textField1, textField2, textField3, datePicker, choiceBox1, choiceBox2, 
                    textField4, button1, dataBaseCenter.getUnitOfMeasureList(), dataBaseCenter.getVatRateList());
            button2.setDisable(true);
        }
        else{ 
        }
    }
////////////////////////Change cost data TEMPLATE///////////////////////////////  
    private void saveCostDataOnAction(TextField textField1, TextField textField2, 
            TextField textField3, TextField textField4, DatePicker datePicker1, 
            ChoiceBox choiceBox1, ChoiceBox choiceBox2, Button button1, Button button2){
        if(!textField1.getText().trim().isEmpty() 
                && !textField2.getText().trim().isEmpty() 
                && !textField3.getText().trim().isEmpty()){
            changeMaterialConfirmationWindow = new ChangeMaterialConfirmationWindow();
            changeMaterialConfirmationWindow.askingQuestion(textField4.getText(),
                    textField2.getText(), 
                    datePicker1.getValue().toString(),
                    choiceBox1.getValue().toString(),
                    choiceBox2.getValue().toString(), 
                    textField3.getText());
            Optional<ButtonType> result = changeMaterialConfirmationWindow.getAlert().showAndWait();
            if (result.get() == ButtonType.YES) {
                dataBaseCenter.makeConnection();
                BigDecimal bigDecimal = new BigDecimal(textField2.getText());
                dataBaseCenter.getSaveMaterialData(textField4.getText(),
                    choiceBox1.getValue().toString(), 
                    bigDecimal, choiceBox2.getValue().toString(), 
                    textField3.getText(), 
                    Date.valueOf(datePicker1.getValue()), 
                    Integer.parseInt(textField1.getText()));
                
                textField1.clear();
                textField4.clear();
                textField2.clear();
                textField3.clear();
                button1.setDisable(false);
                button2.setDisable(true);
            }
            else{    
            }
        }
        else{
        }
    }
}