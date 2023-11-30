import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main6 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SceneBuilder/deletevoyageur.fxml"));
        primaryStage.setTitle("Suppression voyageur");
        primaryStage.setScene(new Scene(root, 750, 450));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}