package projectCalculatorControllers;

import DataBase.DataBaseCenter;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import projectCalculatorMain.DataBaseDetails;
import projectCalculatorMain.EnterDataConfirmationWindow;
/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class CostCenterPaneController implements Initializable {

    private MainPaneController mainPaneController;
    private DataBaseCenter dataBaseCenter;
    private EnterDataConfirmationWindow enterDataConfirmationWindow;
    
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
    
    ObservableList<DataBaseDetails> data;
    
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
        
        materialPriceColumn.setStyle("-fx-alignment: CENTER-RIGHT;");
        materialVatColumn.setStyle("-fx-alignment: CENTER-RIGHT;");
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
    
    @FXML
    private void materialEnterDataOnAction(){
        costEnterDataOnAction(materialNetPriceTextField, materialNameTextField, 
                supplierNameTextField, materialEnterDataOutputInfo, datePickerMaterial,
                unitsOfMeasureChoiceBox, vatRateChoiceBox, dataBaseCenter.getInsertNewMaterial());
    }
    
    @FXML
    private void materialSearchButtonOnAction(){
        if(searchMaterialTextField.getText().trim().isEmpty()){   
        }
        else{
           String fraze = "('%" + searchMaterialTextField.getText() + "%')";
           dataBaseCenter.makeConnection();
           dataBaseCenter.getFromDataBaseToTableView(dataBaseCenter.getselectFromMaterial(), 
                   fraze, materialDisplayTable, materialNameColumn, materialUnitColumn,
                   materialPriceColumn, materialVatColumn, materialVendorColumn, materialDateColumn);
        }
    }
  
    @FXML
    private void backToMenu() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource
        ("/projectCalculatorFXML/FXMLMenuPane.fxml"));
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
                    costDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
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
                costOutputInfoTF.setText(confirmation);
            } 
            else {
            }
        }
    }
}