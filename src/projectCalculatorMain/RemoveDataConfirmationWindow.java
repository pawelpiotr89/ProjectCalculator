package projectCalculatorMain;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Roxven89
 */
public class RemoveDataConfirmationWindow {

    private final String question = "ARE YOU SURE YOU WANT TO REMOVE THIS?";
    private final String dataValue = "";
    private final Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);

    public void askingQuestion() {
        alert.setHeaderText(question);
        alert.setTitle(dataValue);
    }

    public Alert getAlert() {
        return alert;
    }
}