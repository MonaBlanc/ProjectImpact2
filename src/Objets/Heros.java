package Objets;

public class Heros extends Personnages {

        public int niveau;
        public int exp;
        protected int pv_base = 300;
        protected int attaque_base = 40;
        protected int défense_base = 20;
        protected int maîtriseElem_base = 0;
        protected Arme arme; //changera les stats en fonction de l'arme



        public Heros(String nom, int niveau, Arme arme, String element)
        {
            this.nom = nom;
            this.niveau = niveau;
            this.arme = arme;
            this.element = element;
            attaque_total = attaque_base + arme.attaque_arme + (niveau+1)*10;
            pv_total = pv_base + arme.pv_arme + (niveau+1)*10;
            pv_total_init = pv_base + arme.pv_arme + (niveau+1)*10;
            défense_total = défense_base + arme.défense_arme + (niveau+1)*10;
            maitriseElem_total = maîtriseElem_base + arme.maîtriseElem_arme + (niveau+1)*10;
        }

    public void displayStats(){
        System.out.println("Statistiques du personnage : \n Attaque : \t" + attaque_total + "\n PV : \t" + pv_total + "\n Défense : \t" + défense_total + "\n Maitrise élémentaire : \t" + maitriseElem_total);
    }

}
