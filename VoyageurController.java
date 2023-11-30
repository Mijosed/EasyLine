import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.*;



public class VoyageurController{

    @FXML
    private TextField adresse;

    @FXML
    private TextField age;

    @FXML
    private Button annuler;

    @FXML
    private TextField cp;

    @FXML
    private TextField nom;

    @FXML
    private Button valider;

    @FXML
    private TextField ville;

    @FXML
    private TextField particularite;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField code_privilege;

    private VoyageurDAO dao;

    public VoyageurController() {
    this.dao = new VoyageurDAO();
}

    @FXML
    public void effacerTout(ActionEvent event) {
        nom.setText("");
        ville.setText("");
        nom.setText("");
        cp.setText("");
        adresse.setText("");
        age.setText("");
        particularite.setText("");
        code_privilege.setText("");


    }

    @FXML
    public void effacerId(ActionEvent event) {
        idTextField.setText("");
    }

    @FXML
    public void insertbdd() {
    try {
        // Création d'un objet Voyageur à partir des données saisies par l'utilisateur
        Voyageur voyageur = new Voyageur(nom.getText(), Integer.parseInt(age.getText()));
        AdressePostale monAdressePostale = new AdressePostale(adresse.getText(), ville.getText(), Integer.parseInt(cp.getText()));
        VoyageurParticularite voyageurParticularite = new VoyageurParticularite (particularite.getText());
        VoyageurPrivilege voyageurPrivilege = new VoyageurPrivilege(code_privilege.getText());

        // Ajout du voyageur à la base de données
        dao.ajouterVoyageur1(voyageur, voyageurPrivilege, voyageurParticularite, monAdressePostale);

        // Affichage d'une alerte de confirmation
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Le voyageur a été ajouté avec succès.");

        alert.showAndWait();

    } catch (Exception e) {
        System.out.println("Une erreur est survenue lors de l'ajout du voyageur : " + e.getMessage());
    }
}
         
    
        @FXML
        public void deletebdd() {
        try {
            // Suppression du voyageur dans la base de données
            dao.supprimerVoyageur1(Integer.parseInt(idTextField.getText()));
    
            // Affichage d'une alerte de confirmation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Le voyageur a été supprimé avec succès.");
    
            alert.showAndWait();
    
        } catch (Exception e) {
            System.out.println("Une erreur est survenue lors de la suppression du voyageur : " + e.getMessage());
        }

}

}