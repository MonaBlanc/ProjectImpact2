package Personnages;

public class Heros {

        protected String nom;
        protected String element;
        public int niveau;
        public int exp;
        protected int attaque_base;
        protected int pv_base;
        protected int défense_base;
        protected int maîtriseElem_base;
        protected Arme arme; //changera les stats en fonction de l'arme
        protected int attaque_total;
        protected int pv_total;
        protected int pv_total_init;

        protected int défense_total;
        protected int maîtriseElem_total;


        public Heros(String nom, int niveau, Arme arme, String element)
        {
            this.nom = nom;
            this.niveau = niveau;
            this.arme = arme;
            this.element = element;
            attaque_total = 40 + arme.attaque_arme + (niveau+1)*10;
            pv_total = 300 + arme.pv_arme + (niveau+1)*10;
            pv_total_init = 300 + arme.pv_arme + (niveau+1)*10;
            défense_total = 20 + arme.défense_arme + (niveau+1)*10;
            maîtriseElem_total = 0 + arme.maîtriseElem_arme + (niveau+1)*10;
        }


        public String toString() {
            return nom;
        }

        public void displayStats(){
            System.out.println("Statistiques du personnage : \n Attaque : \t" + attaque_total + "\n PV : \t" + pv_total + "\n Défense : \t" + défense_total + "\n Maitrise élémentaire : \t" + maîtriseElem_total);
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
        maîtriseElem_total = newME;
    }

        public String getElement(){
            return element;
        }

        public int getAttaque(){
            return attaque_total;
        }

    public int getmaîtriseElem() {
        return maîtriseElem_total;
    }
}
