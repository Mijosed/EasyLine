import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.*;

public class ReservationController {

    @FXML
    private Button Réserver;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField idTextField1;

    private VoyageDAO dao;

    public ReservationController() {
        this.dao = new VoyageDAO();
    }

    @FXML
    void reservebdd(ActionEvent event) {
        int idVoyage = Integer.parseInt(idTextField.getText());
        int idVoyageur = Integer.parseInt(idTextField1.getText());

        try {
            dao.reservebdd(idVoyageur, idVoyage);

            // Affichage d'une alerte de confirmation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("La réservation a été effectuée avec succès.");

            alert.showAndWait();

        } catch (Exception e) {
            System.out.println("Une erreur est survenue lors de la réservation : " + e.getMessage());
        }
    }

}

