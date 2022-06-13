package Personnages;

public class Ennemis {

    protected String nom;
    protected String element;
    public int niveau; //Allant de 10 en 10 en général
    protected int attaque_base;
    protected int pv_base;
    protected int défense_base;
    protected int maîtriseElem_base;

    //TODO : En fonction du type d'ennemi avec un switch case
    public Ennemis(String nom, int niveau, String element)
    {
        this.nom = nom;
        this.niveau = niveau;
        this.element = element;
        attaque_base = 20 + niveau;
        pv_base = 290 + niveau;
        défense_base = 5 + niveau;
        maîtriseElem_base = 10 + niveau;
    }

    public void displayStats(){
        System.out.println("Statistiques de l'ennemi : \n Attaque : \t" + attaque_base + "\n PV : \t" + pv_base + "\n Défense : \t" + défense_base + "\n Maitrise élémentaire : \t" + maîtriseElem_base);
    }

    public int getPV(){
        return pv_base;
    }
    public void setPV(int newPV){
        pv_base = newPV;
        return;
    }

    public String getElementEnnemi(){
        return element;
    }

    public int getAttaque() {
        return attaque_base;
    }

    public int getmaîtriseElem() {
        return maîtriseElem_base;
    }

    public String getElement() {
        return element;
    }
}
