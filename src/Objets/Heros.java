package Objets;

/**
 * Classe permettant de créer un héros
 */
public class Heros extends Personnages {

        protected int pv_base = 300;
        protected int attaque_base = 40;
        protected int défense_base = 20;
        protected int maîtriseElem_base = 0;
        protected Arme arme; //changera les stats en fonction de l'arme


    /**
     * Constructeur
     * @param nom Nom du héros
     * @param arme Arme du héros qui gère sa classe et ses niveaux
     * @param element Element du héros
     */
        public Heros(String nom, Arme arme, String element)
        {
            this.nom = nom;
            this.arme = arme;
            this.element = element;
            attaque_total = attaque_base + arme.attaque_arme + (arme.niveau+1)*5;
            pv_total = pv_base + arme.pv_arme + (arme.niveau+1)*5;
            pv_total_init = pv_base + arme.pv_arme + (arme.niveau+1)*5;
            défense_total = défense_base + arme.defense_arme + (arme.niveau+1)*5;
            maitriseElem_total = maîtriseElem_base + arme.maitriseElem_arme + (arme.niveau+1)*5;
        }

    /**
     * Fonction permettant d'afficher les statistiques du héros quand elle est appelée
     */
    public void displayStats(){
        System.out.println("Statistiques du personnage : \n Attaque : \t" + attaque_total + "\n PV : \t" + pv_total + "\n Défense : \t" + défense_total + "\n Maitrise élémentaire : \t" + maitriseElem_total);
    }

    public Arme getArme(){
        return arme;
    }


}
