import java.util.*;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AdressePostale {
    private int id;
    private String adresse;
    private String ville;
    private int CodePostal; 

// CONSTRUCTEUR

public AdressePostale (String adresse, String ville, int cp ){
    this.adresse = adresse;
    this.CodePostal = cp;
    this.ville = ville;

}

public AdressePostale (String ville ){
    this.ville = ville;

}

// ACCESSEUR

public String getadresse() {
    return adresse;
}

public void setadresse(String adresse) {
    this.adresse = adresse;
}

public int getCodePostal() {
    return CodePostal;
}

public void setCodePostal(int codePostal) {
    CodePostal = codePostal;
}

public String getVille() {
    return ville;
}

public void setVille(String ville) {
    this.ville = ville;
}

// METHODE

public String toString(){
    return  this.adresse + " "+ this.ville + " "+ this.CodePostal;
} 

public SimpleStringProperty adresseProperty() {
    return new SimpleStringProperty(adresse);
}

public SimpleStringProperty villeProperty() {
    return new SimpleStringProperty(ville);
}

public SimpleIntegerProperty cpProperty() {
    return new SimpleIntegerProperty(CodePostal);
}



}
