public class VoyageurParticularite extends Voyageur {
    private String particularite;
    
    // CONSTRUCTEUR 

    public VoyageurParticularite(String nom, int age, String categorie, String particularite){
        this.particularite = particularite;
        super.nom = nom;
        super.age = age;
        super.categorie = categorie;

    }

    public VoyageurParticularite(String nom, int age, String particularite){
        this.particularite = particularite;
        super.nom = nom;
        super.age = age;
        determineCategorie();
        

    }

    public VoyageurParticularite(String particularite){
        this.particularite = particularite;
        
        

    }

    // ACCESSEUR

    public String getparticularite() {
        return particularite;
    }

    public void setparticularite(String particularite) {
        this.particularite = particularite;
    }

    // METHODE

    public String toString() {
        return super.toString() + this.particularite ;
    }

    // MAIN TEMPORAIRE

    public static void main (String args[]){
        VoyageurParticularite vg = new VoyageurParticularite("Mijose", 17, "enfant", "1 bras");
        vg.setNom("Patrick");
        vg.setparticularite("ampoule");
        System.out.println(vg.toString());
    
    }

}
