package Objets;

/**
 * Classe permettant de créer un ennemi
 */
public class Ennemis extends Personnages {

    public int niveau; //Allant de 10 en 10 en général

    //TODO : En fonction du type d'ennemi avec un switch case
    /**
     * Constructeur
     * @param nom Nom de l'ennemi (type)
     * @param niveau Niveau de l'ennemi
     * @param element Element de l'ennemi
     */
    public Ennemis(String nom, int niveau, String element)
    {
        this.nom = nom;
        this.niveau = niveau;
        this.element = element;
        attaque_total = 20 + niveau;
        pv_total = 290 + niveau;
        défense_total = 5 + niveau;
        maitriseElem_total = 10 + niveau;
    }

    /**
     * Fonction permettant d'afficher les statistiques de l'ennemi quand elle est appelée
     */
    public void displayStats(){
        System.out.println("Statistiques de l'ennemi : \n Attaque : \t" + attaque_total + "\n PV : \t" + pv_total + "\n Défense : \t" + défense_total + "\n Maitrise élémentaire : \t" + maitriseElem_total);
    }

}
