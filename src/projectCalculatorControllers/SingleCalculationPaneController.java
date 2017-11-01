package projectCalculatorControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class SingleCalculationPaneController implements Initializable {
   
    @FXML
    private AnchorPane costsAnchorPane;
    @FXML
    private Button saveCalculationButton;
    @FXML
    private TabPane calculationTabPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}