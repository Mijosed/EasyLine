import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BagageDAO {
    private final String url = "jdbc:mysql://localhost:3307/myeasyline";
    private final String utilisateur = "root";
    private final String motDePasse = "root";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, utilisateur, motDePasse);
    }

    public boolean insertBagage(Bagage bagage) {
        String sql = "INSERT INTO bagage (numero, couleur, poids) VALUES (?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bagage.getNumero());
            pstmt.setString(2, bagage.getCouleur());
            pstmt.setInt(3, bagage.getPoids());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteBagage(int id) {
        String sql = "DELETE FROM bagage WHERE id = ?";
        
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Création d'un nouveau bagage
        Bagage bagage = new Bagage(6, "rouge", 20);
        
        // Création d'un DAO pour les bagages
        BagageDAO dao = new BagageDAO();
        
        // Insertion du bagage dans la base de données
        if(dao.insertBagage(bagage)) {
            System.out.println("Bagage inséré avec succès !");
        } else {
            System.out.println("Erreur lors de l'insertion du bagage.");
        }

        // Suppression du bagage de la base de données
        int id = 2;
        if(dao.deleteBagage(id)) {
            System.out.println("Bagage supprimé avec succès !");
        } else {
            System.out.println("Erreur lors de la suppression du bagage.");
        }
    }
    
}
