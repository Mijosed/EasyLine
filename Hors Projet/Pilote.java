public class Pilote {
    private int matricule;
    private String date_embauche;
    private int heures_realisees;
    

    //constructeur

    public Pilote ( int matricule, String date_embauche, int heures_realisees ){
        this.matricule = matricule;
        this.date_embauche = date_embauche ;
        this.heures_realisees = heures_realisees ;
    
    }

    public int getMatricule() {
        return matricule;
    }

    public String getDate_embauche() {
        return date_embauche;
    }

    public int getHeures_realisees() {
        return heures_realisees;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setDate_embauche(String date_embauche) {
        this.date_embauche = date_embauche;
    }

    public void setHeures_realisees(int heures_realisees) {
        this.heures_realisees = heures_realisees;
    }

    public String toString(){
        return "Pilote : " + "Date d'embauche : " + this.date_embauche + " Heures réalisées : " + this.heures_realisees + "h Numéro de matricule : " + this.matricule ;
    }

    public static void main (String args []){
        Pilote pil1 = new Pilote(243, "2 novembre 2023", 30);
        Pilote pil2 = new Pilote(125, "10 avril 2023", 75);
        System.out.println(pil1.toString());
        System.out.println(pil2);
    } 


}

