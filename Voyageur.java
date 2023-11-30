import java.util.*;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Voyageur{
    protected int id;
    protected String nom;
    protected int age;
    protected String categorie;
    protected AdressePostale monAdresse;
    protected Bagage monBagage;

    // CONSTRUCTEUR

    public Voyageur (String nom, int age, String categorie, AdressePostale monAdresse, Bagage monBagage){
        this.nom=nom;
        this.categorie =categorie;
        this.age=age;
        this.monAdresse=monAdresse;
        this.monBagage = monBagage;
    }
    
    public Voyageur (String nom, int age, String categorie, AdressePostale monAdresse){
        this.nom=nom;
        this.categorie =categorie;
        this.age=age;
        this.monAdresse=monAdresse;
        determineCategorie();
    
    }

    public Voyageur(){
    }

    public Voyageur(String nom, int age, String categorie){
        this.nom = nom;
        this.age=age;
        this.categorie=categorie;
        determineCategorie();
    }

    public Voyageur(String nom, int age){
        this.nom = nom;
        this.age=age;
        determineCategorie();
    }

    public Voyageur(int id,String nom, int age, AdressePostale monAdresse){
        this.id = id;
        this.nom = nom;
        this.age=age;
        this.monAdresse=monAdresse;
        determineCategorie();
    }

    public Voyageur(int id,String nom, int age, int ville){
        this.id = id;
        this.nom = nom;
        this.age=age;
        //this.ville=ville;
        determineCategorie();
    }

    
    // ACCESSEUR

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Bagage getMonBagage() {
        return monBagage;
    }

    public void setMonBagage(Bagage monBagage) {
        this.monBagage = monBagage;
    }

    public AdressePostale getMonAdresse() {
        return monAdresse;
    }

    public void setMonAdresse(AdressePostale monAdresse) {
        this.monAdresse = monAdresse;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // METHODE 

    public String toString(){
        return "Nom : "+this.nom + ", Age : "+ this.age + ", Adresse : "+ this.monAdresse + ", Bagage : " + this.monBagage;
    }

    protected void determineCategorie() {
        if (age < 1) {
            categorie = "Bébé";
        } else if (age <= 18) {
            categorie = "Enfant";
        } else if (age <= 60) {
            categorie = "Adulte";
        } else {
            categorie = "Sénior";
        }
    }

    public SimpleStringProperty nomProperty() {
        return new SimpleStringProperty(nom);
    }

    public SimpleIntegerProperty ageProperty() {
        return new SimpleIntegerProperty(age);
    }

    public SimpleIntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }

    public SimpleStringProperty adresseProperty() {
        return new SimpleStringProperty(monAdresse.toString());
    }


    // MAIN

    public static void main(String args []){

        //Voyageur
       
        Voyageur v1 = new Voyageur("Benji", 17, "enfant");
        AdressePostale adr1 = new AdressePostale("12bis Square de l'échiquier", "Cergy",95800);
        Bagage bag1 = new Bagage(1, "rouge", 10);
        Voyageur v2 = new Voyageur("Franck", 18,"touriste" ,adr1, bag1);
        System.out.println(v1);
        System.out.println(v2);

        //Agence Voyage 

        Scanner sc = new Scanner(System.in);

    AgenceVoyage ag = new AgenceVoyage("EasyLine",new AdressePostale("cergy"));
   // ag.setLesVoyageurs(mesVoyageurs);
    System.out.println(ag);

int choix =0;
  do{
    System.out.println("1. Ajout dun nouveau voyageur");
    System.out.println("2. Recherche dun utilisateur par son nom et son affichage");
    System.out.println("3. Suppression dun utilisateur par son nom et son affichage avant de supprimer pour confirmer");
    System.out.println("4. Affichage des informations de lagence de voyage (nom, adresse et liste des voyageurs");
    System.out.println("5. Quitter lapplication");
     choix = sc.nextInt();

    switch(choix){

        case 1 : ag.ajoutVoyageur();
        break;
        case 2 : ag.rechercheVoyageur();
        break;
        case 3 : //fff 
        break;
        case 4 : System.out.println(ag);
        System.out.println(ag.getLesVoyageurs());
        break;

    }
}while(choix != 5);

}

        //Voyageur Particularite

        /* 
        VoyageurParticularite vg = new VoyageurParticularite("pied cassé", "Bertrand");
        vg.setNom("Patrick");
        vg.setparticularite("ampoule");
        System.out.println(vg.toString());
        */

        //Main

        /* 
        ArrayList <Voyageur> Voyageurliste = new ArrayList<Voyageur>(); // a.
        Scanner sc = new Scanner(System.in); 
        System.out.println("Donne un nombre de voyageur"); //b.
        int nombre = sc.nextInt();
        sc.nextLine();
    

        String nom;
        int age;

        

        for (int i=0;i<nombre;i++);{
            System.out.println("nom et age");
            nom = sc.nextLine();
            age =sc.nextInt();
            sc.nextLine();
            Voyageur v = new Voyageur(nom,age);
            Voyageurliste.add(v);
            
        }
        
        for (Voyageur v : Voyageurliste){
            System.out.println(v);
        } 

        System.out.println(Voyageurliste); //c.

        
        
        //d. 2 recherche voyageur

        for(Voyageur v : Voyageurliste){
            if(v.getNom().equals(nom)){
                System.out.println(v);
                break;
            }
        }

        //e. suppression voyageur
        for(int i=0;i<Voyageurliste.size();i++){
            if(Voyageurliste.get(i).getNom().equals(nom)){
                Voyageurliste.remove(i);
                break;
            }
        }
        for (Voyageur v : Voyageurliste){
            System.out.println(v);
        }
         

        //f. suppression voyageur avec l'objet
        for(Voyageur v : Voyageurliste){
            if(v.getNom().equals(nom)){
                Voyageurliste.remove(v);
                break;
            }
        }
        for (Voyageur v : Voyageurliste){
            System.out.println(v);
        }
        
        */

       

        /*AdressePostale adrs = new AdressePostale("Cergy", 5, 95800);
        Bagage unBagage = new Bagage (2,"rouge", 20);
        Voyageur unVoyageur = new Voyageur("Joseph",20,adrs, unBagage);
        Voyageurliste.add(unVoyageur);
        //System.out.println(unVoyageur.toString());
        System.out.println(Voyageurliste); */
        
        
        
       
        
        /* System.out.println(adrs.toString());
        adrs.setCodePostal(9300);
        adrs.setVille("Argenteuil");
        adrs.setlibelle (6); // modification de l'adresse avec les 3 set 
        System.out.println(adrs.toString()); // affichage de l'adresse 
        System.out.println(unVoyageur.toString()); 
        System.out.println(unBagage.toString()); // affichage du bagage
        unBagage.setCouleur("bleu"); // modification couleur bagage
        unBagage.setPoids(15); // modification poids bagage
        System.out.println(unBagage.toString()); */
        
    
       /* Voyageur deuzVoyageur = new Voyageur();
          deuzVoyageur.nom="Jo2";
        deuzVoyageur.age=25;
        System.out.println(deuzVoyageur.toString());
   
        Scanner sc = new Scanner(System.in);
        System.out.println("son nom?");
        String a=sc.nextLine();
        deuzVoyageur.nom=a;
        System.out.println(deuzVoyageur.toString()); */


    }

   


