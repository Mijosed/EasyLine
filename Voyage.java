import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Voyage {
    int id;
    String compagnie;
    String lieu_depart;
    String lieu_arrivee;
    String date;
    int prix;

//CONSTRUCTEUR 

public Voyage (int id, String compagnie, String lieu_depart, String lieu_arrivee ,String date, int prix){
    this.id = id;
    this.compagnie = compagnie;
    this.lieu_depart = lieu_depart;
    this.lieu_arrivee = lieu_arrivee;
    this.date = date;
    this.prix = prix ;
}

public Voyage (String compagnie, String lieu_depart, String lieu_arrivee ,String date, int prix){
    this.compagnie = compagnie;
    this.lieu_depart = lieu_depart;
    this.lieu_arrivee = lieu_arrivee;
    this.date = date;
    this.prix = prix ;
}

// ACCESSEUR

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getCompagnie() {
    return compagnie;
}

public String getlieu_arrivee() {
    return lieu_arrivee;
}

public String getLieu_depart() {
    return lieu_depart;
}

public String getDate() {
    return date;
}

public int getPrix() {
    return prix;
}

public void setCompagnie(String compagnie) {
    this.compagnie = compagnie;
}

public void setlieu_arrivee(String lieu_arrivee) {
    this.lieu_arrivee = lieu_arrivee;
}

public void setLieu_depart(String lieu_depart) {
    this.lieu_depart = lieu_depart;
}

public void setDate(String date) {
    this.date = date;
}

public void setPrix(int prix) {
    this.prix = prix;
}


// METHODE 

public SimpleIntegerProperty idProperty() {
    return new SimpleIntegerProperty(id);
}

public SimpleStringProperty compagnieProperty() {
    return new SimpleStringProperty(compagnie);
}

public SimpleStringProperty LieuDepartProperty() {
    return new SimpleStringProperty(lieu_depart);
}

public SimpleStringProperty LieuArriveeProperty() {
    return new SimpleStringProperty(lieu_arrivee);
}

public SimpleStringProperty dateProperty() {
    return new SimpleStringProperty(date);
}

public SimpleIntegerProperty prixProperty() {
    return new SimpleIntegerProperty(prix);
}


}
