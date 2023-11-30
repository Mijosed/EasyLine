import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConnexionController {
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        // Effectuez ici les actions de connexion en utilisant l'email et le mot de passe
        // Par exemple, vous pouvez vérifier les informations d'identification dans votre base de données
    }
}
