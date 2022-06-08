package Personnages;

public class Heros {

        protected String nom;
        protected String element;
        public int niveau;
        protected int attaque_base;
        protected int pv_base;
        protected int défense_base;
        protected int maîtriseElem_base;
        protected Arme arme; //changera les stats en fonction de l'arme
        protected int attaque_total;
        protected int pv_total;
        protected int défense_total;
        protected int maîtriseElem_total;


        public Heros(String nom, int niveau, Arme arme, String element)
        {
            this.nom = nom;
            this.niveau = niveau;
            this.arme = arme;
            this.element = element;
            attaque_total = 40 + arme.attaque_arme; // + dégât de l'arme
            pv_total = 300 + arme.pv_arme; // + dégât de l'arme
            défense_total = 20 + arme.défense_arme; // + dégât de l'arme
            maîtriseElem_total = 0 + arme.maîtriseElem_arme; // + dégât de l'arme
        }

        //TODO : Fonction affichant les caractéristiques
        public String toString() {
            return nom;
        }

        public void displayStats(){
            System.out.println("Statistiques du personnage : \n Attaque : \t" + attaque_total + "\n PV : \t" + pv_total + "\n Défense : \t" + défense_total + "\n Maitrise élémentaire : \t" + maîtriseElem_total);
        }

        public int getPV(){
            return pv_total;
        }

        public void setPV(int newPV){
            pv_total = newPV;
            return;
        }

        //TODO : Chercher pourquoi l'élément est nul
        public String getElement(){
            return element;
        }

        public int getAttaque(){
            return attaque_total;
        }

    }
