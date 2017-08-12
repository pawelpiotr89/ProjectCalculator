package projectCalculatorMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import projectCalculatorControllers.MainPaneController;

/**
 *
 * @author Roxven89
 */
public class ProjectCalculator extends Application {

    private static Stage mainStage;
    private Scene mainScene;
    private Pane mainPane;
    private Cursor cursor;
    private ExitAlertWindow exitAlertWindow;

    @Override
    public void start(Stage stage) throws Exception {

        setPrimaryStage(stage);
        cursor = Cursor.DEFAULT;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ProjectCalculator.class.getResource("/projectCalculatorFXML/FXMLMainPane.fxml"));
        mainPane = loader.load();
        MainPaneController mainPaneController = loader.getController();

        mainScene = new Scene(mainPane);
        mainScene.setCursor(cursor);

        mainStage.setOnCloseRequest(e -> {
            e.consume();
            exitAlertWindow = new ExitAlertWindow();
            exitAlertWindow.askingQuestion();
        });

        mainStage.setTitle("PROJECT_CALCULATOR v. 1.0");
        mainStage.initStyle(StageStyle.UTILITY);
        mainStage.setResizable(false);
        mainStage.setScene(mainScene);
        mainStage.show();

    }

    private void setPrimaryStage(Stage stage) {
        ProjectCalculator.mainStage = stage;
    }

    static public Stage getPrimaryStage() {
        return mainStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
