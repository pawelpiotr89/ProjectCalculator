package projectCalculatorMain;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Roxven89
 */
public class EnterDataConfirmationWindow {

    private final String question = "DO YOU CONFIRM THIS DATA?";
    private String dataValue = "";
    private final Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);

    public void askingQuestion(String material, String price, String date,
            String unit, String vat, String supplier) {
        dataValue = material + " | " + price + " PLZ | " + unit + " | " + vat + " | "
                + supplier + " | " + date;
        alert.setHeaderText(dataValue);
        alert.setTitle(question);
    }

    public Alert getAlert() {
        return alert;
    }
}
