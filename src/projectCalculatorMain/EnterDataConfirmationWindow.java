package projectCalculatorMain;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Roxven89
 */
public class EnterDataConfirmationWindow {
    
    private final String question = "DO YOU CONFIRM THIS DATA?";
    private String dataValue = "";

    public void askingQuestion(String material, String price, String date, 
        String unit, String vat, String supplier) {
            dataValue = material + " | " + price + " zł | " + unit + " | " + vat + " | " + 
                        supplier + " | " + date;
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText(dataValue);
            alert.setTitle(question);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES) {
            } else {
        }
    }
}
