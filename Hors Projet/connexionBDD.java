import java.sql.*;

public class connexionBDD {
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3307/myeasyline";
    private String user = "root";
    private String password = "root";

    public connexionBDD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion réussie !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        try {
            // Chargement du driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connexion à la base de données MySQL
            String url = "jdbc:mysql://localhost:3307/myeasyline";
            String user = "root";
            String password = "root";
            Connection conn = DriverManager.getConnection(url, user, password);

            // Exécution d'une requête SQL
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM voyageur");

            // Traitement des résultats
            while (rs.next()) {
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String nom = rs.getString("nom");
                System.out.println("id = " + id + ", nom = " + nom + ", age = " + age);
            }

            // Fermeture des ressources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


