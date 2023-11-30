import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class VoyageController {

    @FXML
    private Button annuler;

    @FXML
    private TextField compagnie;

    @FXML
    private TextField date;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField lieu_arrivee;

    @FXML
    private TextField lieu_depart;
    

    @FXML
    private TextField prix;

    @FXML
    private Button valider;

    private VoyageDAO dao;

    public VoyageController() {
        this.dao = new VoyageDAO();
    }

    @FXML
    void effacerTout(ActionEvent event) {
        compagnie.setText("");
        lieu_depart.setText("");
        lieu_arrivee.setText("");
        date.setText("");
        prix.setText("");

    }

    @FXML
    public void effacerId(ActionEvent event) {
        idTextField.setText("");
    }

    @FXML
    void insertbdd(ActionEvent event) {

        try {
            // Création d'un objet voyage à partir des données saisies par l'utilisateur
            Voyage voyage = new Voyage(compagnie.getText(),lieu_depart.getText(),lieu_arrivee.getText(),date.getText(), Integer.parseInt(prix.getText()));
            
    
            // Ajout du voyage à la base de données
            dao.ajouterVol(voyage);
    
            // Affichage d'une alerte de confirmation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Le voyage a été ajouté avec succès.");
    
            alert.showAndWait();
    
        } catch (Exception e) {
            System.out.println("Une erreur est survenue lors de l'ajout du voyage : " + e.getMessage());
        }

    }

    @FXML
    public void deletebdd() {
        try {
            // Suppression du voyageur dans la base de données
            dao.supprimervol(Integer.parseInt(idTextField.getText()));
    
            // Affichage d'une alerte de confirmation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Le voyage a été supprimé avec succès.");
    
            alert.showAndWait();
    
        } catch (Exception e) {
            System.out.println("Une erreur est survenue lors de la suppression du vols : " + e.getMessage());
        }

}

}
