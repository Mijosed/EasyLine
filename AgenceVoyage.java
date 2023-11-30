import java.util.*;


public class AgenceVoyage {
    private int id;
    private String nom;
    private AdressePostale adr;
    private ArrayList<Voyageur> lesVoyageurs = new ArrayList<Voyageur>() ;

// CONSTRUCTEUR

public AgenceVoyage(String nom, AdressePostale adr ){

    this.nom = nom;
    this.adr = adr;
}

public AgenceVoyage(int id, String nom ){

    this.id = id;
    this.nom = nom;
}

// ACCESSEUR

public AdressePostale getAdr() {
    return adr;
}

public void setAdr(AdressePostale adr) {
    this.adr = adr;
}

public String getNom() {
    return nom;
}

public void setNom(String nom) {
    this.nom = nom;
}

public ArrayList<Voyageur> getLesVoyageurs() {
    return lesVoyageurs;
}

public void setLesVoyageurs(ArrayList<Voyageur> lesVoyageurs) {
    this.lesVoyageurs = lesVoyageurs;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

// METHODE

public String toString() {
    return this.getNom()+ " " + this.getAdr()  ;
}

public void ajoutVoyageur(){
    Scanner sc = new Scanner(System.in);
    System.out.println("nom et age");
    String nom;
    int age;
            nom=sc.nextLine();
            age=sc.nextInt();
    Voyageur v = new Voyageur(nom,age);
    this.lesVoyageurs.add(v);
}

public void rechercheVoyageur(){
    System.out.println("Tej un nom");
    Scanner sc = new Scanner(System.in);
    nom = sc.nextLine();
    for(Voyageur v : lesVoyageurs){
        if(v.getNom().equals(nom)){
            System.out.println(v);
            break;
        }
    }

}

public void supprimeVoyageur(){  // a faire 
    System.out.println("Supprime un nom");
    Scanner sc = new Scanner(System.in);
    nom = sc.nextLine();
    for(Voyageur v : lesVoyageurs){
        if(v.getNom().equals(nom)){
            System.out.println(v);
            break;
        }
    }

}


}


