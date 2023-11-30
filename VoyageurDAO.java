import java.sql.*;
import java.util.*;

public class VoyageurDAO {

    // Variables de connexion à la base de données
    private String url = "jdbc:mysql://localhost:3307/myeasyline";
    private String username = "root";
    private String password = "root";
    //private String url = "jdbc:mysql://10.10.0.48:3306/myeasyline_mijose";
    //private String username = "mijose";
    //private String password = "1234";

    public VoyageurDAO() {
        
    }

// Constructeur prenant les informations de connexion en paramètre
public VoyageurDAO(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
}


// Méthode pour ajouter un nouveau voyageur sans particularité ni code privilège dans la base de données
public void ajouterVoyageur1(Voyageur voyageur, VoyageurPrivilege voyageurPrivilege, VoyageurParticularite voyageurParticularite, AdressePostale monAdressePostale) {
    try {
        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, username, password);

        // Requête SQL pour insérer un nouveau voyageur dans la table "voyageur"
        String sql = "INSERT INTO voyageur(nom, age, categorie, particularite, codePrivilege) VALUES (?, ?, ?, ?, ?)";

        // Préparation de la requête
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, voyageur.getNom());
        pstmt.setInt(2, voyageur.getAge());
        pstmt.setString(3, voyageur.getCategorie());
        pstmt.setString(4, voyageurParticularite.getparticularite());
        pstmt.setString(5, voyageurPrivilege.getCodeprivilege());

        // Exécution de la requête
        pstmt.executeUpdate();

        // Récupération de l'ID généré lors de l'insertion du voyageur
        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        int voyageurId = -1;
        if (generatedKeys.next()) {
            voyageurId = generatedKeys.getInt(1);
        }

        // Requête SQL pour insérer l'adresse postale dans la table "adressepostale"
        sql = "INSERT INTO adressepostale(adresse, ville, codepostal, id_voyageur) VALUES (?, ?, ?, ?)";

        // Préparation de la requête
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, monAdressePostale.getadresse());
        pstmt.setString(2, monAdressePostale.getVille());
        pstmt.setInt(3, monAdressePostale.getCodePostal());
        pstmt.setInt(4, voyageurId);

        // Exécution de la requête
        pstmt.executeUpdate();

        // Fermeture de la connexion
        conn.close();

        System.out.println("Le voyageur a été ajouté avec succès.");

    } catch (SQLException e) {
        System.out.println("Une erreur est survenue lors de l'ajout du voyageur : " + e.getMessage());
    }
}


// Méthode pour ajouter un nouveau voyageur avec une particularité dans la base de données
public void ajouterVoyageur2(VoyageurParticularite voyageur) {
    try {
        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, username, password);

        // Requête SQL pour insérer un nouveau voyageur dans la table "voyageur"
        String sql = "INSERT INTO voyageur(nom, age, categorie, particularite) VALUES(?, ?, ?, ? )";

        // Préparation de la requête
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, voyageur.getNom());
        pstmt.setInt(2, voyageur.getAge());
        pstmt.setString(3, voyageur.getCategorie());
        pstmt.setString(4, voyageur.getparticularite());

        // Exécution de la requête
        pstmt.executeUpdate();

        // Fermeture de la connexion
        conn.close();

        System.out.println("Le voyageur a été ajouté avec succès.");

    } catch (SQLException e) {
        System.out.println("Une erreur est survenue lors de l'ajout du voyageur : " + e.getMessage());
    }
}

// Méthode pour ajouter un nouveau voyageur avec une particularité dans la base de données
public void ajouterVoyageur3(VoyageurPrivilege voyageur) {
    try {
        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, username, password);

        // Requête SQL pour insérer un nouveau voyageur dans la table "voyageur"
        String sql = "INSERT INTO voyageur(nom, age, categorie, codePrivilege) VALUES(?, ?, ?, ? )";

        // Préparation de la requête
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, voyageur.getNom());
        pstmt.setInt(2, voyageur.getAge());
        pstmt.setString(3, voyageur.getCategorie());
        pstmt.setString(4, voyageur.getCodeprivilege());

        // Exécution de la requête
        pstmt.executeUpdate();

        // Fermeture de la connexion
        conn.close();

        System.out.println("Le voyageur a été ajouté avec succès.");

    } catch (SQLException e) {
        System.out.println("Une erreur est survenue lors de l'ajout du voyageur : " + e.getMessage());
    }
}

// Méthode pour mettre à jour les informations d'un voyageur dans la base de données
public void modifierVoyageur(Voyageur voyageur) {
    try {
        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, username, password);

        // Requête SQL pour mettre à jour les informations du voyageur dans la table "voyageur"
        String sql = "UPDATE voyageur SET nom=?, age=? WHERE id=?";

        // Préparation de la requête
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, voyageur.getNom());
        pstmt.setInt(2, voyageur.getAge());
        pstmt.setInt(3, voyageur.getId());

        // Exécution de la requête
        pstmt.executeUpdate();

        // Fermeture de la connexion
        conn.close();

        System.out.println("Le voyageur a été modifié avec succès.");

    } catch (SQLException e) {
        System.out.println("Une erreur est survenue lors de la modification du voyageur : " + e.getMessage());
    }
}

// Méthode pour supprimer un voyageur de la base de données
public void supprimerVoyageur1(int id) {
    try {
        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, username, password);

        // Requête SQL pour supprimer le voyageur de la table "voyageur"
        String sql = "DELETE FROM voyageur WHERE id=?";

        // Préparation de la requête
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        // Exécution de la requête
        pstmt.executeUpdate();

        // Fermeture de la connexion
        conn.close();

        System.out.println("Le voyageur a été supprimé avec succès.");

    } catch (SQLException e) {
        System.out.println("Une erreur est survenue lors de la suppression du voyageur : " + e.getMessage());
    }
}

public void afficherListeVoyageurs() {
    try {
        // Connexion à la base de données
        Connection conn = DriverManager.getConnection(url, username, password);

        // Requête SQL pour récupérer la liste des voyageurs dans la table "voyageur"
        String sql = "SELECT * FROM voyageur";

        // Préparation de la requête
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Exécution de la requête et récupération des résultats
        ResultSet rs = pstmt.executeQuery();

        // Parcours des résultats et affichage des informations des voyageurs
        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            int age = rs.getInt("age");
            String categorie = rs.getString("categorie");
            String particularite = rs.getString("particularite");
            int codePrivilege = rs.getInt("codePrivilege");

            System.out.println("ID : " + id);
            System.out.println("Nom : " + nom);
            System.out.println("Age : " + age);
            System.out.println("Catégorie : " + categorie);
            if (particularite != null) {
                System.out.println("Particularité : " + particularite);
            }
            if (codePrivilege != 0) {
                System.out.println("Code privilège : " + codePrivilege);
            }
            System.out.println();
        }

        // Fermeture de la connexion et des ressources
        rs.close();
        pstmt.close();
        conn.close();

    } catch (SQLException e) {
        System.out.println("Une erreur est survenue lors de la récupération de la liste des voyageurs : " + e.getMessage());
    }
}


    public static void main(String[] args) {
        VoyageurDAO dao = new VoyageurDAO("jdbc:mysql://10.10.0.48:3306/myeasyline_mijose","mijose","1234");
        // Création d'un nouveau voyageur
        Voyageur nouveauVoyageur = new Voyageur("John Doe", 65);
        // Ajout du voyageur à la base de données
        //dao.ajouterVoyageur1(nouveauVoyageur);
        //Création d'un nouveau voyageur avec une particularité 
        VoyageurParticularite nouveauVoyageur2 = new VoyageurParticularite("Mijose", 70, "1 bras");
        // Ajout du voyageur à la base de données
        //dao.ajouterVoyageur2(nouveauVoyageur2);
        VoyageurPrivilege nouveauVoyageur3 = new VoyageurPrivilege("Mijose", 70, "155");
        // Ajout du voyageur à la base de données
        //dao.ajouterVoyageur3(nouveauVoyageur3);
        // Suppression du voyageur de la base de données
        int id = 13;
        //dao.supprimerVoyageur1(id);
        dao.afficherListeVoyageurs();
    
}

}