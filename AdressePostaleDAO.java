import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdressePostaleDAO {
    private final String url = "jdbc:mysql://localhost:3307/myeasyline";
    private final String utilisateur = "root";
    private final String motDePasse = "root";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, utilisateur, motDePasse);
    }

    public boolean insertAdressePostale(AdressePostale adresse) {
        String sql = "INSERT INTO adressepostale (adresse, ville, codePostal ) VALUES (?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, adresse.getadresse());
            pstmt.setString(2, adresse.getVille());
            pstmt.setInt(3, adresse.getCodePostal());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion de l'adresse.");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteAdressePostaleById(int id) {
        String sql = "DELETE FROM adressepostale WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'adresse.");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void afficherToutesLesAdresses() {
        String sql = "SELECT * FROM adressepostale";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Toutes les adresses postales de la base de données :");
            while (rs.next()) {
                System.out.println(rs.getString("adresse") + " " + rs.getString("ville") + " " + rs.getInt("codePostal"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        AdressePostaleDAO dao = new AdressePostaleDAO();

        AdressePostale adresse1 = new AdressePostale("12 bis Square de l'échiquer", "Cergy", 95800);
        //dao.insertAdressePostale(adresse1);

        dao.afficherToutesLesAdresses();

        //dao.deleteAdressePostaleById(2);

    }
}
