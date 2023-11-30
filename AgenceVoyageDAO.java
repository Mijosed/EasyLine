import java.sql.*;
import java.util.*;

public class AgenceVoyageDAO {

    // Variables de connexion à la base de données
    private String url = "jdbc:mysql://localhost:3307/myeasyline";
    private String username = "root";
    private String password = "root";
    //private String url = "jdbc:mysql://10.10.0.48/adminer.php?server=localhost&username=mijose&db=myeasyline";
    //private String username = "mijose";
    //private String password = "1234";

    public AgenceVoyageDAO() {
        
    }

    // Constructeur prenant les informations de connexion en paramètre
public AgenceVoyageDAO(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
}

// Méthode pour ajouter un nouveau voyageur sans particularité ni code privilège dans la base de données
public void ajouterAgence1(AgenceVoyage agenceVoyage, AdressePostale monAdressePostale) {
    try {
        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, username, password);

        // Requête SQL pour insérer un nouveau voyageur dans la table "voyageur"
        String sql = "INSERT INTO agencevoyage(id, nom) VALUES (?, ?)";

        // Préparation de la requête
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, agenceVoyage.getId());
        pstmt.setString(2, agenceVoyage.getNom());

        // Exécution de la requête
        pstmt.executeUpdate();

        // Récupération de l'ID généré lors de l'insertion de l'agence
        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        int agenceId = -1;
        if (generatedKeys.next()) {
            agenceId = generatedKeys.getInt(1);
        }

        // Requête SQL pour insérer l'adresse postale dans la table "adressepostale"
        sql = "INSERT INTO adressepostale(adresse, ville, codepostal, id_agence) VALUES (?, ?, ?, ?)";

        // Préparation de la requête
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, monAdressePostale.getadresse());
        pstmt.setString(2, monAdressePostale.getVille());
        pstmt.setInt(3, monAdressePostale.getCodePostal());
        pstmt.setInt(4, agenceId);

        // Exécution de la requête
        pstmt.executeUpdate();

        // Fermeture de la connexion
        conn.close();

        System.out.println("L'agence a été ajouté avec succès.");

    } catch (SQLException e) {
        System.out.println("Une erreur est survenue lors de l'ajout du voyageur : " + e.getMessage());
    }
}


}
