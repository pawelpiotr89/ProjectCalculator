package projectCalculatorControllers;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import projectCalculatorMain.ProjectCalculator;
/**
 *
 * @author Roxven89
 */
public class SingleCalculationPaneController {
    
    private final Stage calculationStage;
    private final Scene calculationScene;
    private final Pane calculationPane;
    private final Cursor calculationCursor;
    private static boolean startCalculationButtonState;
    
    public SingleCalculationPaneController(Button button) throws IOException{
        
        calculationStage = new Stage();
        calculationCursor = Cursor.CROSSHAIR;
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ProjectCalculator.class.getResource("/projectCalculatorFXML/calculationPaneFXML.fxml"));
        calculationPane = loader.load();
        
        calculationScene = new Scene(calculationPane);
        calculationScene.setCursor(calculationCursor);

        calculationStage.setOnCloseRequest((WindowEvent e) -> {
            calculationStage.close();
            setStartCalculationButtonState(false);
            button.setDisable(getStartCalculationButtonState());
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
        
    public static void setStartCalculationButtonState(boolean buttonState){
        startCalculationButtonState = buttonState;
    }
    
    public static boolean getStartCalculationButtonState(){
        return startCalculationButtonState;
    }
}