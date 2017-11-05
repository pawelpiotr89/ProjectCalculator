package projectCalculatorControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import projectCalculatorMain.PreCalculationData;
/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class SingleCalculationPaneController implements Initializable {
    
    private PreCalculationData preCalculationData;
            
    @FXML
    private TabPane sinlgeCalculationTabPane;
    @FXML
    private SplitPane materialCostSplitPane;
    @FXML
    private AnchorPane materialCostAnchorPane;
    @FXML
    private TableView<?> materialCostTableView;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        materialCostAnchorPane.maxHeightProperty().bind(materialCostSplitPane.heightProperty().multiply(0.9));
        materialCostAnchorPane.minHeightProperty().bind(materialCostSplitPane.heightProperty().multiply(0.9));
        
        preCalculationData = new PreCalculationData();
        
        preCalculationData.populateChoiceBox(preCalculationData.getSQLPerson());
        calculatingPersonChoiceBox.setItems(FXCollections.observableArrayList(preCalculationData.getList()));
        
        preCalculationData.populateChoiceBox(preCalculationData.getSQLProject());
        projectTypeChoiceBox.setItems(FXCollections.observableArrayList(preCalculationData.getList()));
    }  
}