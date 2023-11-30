import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class home_usercontroller {

    @FXML
    private Menu edit;

    @FXML
    private MenuItem enregistrement;

    @FXML
    void quitter(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void savevoyageur(ActionEvent event) {
        try {
            Parent voyageurRoot = FXMLLoader.load(getClass().getResource("SceneBuilder/voyageur.fxml"));
            Stage voyageurStage = new Stage();
            voyageurStage.setTitle("Voyageur");
            voyageurStage.setScene(new Scene(voyageurRoot));
            voyageurStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void listvoyageur(ActionEvent event) {
        try {
            Parent listvoyageurRoot = FXMLLoader.load(getClass().getResource("SceneBuilder/liste-voyageur.fxml"));
            Stage voyageurStage = new Stage();
            voyageurStage.setTitle("Liste Voyageur");
            voyageurStage.setScene(new Scene(listvoyageurRoot));
            voyageurStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void listvols(ActionEvent event) {
        try {
            Parent listvolsRoot = FXMLLoader.load(getClass().getResource("SceneBuilder/liste-voyage.fxml"));
            Stage volsStage = new Stage();
            volsStage.setTitle("Liste Vols");
            volsStage.setScene(new Scene(listvolsRoot));
            volsStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void reservevols(ActionEvent event) {
        try {
            Parent reservevolsRoot = FXMLLoader.load(getClass().getResource("SceneBuilder/reservationvols.fxml"));
            Stage reservevolsStage = new Stage();
            reservevolsStage.setTitle("Liste Vols");
            reservevolsStage.setScene(new Scene(reservevolsRoot));
            reservevolsStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


