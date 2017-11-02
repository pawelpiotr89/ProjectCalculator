package projectCalculatorControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class SingleCalculationPaneController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        materialCostAnchorPane.maxHeightProperty().bind(materialCostSplitPane.heightProperty().multiply(0.9));
        materialCostAnchorPane.minHeightProperty().bind(materialCostSplitPane.heightProperty().multiply(0.9));
    }  
}
