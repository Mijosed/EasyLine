import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main3 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SceneBuilder/agence.fxml"));
        primaryStage.setTitle("Enregistrement d'une agence");
        primaryStage.setScene(new Scene(root, 750, 450));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
