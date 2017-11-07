package projectCalculatorMain;

import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Roxven89
 */
public class ExitAlertWindow {

    private final String question = "ARE YOU SURE YOU WANT TO EXIT THE PROGRAM?";
    private final String subquestion = "ARE YOU SURE YOU WANT TO EXIT CALCULATION WINDOW?";

    public void askingQuestion() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText(question);
        alert.setTitle("");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {
            Platform.exit();
        } else {
        }
    }

    public void subAskingQuestion(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText(subquestion);
        alert.setTitle("");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {
            stage.close();
        } else {
        }
    }
}