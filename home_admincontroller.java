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

public class home_admincontroller {

    @FXML
    private Menu edit;

    @FXML
    private MenuItem enregistrement;

    @FXML
    void quitter(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void savevols(ActionEvent event) {
        try {
            Parent volsRoot = FXMLLoader.load(getClass().getResource("SceneBuilder/voyage.fxml"));
            Stage vols1Stage = new Stage();
            vols1Stage.setTitle("Vols");
            vols1Stage.setScene(new Scene(volsRoot));
            vols1Stage.show();
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
    void deletevoyageur(ActionEvent event) {
        try {
            Parent deleteRoot = FXMLLoader.load(getClass().getResource("SceneBuilder/deletevoyageur.fxml"));
            Stage deleteStage = new Stage();
            deleteStage.setTitle("Supprimer Voyageur");
            deleteStage.setScene(new Scene(deleteRoot));
            deleteStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deletevols(ActionEvent event) {
        try {
            Parent delete1Root = FXMLLoader.load(getClass().getResource("SceneBuilder/deletevols.fxml"));
            Stage delete1Stage = new Stage();
            delete1Stage.setTitle("Supprimer Vols");
            delete1Stage.setScene(new Scene(delete1Root));
            delete1Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}