package projectCalculatorControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
/**
 * FXML Controller class
 *
 * @author Roxven89
 */
public class SingleCalculationPaneController implements Initializable {
    
    private GridPane costsGridPane;
    
    @FXML
    private AnchorPane costsAnchorPane;
    @FXML
    private Button saveCalculationButton;
    @FXML
    private SplitPane calculationSplitPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        costsGridPane = new GridPane();
        costsAnchorPane.getChildren().add(costsGridPane);
    }    
}