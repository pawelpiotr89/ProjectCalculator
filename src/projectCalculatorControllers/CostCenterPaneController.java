package projectCalculatorControllers;

import DataBase.DataBaseCenter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
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
    
    private TextField myTextField = new TextField();
    
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
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        
        dataBaseCenter = new DataBaseCenter();
        
        datePickerMaterial.setEditable(false);
        datePickerMaterial.setShowWeekNumbers(false);
        datePickerMaterial.setValue(LocalDate.now());
        
        vatRateChoiceBox.setItems(FXCollections.observableArrayList(dataBaseCenter.getVatRateList()));
        vatRateChoiceBox.getSelectionModel().selectFirst();
       
        unitsOfMeasureChoiceBox.setItems(FXCollections.observableArrayList(dataBaseCenter.getUnitOfMeasureList()));
        unitsOfMeasureChoiceBox.getSelectionModel().selectFirst();
        
        materialNetPriceTextField.setAlignment(Pos.CENTER_RIGHT);
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
        final String incorrectDataInput = "PLEASE ENTER CORRECT DATA!";
        final String correctDataInput = "DATA IS CORRECT!";
        final String priceData = materialNetPriceTextField.getText();
        if(materialNameTextField.getText().trim().isEmpty() || 
            materialNetPriceTextField.getText().isEmpty() || 
            supplierNameTextField.getText().trim().isEmpty() ||
            priceData.matches("[^1234567890.]")){
            materialEnterDataOutputInfo.setText(incorrectDataInput);
        }
        else{
            materialEnterDataOutputInfo.setText(correctDataInput);
            enterDataConfirmationWindow = new EnterDataConfirmationWindow();
            enterDataConfirmationWindow.askingQuestion(materialNameTextField.getText(), 
                    materialNetPriceTextField.getText(),
                    datePickerMaterial.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
                    unitsOfMeasureChoiceBox.getValue().toString(), vatRateChoiceBox.getValue().toString(), 
                    supplierNameTextField.getText());
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
}