package projectcalculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 *
 * @author Roxven89
 */
public class ProjectCalculator extends Application {

    private Stage mainStage;
    private Scene welcomeScene;
    private Pane welcomePane;
    private Label welcomeLabel, authorLabel;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        mainStage = stage;
        mainStage.setTitle("PROJECT_CALCULATOR v. 1.0");
        
        initWelcomeLayout();
    }
    
    public void initWelcomeLayout(){
        try{
            FXMLLoader welcomeLayoutLoader = new FXMLLoader();
            welcomeLayoutLoader.setLocation(ProjectCalculator.class.getResource("FXMLDocument.fxml"));
            welcomePane = (Pane) welcomeLayoutLoader.load();
            
            welcomeScene = new Scene(welcomePane);
            mainStage.setScene(welcomeScene);
            mainStage.setResizable(false);
            mainStage.show();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
