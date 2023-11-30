import java.util.*;
public class Compagnie {
    
    private String nom;
    private int code;
    private double ca;
    private String couleurPrincipaleLogo;
    private String couleurSecondaireLogo; /* 15. ajouter une couleur secondaire */


    public String getNom() {
        return nom;
    }

    public int getCode() {
        Scanner sc = new Scanner(System.in); /* étape 25.1 demander mdp pour accès au code */
        String mdp= sc.nextLine();
        if(mdp.equals("secret")){
            return code;
        }else{
            System.out.println("adios");
            return 0;
        }
    }

    public double getCa() {
        return ca;
    }

    public String getCouleurPrincipaleLogo() {
        return couleurPrincipaleLogo;
    }

    public String getCouleurSecondaireLogo() {
        return couleurSecondaireLogo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCode(int code) { /* Etape 26.2 Vérifiez le mot de passe pour toute modification sur le code de la compagnie */
        Scanner sc2 = new Scanner (System.in);
        String mdp = sc2.nextLine();
        if(mdp.equals("secret")){
            this.code = code;
        }else{
            System.out.println("adios");
    
        }
    }

    public void setCa(double ca) { /* Etape 26.3 Vérifiez le mot de passe pour toute modification sur le ca de la compagnie */
        Scanner sc3 = new Scanner (System.in);
        String mdp = sc3.nextLine();
        if(mdp.equals("secret")){
            this.ca = ca;
        }else{
            System.out.println("adios");
    
        }
    }

    public void setCouleurPrincipaleLogo(String couleurPrincipaleLogo) {
        this.couleurPrincipaleLogo = couleurPrincipaleLogo;
    }

    public void setCouleurSecondaireLogo(String couleurSecondaireLogo) {
        this.couleurSecondaireLogo = couleurSecondaireLogo;
    }
    
 
    public Compagnie(){
    }
    public Compagnie(String nomCompagnie){
        this.nom=nomCompagnie;
    }
    public Compagnie(String nomCompagnie,String couleur1, String couleur2 ){
        this.nom=nomCompagnie;
        this.couleurPrincipaleLogo = couleur1 ;
        this.couleurSecondaireLogo = couleur2 ;
        /* 18. creer un nouveau constructeur */   

    }
    public Compagnie(String nomCompagnie,String couleurpr, String couleursc, int code ){
        this.nom=nomCompagnie;
        this.couleurPrincipaleLogo = couleurpr ;
        this.couleurSecondaireLogo = couleursc ;
        this.code = code ;
        /* 21. creer un nouveau constructeur */    

    }
    public void afficher(){
        System.out.println(this.nom);
        System.out.println(this.code); 
        System.out.println(this.couleurPrincipaleLogo);
        System.out.println(this.couleurSecondaireLogo);
    }
    public static void main(String[] args){
        Compagnie maCompagnie1= new Compagnie();
        maCompagnie1.nom="zaza";
        maCompagnie1.code=(95); /* 5. code donnée à la compagnie1 */
        maCompagnie1.couleurPrincipaleLogo="orange"; /* 9. couleur principale donnée au logo de la compagnie1 */
        maCompagnie1.couleurSecondaireLogo="vert"; /* 16. mettre couleur secondaire */
        //maCompagnie1.afficher(); /* 17. */
        
        Compagnie maCompagnie2= new Compagnie("zozo");
        maCompagnie2.code=(78); /* 7. code donnée à la compagnie2 */
        maCompagnie2.couleurPrincipaleLogo="vert"; /* étape 12 */
        //maCompagnie2.afficher(); /* 11. afficher maCompagnie2 */
        
        Compagnie maCompagnie3= new Compagnie("easyJune"); /* 2. réalisation d'une nouvelle compagnie */
        maCompagnie3.code=(94); /* étape 12 */
        maCompagnie3.couleurPrincipaleLogo="bleu"; /* étape 12 */
        //maCompagnie3.afficher();
        //maCompagnie3.setCode(2300); /* Etape 26.2 Vérifiez le mot de passe pour toute modification sur le code de la compagnie */
        //System.out.println(maCompagnie3.getCode());

        maCompagnie3.setCa(10);
        //System.out.println(maCompagnie3.getCa()); /* Etape 26.3 Vérifiez le mot de passe pour toute modification sur le ca de la compagnie */
        //System.out.println(maCompagnie3.getCa());
        //maCompagnie3.setCa(maCompagnie3.getCa()*1.3); /* étape 26.1 augmenter de 30% le CA */
        //System.out.println(maCompagnie3.getCa());
        
        Compagnie maCompagnie4= new Compagnie("AirFrance"); /* 3. réalisation d'une nouvelle compagnie */
        maCompagnie4.code=(93); /* étape 12 */
        maCompagnie4.couleurPrincipaleLogo="jaune"; /* étape 12 */
        //maCompagnie4.afficher();
        
        Compagnie maCompagnie5= new Compagnie(); /* 4. réalisation d'une nouvelle compagnie */
        maCompagnie5.nom="AirCongo";
        maCompagnie5.code=(95); /* étape 12 */
        maCompagnie5.couleurPrincipaleLogo="violet"; /* étape 12 */
        //maCompagnie5.afficher();  /* étape 19 et 20 */
        //System.out.println(maCompagnie5.getCode()); /* étape 25.1 demander mdp pour accès au code */

        Compagnie maCompagnie6 = new Compagnie("AirAlger", "bleu", "violet");
        //maCompagnie6.afficher(); /* étape 24*/

        Compagnie maCompagnie7 = new Compagnie("AirTunisia", "blanc", "rose", 97);
        //maCompagnie7.afficher(); /* étape 23*/
        //System.out.println(maCompagnie7.getCouleurSecondaireLogo()+" second"); /* étape 25.2 retouner couleur secondaire + second */



        
       
    }
}