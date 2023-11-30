public class VoyageurPrivilege extends Voyageur {
    private String codeprivilege ;

// CONSTRUCTEUR

public VoyageurPrivilege (String nom, int age, String categorie, String codeprivilege){
    this.codeprivilege = codeprivilege;
    super.nom = nom;
    super.age = age;
    super.categorie = categorie;
}

public VoyageurPrivilege (String nom, int age, String codeprivilege){
    this.codeprivilege = codeprivilege;
    super.nom = nom;
    super.age = age;
    determineCategorie();
}

public VoyageurPrivilege (String codeprivilege){
    this.codeprivilege = codeprivilege;
}
// ACCESSEUR

public String getCodeprivilege() {
    return codeprivilege;
}

public void setCodeprivilege(String codeprivilege) {
    this.codeprivilege = codeprivilege;
}

// METHODE

public String toString() {
    return super.nom + this.codeprivilege ;
}

// MAIN TEMPORAIRE
public static void main (String args[]){
    VoyageurPrivilege vg = new VoyageurPrivilege("Bertrand", 19,"enfant","501");
    vg.setNom("Patrick");
    vg.setCodeprivilege("522");
    System.out.println(vg.toString());

}

}
