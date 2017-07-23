
package projectCalculatorControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;

/**
 *
 * @author Roxven89
 */
public class WelcomePaneController{
    
    @FXML
    private TextField loginName;
    
    @FXML
    private PasswordField passwordLogin;
    
    @FXML
    private Button confirmButton;
    
    public WelcomePaneController(){
        
    }
    
    @FXML
    void initialize(){
        
    }
    
    @FXML
    private void loginPasswordConfirmation(){
        System.out.print("Działa!!!");
    }
    
    @FXML
    private void mouseEnteredOnButton(){
        DropShadow shadow = new DropShadow();
        confirmButton.setEffect(shadow);
    }
    
    @FXML
    private void mouseExitedOffButton(){
        confirmButton.setEffect(null);
    }
}
