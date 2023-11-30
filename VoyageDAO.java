import java.sql.*;
import java.util.*;

public class VoyageDAO {
    
    // Variables de connexion à la base de données
    private String url = "jdbc:mysql://localhost:3307/myeasyline";
    private String username = "root";
    private String password = "root";
    //private String url = "jdbc:mysql://10.10.0.48/adminer.php?server=localhost&username=mijose&db=myeasyline";
    //private String username = "mijose";
    //private String password = "1234";

    public VoyageDAO() {
        
    }


// Constructeur prenant les informations de connexion en paramètre
public VoyageDAO(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
}

// Méthode pour ajouter un nouveau voyage dans la base de données
public void ajouterVol(Voyage voyage) {
    try {
        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, username, password);

        // Requête SQL pour insérer un nouveau voyage dans la table "voyage"
        String sql = "INSERT INTO voyage(compagnie, lieu_depart, lieu_arrivee, date, prix) VALUES (?, ?, ?, ?, ?)";

        // Préparation de la requête
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, voyage.getCompagnie());
        pstmt.setString(2, voyage.getLieu_depart());
        pstmt.setString(3, voyage.getlieu_arrivee());
        pstmt.setString(4, voyage.getDate());
        pstmt.setInt(5, voyage.getPrix());

        // Exécution de la requête
        pstmt.executeUpdate();

        // Fermeture de la connexion
        conn.close();

        System.out.println("Le voyage a été ajouté avec succès.");

    } catch (SQLException e) {
        System.out.println("Une erreur est survenue lors de l'ajout du vol : " + e.getMessage());
    }
}

public void supprimervol(int id) {
    try {
        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, username, password);

        // Requête SQL pour supprimer le voyageur de la table "voyageur"
        String sql = "DELETE FROM voyage WHERE id=?";

        // Préparation de la requête
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        // Exécution de la requête
        pstmt.executeUpdate();

        // Fermeture de la connexion
        conn.close();

        System.out.println("Le voyage a été supprimé avec succès.");

    } catch (SQLException e) {
        System.out.println("Une erreur est survenue lors de la suppression du vols : " + e.getMessage());
    }
}

public void reservebdd(int idVoyageur, int idVoyage) {
    try {
        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, username, password);

        // Requête SQL pour mettre à jour la colonne id_voyage de la table "voyageur"
        String sql = "UPDATE voyageur SET id_voyage = ? WHERE id = ?";

        // Préparation de la requête
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, idVoyage);
        pstmt.setInt(2, idVoyageur);

        // Exécution de la requête
        pstmt.executeUpdate();

        // Fermeture de la connexion
        conn.close();

        System.out.println("La réservation a été effectuée avec succès.");

    } catch (SQLException e) {
        System.out.println("Une erreur est survenue lors de la réservation : " + e.getMessage());
    }
}



}

