package projectCalculatorMain;

import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Roxven89
 */
public class ExitAlertWindow {

    private final String question = "ARE YOU SURE YOU WANT TO EXIT THE PROGRAM?";

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
}