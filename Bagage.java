public class Bagage {
    private int id;
    private int numero;
    private String couleur;
    private int poids;

// CONSTRUCTEUR

public Bagage (int num, String couleur, int poids ){
    this.numero = num;
    this.couleur = couleur;
    this.poids = poids ;

}

// ACCESSEUR

public int getNumero() {
    return numero;
}

public String getCouleur() {
    return couleur;
}

public int getPoids() {
    return poids;
}

public void setNumero(int numero) {
    this.numero = numero;
}
public void setCouleur(String couleur) {
    this.couleur = couleur;
}

public void setPoids(int poids) {
    this.poids = poids;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

// METHODE

public String toString(){
    return  "Numero : " + this.numero + ", Couleur : "+ this.couleur + ", Poids : "+ this.poids + "kg";
}

    
}
