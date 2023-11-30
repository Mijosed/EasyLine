import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;



public class Home_user extends Application {

   
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SceneBuilder/home_user.fxml"));
        primaryStage.setTitle("Home");
        primaryStage.setScene(new Scene(root, 640, 375));
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}