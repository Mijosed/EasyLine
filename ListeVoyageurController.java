import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.*;



public class ListeVoyageurController {

    @FXML
    private TableColumn<Voyageur, Integer> id;

    @FXML
    private TableColumn<Voyageur, String> nom;

    @FXML
    private TableColumn<Voyageur, Integer> age;

    @FXML
    private TableColumn<Voyageur, String> adresse;

    @FXML
    private TableColumn<Voyageur, String> ville;

    @FXML
    private TableColumn<Voyageur, Integer> cp;

    @FXML
    private TableView<Voyageur> tableau;

    public void initialize() {
        try {
            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/myeasyline", "root", "root");

            // Create a statement to execute the SQL query
            Statement stmt = conn.createStatement();

            // Execute the SQL query to retrieve the id, nom and prenom columns from the database
            //ResultSet rs = stmt.executeQuery("SELECT id, nom, age FROM voyageur");
            ResultSet rs = stmt.executeQuery("SELECT v.id, v.nom, v.age, a.adresse, a.ville, a.codePostal FROM voyageur v INNER JOIN adressepostale a ON v.id = a.id_voyageur");

            // Create an ObservableList to store the Voyageur objects
            ObservableList<Voyageur> voyageurs = FXCollections.observableArrayList();

            // Loop through the result set and add the data to the ObservableList
            while (rs.next()) {
                int voyageurId = rs.getInt("v.id");
                String voyageurNom = rs.getString("v.nom");
                int voyageurAge = rs.getInt("v.age");
                String voyageurAdresse = rs.getString("adresse");
                String voyageurVille = rs.getString("ville");
                int voyageurCodePostal = rs.getInt("codepostal");
                AdressePostale voyageurAdresse1 = new AdressePostale (voyageurAdresse, voyageurVille, voyageurCodePostal);
                Voyageur voyageur = new Voyageur(voyageurId,voyageurNom, voyageurAge, voyageurAdresse1 );
                voyageurs.add(voyageur);
            }

            // Set the ObservableList as the items of the TableView
            tableau.setItems(voyageurs);

            // Bind the properties of Voyageur objects to the columns of the TableView
            id.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            nom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
            age.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
            adresse.setCellValueFactory(cellData -> cellData.getValue().adresseProperty());
            

            // Close the connection and statement
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
