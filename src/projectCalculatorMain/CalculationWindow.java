package projectCalculatorMain;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author Roxven89
 */
public class CalculationWindow {
    
    private final Stage calculationStage;
    private final Scene calculationScene;
    private final Pane calculationPane;
    private final Cursor calculationCursor;
    
    
    public CalculationWindow(Button button) throws IOException{
        
        calculationStage = new Stage();
        calculationCursor = Cursor.CROSSHAIR;
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ProjectCalculator.class.getResource("/projectCalculatorFXML/calculationPaneFXML.fxml"));
        calculationPane = loader.load();
        
        calculationScene = new Scene(calculationPane);
        calculationScene.setCursor(calculationCursor);

        calculationStage.setOnCloseRequest(e -> {
            calculationStage.close();
            button.setDisable(false);
            e.consume();
        });

        calculationStage.setTitle("PROJECT_CALCULATOR v. 1.0 - Calculation window");
        calculationStage.initStyle(StageStyle.DECORATED);
        calculationStage.setResizable(true);
        calculationStage.setMaximized(true);
        calculationStage.setMinHeight(900);
        calculationStage.setMinWidth(1440);
        calculationStage.setScene(calculationScene);
        calculationStage.show();
    }
}

