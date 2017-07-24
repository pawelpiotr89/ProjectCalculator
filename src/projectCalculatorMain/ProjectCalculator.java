package projectCalculatorMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import projectCalculatorControllers.MainPaneController;
/**
 *
 * @author Roxven89
 */
public class ProjectCalculator extends Application {

    private Stage mainStage;
    private Scene mainScene;
    private AnchorPane mainPane;
    private Cursor cursor;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        mainStage = stage;
        cursor = Cursor.CROSSHAIR;
     
        FXMLLoader mainPaneLoader = new FXMLLoader();
        mainPaneLoader.setLocation(ProjectCalculator.class.getResource("/projectCalculatorsFXML/FXMLMainPane.fxml"));
        mainPane = mainPaneLoader.load();
        
        MainPaneController mainPaneController = mainPaneLoader.getController();
        
        mainScene = new Scene(mainPane);
        mainScene.setCursor(cursor);
        
        mainStage.setTitle("PROJECT_CALCULATOR v. 1.0");
        mainStage.initStyle(StageStyle.UNIFIED);
        mainStage.setResizable(false);
        mainStage.setScene(mainScene);
        mainStage.show();
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
