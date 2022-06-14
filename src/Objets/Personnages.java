package Objets;

public abstract class Personnages {

    protected String nom;
    protected int attaque_total;
    protected int pv_total;
    protected int pv_total_init;
    protected int défense_total;
    protected int maitriseElem_total;
    protected String element;



    public String toString() {
        return nom;
    }
    public int getPV(){
        return pv_total;
    }
    public int getPVInit(){
        return pv_total_init;
    }
    public void setPV(int newPV){
        pv_total = newPV;
    }
    public void setAttaque(int newAttaque){
        attaque_total = newAttaque;
    }
    public void setMaitriseElem(int newME){
        maitriseElem_total = newME;
    }
    public String getElement(){
        return element;
    }
    public int getAttaque(){
        return attaque_total;
    }
    public int getMaitriseElem() {
        return maitriseElem_total;
    }
}


