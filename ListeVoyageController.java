import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Button;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.*;



public class ListeVoyageController {

    @FXML
    private Button afficher;

    @FXML
    private TableColumn<Voyage, String> compagnie;

    @FXML
    private TableColumn<Voyage, String> date;

    @FXML
    private TableColumn<Voyage, Integer> id;

    @FXML
    private TableColumn<Voyage, String> lieu_arrivee;

    @FXML
    private TableColumn<Voyage, Integer> prix;

    @FXML
    private TableColumn<Voyage, String> lieu_depart;

    @FXML
    private TableColumn<Voyage, String> nom_resa;

    @FXML
    private Button retour;

    @FXML
    private TableView<Voyage> tableau;

    public void initialize() {
        try {
            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/myeasyline", "root", "root");

            // Create a statement to execute the SQL query
            Statement stmt = conn.createStatement();

            // Execute the SQL query to retrieve the id, nom and prenom columns from the database
            //ResultSet rs = stmt.executeQuery("SELECT id, nom, age FROM voyage");
            //ResultSet rs = stmt.executeQuery("SELECT v.id, v.compagnie, v.lieu_depart, v.lieu_arrivee, v.date, v.prix, b.nom AS 'nom_voyage' FROM voyage v LEFT JOIN voyage b ON v.id = b.id_voyage");
            ResultSet rs = stmt.executeQuery("SELECT id, compagnie, lieu_depart, lieu_arrivee, date, prix FROM voyage");

            // Create an ObservableList to store the voyage objects
            ObservableList<Voyage> voyages = FXCollections.observableArrayList();

            // Loop through the result set and add the data to the ObservableList
            while (rs.next()) {
                int voyageId = rs.getInt("id");
                String voyagecompagnie = rs.getString("compagnie");
                String voyageLieu_depart = rs.getString("lieu_depart");
                String voyageLieu_arrivee = rs.getString("lieu_arrivee");
                String voyageDate = rs.getString("date");
                int voyagePrix = rs.getInt("prix");
                //AdressePostale voyageAdresse1 = new AdressePostale (voyageAdresse, voyageVille, voyageCodePostal);
                Voyage voyage = new Voyage(voyageId,voyagecompagnie,voyageLieu_depart,voyageLieu_arrivee,voyageDate,voyagePrix );
                voyages.add(voyage);
            }

            // Set the ObservableList as the items of the TableView
            tableau.setItems(voyages);

            // Bind the properties of voyage objects to the columns of the TableView
            id.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            compagnie.setCellValueFactory(cellData -> cellData.getValue().compagnieProperty());
            lieu_depart.setCellValueFactory(cellData -> cellData.getValue().LieuDepartProperty());
            lieu_arrivee.setCellValueFactory(cellData -> cellData.getValue().LieuArriveeProperty());
            date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
            prix.setCellValueFactory(cellData -> cellData.getValue().prixProperty().asObject());
            

            // Close the connection and statement
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
