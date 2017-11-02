package projectCalculatorMain;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import projectCalculatorControllers.SingleCalculationPaneController;

/**
 *
 * @author Roxven89
 */
public class SingleCalculationStage {

    private final Stage calculationStage;
    private final Scene calculationScene;
    private final AnchorPane anchorPane;
    private final ExitAlertWindow exitAlertWindow;
    private static boolean startCalculationButtonState;

    public SingleCalculationStage(Button button) throws IOException {

        exitAlertWindow = new ExitAlertWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ProjectCalculator.class.getResource("/projectCalculatorFXML/FXMLSingleCalculationPane.fxml"));
        anchorPane = loader.load();
        SingleCalculationPaneController singleCalculationPaneController = loader.getController();

        calculationScene = new Scene(anchorPane);

        calculationStage = new Stage();

        calculationStage.setOnCloseRequest((WindowEvent e) -> {
            exitAlertWindow.subAskingQuestion(calculationStage);
            setStartCalculationButtonState(false);
            button.setDisable(getStartCalculationButtonState());
            e.consume();
        });

        calculationStage.setTitle("PROJECT_CALCULATOR v. 1.0 - Calculation window");
        calculationStage.initStyle(StageStyle.UTILITY);
        calculationStage.setResizable(false);
        calculationStage.setScene(calculationScene);
        calculationStage.show();
    }

    public static void setStartCalculationButtonState(boolean buttonState) {
        startCalculationButtonState = buttonState;
    }

    public static boolean getStartCalculationButtonState() {
        return startCalculationButtonState;
    }
}
