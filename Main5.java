import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;

public class Main5 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SceneBuilder/liste-voyage.fxml"));
        primaryStage.setTitle("Liste de vols");
        primaryStage.setScene(new Scene(root, 750, 450));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}