package Objets;

/**
 * Classe qui représente les différentes classes de héros
 */
public class Arme {
    protected int exp;
    protected int niveau;
    protected String type;
    protected int attaque_arme;
    protected int pv_arme;
    protected int defense_arme;
    protected int maitriseElem_arme;

    /**
     * Constructeur de l'arme
     * @param niveau Gestion du niveau du héros
     * @param type Gestion de la classe du héros
     */
    public Arme(int niveau, String type) {
        this.niveau = niveau;
        this.type = type;
        switch (type) {
            case "arc" -> {
                attaque_arme = 15 + (niveau - 1) * 10;
                pv_arme = 100 + (niveau - 1) * 10;
                defense_arme = 5 + (niveau - 1) * 10;
                maitriseElem_arme = 30 + (niveau - 1) * 10;
            }
            case "epee" -> {
                attaque_arme = 35 + (niveau - 1) * 10;
                pv_arme = 120 + (niveau - 1) * 10;
                defense_arme = 30 + (niveau - 1) * 10;
                maitriseElem_arme = 0 + (niveau - 1) * 10;
            }
            case "claymore" -> {
                attaque_arme = 40 + (niveau - 1) * 10;
                pv_arme = 220 + (niveau - 1) * 10;
                defense_arme = 50 + (niveau - 1) * 10;
                maitriseElem_arme = 0 + (niveau - 1) * 10;
            }
            case "lance" -> {
                attaque_arme = 25 + (niveau - 1) * 10;
                pv_arme = 70 + (niveau - 1) * 10;
                defense_arme = 15 + (niveau - 1) * 10;
                maitriseElem_arme = 20 + (niveau - 1) * 10;
            }
            case "mage" -> {
                attaque_arme = 5 + (niveau - 1) * 10;
                pv_arme = 50 + (niveau - 1) * 10;
                defense_arme = 10 + (niveau - 1) * 10;
                maitriseElem_arme = 50 + (niveau - 1) * 10;
            }
        }
    }

    public int getExp(){
        return exp;
    }
    public void setExp(int expToSet){
        exp = expToSet;
    }
    public int getNiveau(){
        return niveau;
    }
    public void setNiveau(int niveauToSet){
        niveau = niveauToSet;
    }
}
