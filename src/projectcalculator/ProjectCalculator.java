package projectcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import projectcalculator.Controllers.WelcomePaneController;
/**
 *
 * @author Roxven89
 */
public class ProjectCalculator extends Application {

    private Stage mainStage;
    private Scene welcomeScene;
    private Pane welcomePane;
    private Cursor cursor;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        mainStage = stage;
        cursor = Cursor.CROSSHAIR;
     
        FXMLLoader welcomeLayoutLoader = new FXMLLoader();
        welcomeLayoutLoader.setLocation(ProjectCalculator.class.getResource("FXMLWelcomePane.fxml"));
        welcomePane = welcomeLayoutLoader.load();
        
        WelcomePaneController welcomePaneController = welcomeLayoutLoader.getController();
            
        welcomeScene = new Scene(welcomePane);
        welcomeScene.setCursor(cursor);
        
        mainStage.setTitle("PROJECT_CALCULATOR v. 1.0");
        mainStage.initStyle(StageStyle.UNIFIED);
        mainStage.setResizable(false);
        mainStage.setScene(welcomeScene);
        mainStage.show();
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
