import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.*;

public class AgenceVoyageController {

    @FXML
    private TextField adresse;

    @FXML
    private Button annuler;

    @FXML
    private TextField cp;

    @FXML
    private TextField id;

    @FXML
    private TextField nom;

    @FXML
    private Button valider;

    @FXML
    private TextField ville;

    @FXML
    void effacerTout(ActionEvent event) {
        nom.setText("");
        ville.setText("");
        nom.setText("");
        cp.setText("");
        adresse.setText("");
        id.setText("");
        
    }

    private AgenceVoyageDAO dao;

    public AgenceVoyageController() {
    this.dao = new AgenceVoyageDAO();
}

    @FXML
    void insertbdd(ActionEvent event) {

        try {
            // Création d'un objet Voyageur à partir des données saisies par l'utilisateur
            AgenceVoyage agenceVoyage = new AgenceVoyage( Integer.parseInt(id.getText()), nom.getText());
            AdressePostale monAdressePostale = new AdressePostale(adresse.getText(), ville.getText(), Integer.parseInt(cp.getText()));
            
    
            // Ajout du voyageur à la base de données
            dao.ajouterAgence1(agenceVoyage ,monAdressePostale);
    
            // Affichage d'une alerte de confirmation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("L'agence' a été ajouté avec succès.");
    
            alert.showAndWait();
    
        } catch (Exception e) {
            System.out.println("Une erreur est survenue lors de l'ajout de l'agence : " + e.getMessage());
        }

    }

}

